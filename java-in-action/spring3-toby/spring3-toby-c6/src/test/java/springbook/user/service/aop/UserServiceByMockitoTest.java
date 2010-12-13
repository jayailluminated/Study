package springbook.user.service.aop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import springbook.user.dao.IUserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.Matchers.any;

import static org.hamcrest.CoreMatchers.is;

import static springbook.user.service.aop.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.aop.UserServiceImpl.MIN_RECOMMEND_FOR_GOLD;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext_aop_transaction.xml")
public class UserServiceByMockitoTest {
	@Autowired
	UserService userService;

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	IUserDao userDao;

	@Autowired
	MailSender mailSender;

	@Autowired PlatformTransactionManager transactionManager;

	List<User> users;	// test fixture

	@Before
	public void setUp() {
		users = Arrays.asList(
				new User("bumjin", "あ", "p1", "jjseo@c-square.co.jp", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0),
				new User("joytouch", "い", "p2", "jjseo@c-square.co.jp", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
				new User("erwins", "う", "p3", "jjseo@c-square.co.jp", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD - 1),
				new User("madnite1", "え", "p4", "jjseo@c-square.co.jp", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD),
				new User("green", "お", "p5", "jjseo@c-square.co.jp", Level.GOLD, 100, Integer.MAX_VALUE)
				);
	}

	@Test
	public void mockUpgradeLevels() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();

		IUserDao mockUserDao = mock(IUserDao.class);
		when(mockUserDao.getAll()).thenReturn(this.users);
		userServiceImpl.setUserDao(mockUserDao);

		MailSender mockMailSender = mock(MailSender.class);
		userServiceImpl.setMailSender(mockMailSender);

		userServiceImpl.upgradeLevels();

		verify(mockUserDao, times(2)).update(any(User.class));
		verify(mockUserDao, times(2)).update(any(User.class));
	}

	@Test @DirtiesContext
	public void upgradeLevels() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();

		MockUserDao mockUserDao = new MockUserDao(this.users);
		userServiceImpl.setUserDao(mockUserDao);

		//userDao.deleteAll();
		//for(User user : users) userDao.add(user);

		MockMailSender mockMailSender = new MockMailSender();
		userServiceImpl.setMailSender(mockMailSender);

		userServiceImpl.upgradeLevels();

		List<User> updated = mockUserDao.getUpdated();
		assertThat(updated.size(), is(2));
		checkUserAndLevel(updated.get(0), "joytouch", Level.SILVER);
		checkUserAndLevel(updated.get(1), "madnite1", Level.GOLD);

		//		checkLevelUpgraded(users.get(0), false);
		//		checkLevelUpgraded(users.get(1), true);
		//		checkLevelUpgraded(users.get(2), false);
		//		checkLevelUpgraded(users.get(3), true);
		//		checkLevelUpgraded(users.get(4), false);

		List<String> request = mockMailSender.getRequests();
		assertThat(request.size(), is(2));
		assertThat(request.get(0), is(users.get(1).getEmail()));
		assertThat(request.get(1), is(users.get(3).getEmail()));
	}

	private void checkUserAndLevel(User updated, String expectedId, Level expectedLevel) {
		assertThat(updated.getId(), is(expectedId));
		assertThat(updated.getLevel(), is(expectedLevel));
	}

	static class MockMailSender implements MailSender {
		private final List<String> requests = new ArrayList<String>();

		public List<String> getRequests() {
			return requests;
		}

		@Override
		public void send(SimpleMailMessage mailMessage) throws MailException {
			requests.add(mailMessage.getTo()[0]);
		}

		@Override
		public void send(SimpleMailMessage[] mailMessage) throws MailException {
		}
	}

	static class MockUserDao implements IUserDao {
		private final List<User> users;
		private final List<User> updated = new ArrayList<User>();

		private MockUserDao(List<User> users) {
			this.users = users;
		}

		@Override
		public List<User> getAll() {
			return this.users;
		}

		@Override
		public void update(User user) {
			updated.add(user);
		}

		public List<User> getUpdated() {
			return this.updated;
		}

		@Override
		public int getCount() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int getCount2() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(User user) {
			throw new UnsupportedOperationException();
		}

		@Override
		public User get(String id) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void deleteAll() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void deleteAll2() {
			throw new UnsupportedOperationException();
		}


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

		User userWithLevel = users.get(4); // GOLD ÂÇæÂ©ö
		User userWithoutLevel = users.get(0);
		userWithoutLevel.setLevel(null);

		userServiceImpl.add(userWithLevel);
		userServiceImpl.add(userWithoutLevel);

		User userWithLevelRead = userDao.get(userWithLevel.getId());
		User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

		assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
		assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));
	}

	@Test
	public void upgradeAllOrNothing() {
		TestUserService testUserService = new TestUserService(users.get(3).getId());
		testUserService.setUserDao(this.userDao);
		testUserService.setMailSender(this.mailSender);

		UserServiceTxImpl txUserService = new UserServiceTxImpl();
		txUserService.setTransactionManager(this.transactionManager);
		txUserService.setUserService(testUserService);

		userDao.deleteAll();
		for(User user : users) userDao.add(user);

		try {
			txUserService.upgradeLevels(); // ※トランザクション機能を分離したオブジェクトを通してTestUserServiceが呼び出されるようにする。
			fail("TestUserServiceException expected");
		} catch (TestUserServiceException e) {

		}

		checkLevelUpgraded(users.get(1), false);
	}


	static class TestUserService extends UserServiceImpl {
		private final String id;

		private TestUserService(String id) {
			this.id = id;
		}

		@Override
		protected void upgradeLevel(User user) {
			if (user.getId().equals(this.id))
				throw new TestUserServiceException();
			super.upgradeLevel(user);
		}
	}

	static class TestUserServiceException extends RuntimeException {
	}



}

