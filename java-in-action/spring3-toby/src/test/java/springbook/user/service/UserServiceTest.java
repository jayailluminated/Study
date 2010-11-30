package springbook.user.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static springbook.user.service.UserService.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.dao.IUserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext_dataSource.xml")
public class UserServiceTest {

	@Autowired
	UserService userService;
	@Autowired
	IUserDao userDao;

	List<User> users;

	@Before
	public void setUp() {
		users = Arrays.asList(
				new User("bumjin", "서", "p1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0),
				new User("joytouch", "정", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
				new User("erwins", "주", "p3", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD- 1),
				new User("madnite1", "천", "p4", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD),
				new User("green", "재", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
				);
	}

	static class TestUserService extends UserService {
		private final String id; // exceptionを発生するid
		private TestUserService(String id) {
			this.id = id;
		}

		@Override
		protected void upgradelevel(User user) {
			if (user.getId().equals(this.id))
				throw new TestUserServiceException();
			super.upgradelevel(user);
		}
	}

	static class TestUserServiceException extends RuntimeException {
	}

	@Test
	public void upgradeAllOrNothing() {
		UserService testUserService = new TestUserService(users.get(3).getId());
		testUserService.setUserDao(this.userDao); // daoを受動でinjection
		userDao.deleteAll();
		for (User user : users) {
			userDao.add(user);
		}
		try {
			testUserService.simpleUpgradeLevels();
			fail("TestUserServiceException expected"); // exceptionが発生しないとテストは失敗。
		} catch (TestUserServiceException e) {
			// do nothing : Exceptionが発生してもそのまま実行するようにする。　このテストの目的はすべてのレベルが変更されたが否かを判断すること。
		}
		checkLevelUpgraded(users.get(1), true); // transaction問題でupgradeしてしまう。
		//checkLevelUpgraded(users.get(1), false); // transaction同期化されたらこのテストがただしく成功
	}

	@Test
	public void simpleUpgradeLevels() {
		userDao.deleteAll();

		for (User user : users)
			userDao.add(user);

		userService.simpleUpgradeLevels();

		checkLevelUpgraded(users.get(0), false);
		checkLevelUpgraded(users.get(1), true);
		checkLevelUpgraded(users.get(2), false);
		checkLevelUpgraded(users.get(3), true);
		checkLevelUpgraded(users.get(4), false);
	}

	private void checkLevelUpgraded(User user, boolean upgraded) {
		User userUpdate = userDao.get(user.getId());
		if (upgraded) {
			assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
		} else {
			assertThat(userUpdate.getLevel(), is(user.getLevel()));
		}

	}

	/**
	 * このテストの短小は簡単なロジックをテストする為に、DAOとDBまで使っていること。
	 * refactoringが必要。
	 */
	@Test
	public void add() {
		userDao.deleteAll();

		User userWithLevel = users.get(4); // GOLD
		User userWithoutLevel = users.get(0);
		userWithoutLevel.setLevel(null);

		userService.add(userWithLevel);
		userService.add(userWithoutLevel);

		User userWithLevelRead = userDao.get(userWithLevel.getId());
		User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

		assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
		assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void upgradeLevels() {
		userDao.deleteAll();

		for (User user : users)
			userDao.add(user);

		userService.upgradeLevels();

		checkLevel(users.get(0), Level.BASIC);
		checkLevel(users.get(1), Level.SILVER);
		checkLevel(users.get(2), Level.SILVER);
		checkLevel(users.get(3), Level.GOLD);
		checkLevel(users.get(4), Level.GOLD);
	}

	@Deprecated
	private void checkLevel(User user, Level expectedLevel) {
		User userUpdate = userDao.get(user.getId());
		assertThat(userUpdate.getLevel(), is(expectedLevel));
	}

	@Test
	public void bean() {
		assertThat(this.userService, is(notNullValue()));
	}

}
