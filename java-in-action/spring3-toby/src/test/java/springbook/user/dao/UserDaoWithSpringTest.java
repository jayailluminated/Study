package springbook.user.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-applicationContext.xml")
public class UserDaoWithSpringTest {

	@Autowired
	ApplicationContext context;
	@Autowired
	UserDao userDao;

	@Before
	public void setUp() {
	}

	@Test
	public void addAndGet() throws SQLException {

		UserDao userDao = context.getBean("userDao", UserDao.class);

		User user1 = new User("id", "name", "pass");
		User user2 = new User("id2", "name2", "pass2");

		userDao.deleteAll(); // 削除
		assertThat(userDao.getCount(), is(0)); // カウント

		userDao.add(user1);
		userDao.add(user2);
		assertThat(userDao.getCount(), is(2)); // 1件追加

		User userget1 = userDao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));
		
		
		User userget2 = userDao.get(user1.getId());
		assertThat(userget2.getName(), is(user1.getName()));
		assertThat(userget2.getPassword(), is(user1.getPassword()));
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException {
		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));

		userDao.get("unknown id ");
	}

	@Test
	public void count() throws SQLException {
		User user1 = new User("a", "あ", "い");
		User user2 = new User("b", "た", "ち");
		User user3 = new User("c", "は", "ひ");

		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));

		userDao.add(user1);
		assertThat(userDao.getCount(), is(1));

		userDao.add(user2);
		assertThat(userDao.getCount(), is(2));

		userDao.add(user3);
		assertThat(userDao.getCount(), is(3));

	}
}
