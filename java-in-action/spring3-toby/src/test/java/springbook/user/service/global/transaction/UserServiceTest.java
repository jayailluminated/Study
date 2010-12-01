package springbook.user.service.global.transaction;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static springbook.user.service.UserService.*;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext_global_transaction.xml")
public class UserServiceTest {
	@Autowired
	UserService userService;
	@Autowired
	IUserDao userDao;
	@Autowired
	MailSender mailSender;
	@Autowired PlatformTransactionManager transactionManager;

	List<User> users;	// test fixture

	@Before
	public void setUp() {
		users = Arrays.asList(
				new User("bumjin", "あ", "p1", "moretajoo@gmail.com", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0),
				new User("joytouch", "い", "p2", "moretajoo@gmail.com", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
				new User("erwins", "う", "p3", "moretajoo@gmail.com", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD - 1),
				new User("madnite1", "え", "p4", "moretajoo@gmail.com", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD),
				new User("green", "お", "p5", "jjseo@c-square.co.jp", Level.GOLD, 100, Integer.MAX_VALUE)
				);
	}

	@Test @DirtiesContext
	public void upgradeLevels() {
		userDao.deleteAll();
		for(User user : users) userDao.add(user);

		MockMailSender mockMailSender = new MockMailSender();
		userService.setMailSender(mockMailSender);

		userService.upgradeLevels();

		checkLevelUpgraded(users.get(0), false);
		checkLevelUpgraded(users.get(1), true);
		checkLevelUpgraded(users.get(2), false);
		checkLevelUpgraded(users.get(3), true);
		checkLevelUpgraded(users.get(4), false);

		List<String> request = mockMailSender.getRequests();
		assertThat(request.size(), is(2));
		assertThat(request.get(0), is(users.get(1).getEmail()));
		assertThat(request.get(1), is(users.get(3).getEmail()));
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
		UserService testUserService = new TestUserService(users.get(3).getId());
		testUserService.setUserDao(this.userDao);
		testUserService.setTransactionManager(this.transactionManager);
		testUserService.setMailSender(this.mailSender);

		userDao.deleteAll();
		for(User user : users) userDao.add(user);

		try {
			testUserService.upgradeLevels();
			fail("TestUserServiceException expected");
		} catch (TestUserServiceException e) {

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
			if (user.getId().equals(this.id))
				throw new TestUserServiceException();
			super.upgradeLevel(user);
		}
	}

	static class TestUserServiceException extends RuntimeException {
	}



}

