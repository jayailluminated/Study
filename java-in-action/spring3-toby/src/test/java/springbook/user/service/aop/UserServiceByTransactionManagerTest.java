package springbook.user.service.aop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
@ContextConfiguration(locations = "/applicationContext_aop_transactionManager.xml")
public class UserServiceByTransactionManagerTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserServiceAnnotation userService;
	@Autowired
	UserServiceAnnotation testUserService;

	//@Autowired
	//UserServiceImpl userServiceImpl;

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

	@Test
	public void upgradeLevels() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();

		MockUserDao mockUserDao = new MockUserDao(this.users);
		userServiceImpl.setUserDao(mockUserDao);

		MockMailSender mockMailSender = new MockMailSender();
		userServiceImpl.setMailSender(mockMailSender);

		userServiceImpl.upgradeLevels();

		List<User> updated = mockUserDao.getUpdated();
		assertThat(updated.size(), is(2));
		checkUserAndLevel(updated.get(0), "joytouch", Level.SILVER);
		checkUserAndLevel(updated.get(1), "madnite1", Level.GOLD);

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

		userService.add(userWithLevel);
		userService.add(userWithoutLevel);

		User userWithLevelRead = userDao.get(userWithLevel.getId());
		User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

		assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
		assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));
	}

	@Test
	public void upgradeAllOrNothing() {
		userDao.deleteAll();
		for (User user : users)
			userDao.add(user);

		try {
			this.testUserService.upgradeLevels(); // ※トランザクション機能を分離したオブジェクトを通してTestUserServiceが呼び出されるようにする。
			fail("TestUserServiceException expected");
		} catch (TestUserServiceException e) {
			logger.debug("exception occur");
		}

		checkLevelUpgraded(users.get(1), false);
	}

	/**
	 * 自動生成されたプロクシを確認
	 */
	@Test
	public void advisorAutoProxyCreator() {
		assertThat(testUserService, is(java.lang.reflect.Proxy.class));
	}

	@Test(expected = UncategorizedSQLException.class)
	//@Test(expected = TransientDataAccessResourceException.class) // postgresqlの場合 UncategorizedSQLExceptionが発生する。
	public void readOnlyTransactionAttribute() {
		testUserService.getAll();
	}

	/**
	 * @author moretajoo
	 * 変更① advisorから認識できるよるクラス名を変更
	 * このクラスはspring beanとして登録
	 * applicationContext_aop_classfilter.xml
	 */
	//static class TestUserService extends UserServiceImpl {
	static class TestUserServiceImpl extends UserServiceAnnotationImpl {
		//private final String id;
		private final String id = "madnite1";

		@Override
		protected void upgradeLevel(User user) {
			if (user.getId().equals(this.id))
				throw new TestUserServiceException();
			super.upgradeLevel(user);
		}

		/* (non-Javadoc)
		 * 읽기 전용 트랜잭션의 대상
		 */
		@Override
		public List<User> getAll() {
			for (User user : super.getAll()) {
				super.update(user); //　ここでexceptionが発生
			}
			return null;
		}
	}

	static class TestUserServiceException extends RuntimeException {
	}

	@Test
	public void transactionSyncRollback() {
		DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
		TransactionStatus txStatus = transactionManager.getTransaction(txDefinition);

		try {
			userService.deleteAll();
			userService.add(users.get(0));
			userService.add(users.get(1));
		} finally {
			transactionManager.rollback(txStatus);
		}
	}

	@Test(expected = UncategorizedSQLException.class)
	public void transactionSync() {
		DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
		txDefinition.setReadOnly(true);

		TransactionStatus txStatus = transactionManager.getTransaction(txDefinition);

		userService.deleteAll();
		userService.add(users.get(0));
		userService.add(users.get(1));

		transactionManager.commit(txStatus);
	}



	@Test(expected = UncategorizedSQLException.class)
	@Transactional(readOnly = true)
	public void transactionSyncAnnotation() {
		userService.deleteAll();
		userService.add(users.get(0));
		userService.add(users.get(1));
	}

}

