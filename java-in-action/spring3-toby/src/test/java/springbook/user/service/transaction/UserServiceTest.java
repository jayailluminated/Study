package springbook.user.service.transaction;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static springbook.user.service.transaction.UserService.*;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

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
@ContextConfiguration(locations = "/applicationContext_transaction.xml")
public class UserServiceTest {
	@Autowired UserService userService;
	@Autowired IUserDao userDao;
	@Autowired DataSource dataSource;

	List<User> users;	// test fixture

	@Before
	public void setUp() {
		users = Arrays.asList(
				new User("bumjin", "서", "p1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0),
				new User("joytouch", "정", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
				new User("erwins", "주", "p3", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD - 1),
				new User("madnite1", "천", "p4", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD),
				new User("green", "재", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
				);
	}

	@Test
	public void upgradeLevels() throws Exception {
		userDao.deleteAll();
		for(User user : users) userDao.add(user);

		userService.upgradeLevels();

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
		}
		else {
			assertThat(userUpdate.getLevel(), is(user.getLevel()));
		}
	}

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

	@Test
	public void upgradeAllOrNothing() throws Exception {
		UserService testUserService = new TestUserService(users.get(3).getId());
		testUserService.setUserDao(this.userDao);
		testUserService.setDataSource(this.dataSource); //springbook.user.service.UserServiceTestとはここが違う。dataSourceが必要。

		userDao.deleteAll();
		for(User user : users) userDao.add(user);

		try {
			testUserService.upgradeLevels();
			fail("TestUserServiceException expected");
		}
		catch(TestUserServiceException e) {
		}

		checkLevelUpgraded(users.get(1), false);
	}


	static class TestUserService extends UserService {
		private final String id;

		private TestUserService(String id) {
			this.id = id;
		}

		@Override
		protected void upgradeLevel(User user) {
			if (user.getId().equals(this.id)) throw new TestUserServiceException();
			super.upgradeLevel(user);
		}
	}

	static class TestUserServiceException extends RuntimeException {
	}



}

