package springbook.spring3.user.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import springbook.user.domain.User;

public class UserDaoTest {

	ApplicationContext context;
	UserDao dao;
	User user1;
	User user2;
	User user3;

	@Before
	public void setUp() {
		context = new GenericXmlApplicationContext("applicationContext.xml");
		dao = context.getBean("userDaoSpring", UserDao.class);
		user1 = new User("b-id", "name", "pass");
		user2 = new User("c-id2", "name2", "pass2");
		user3 = new User("a-id3", "name3", "pass3");
	}

	@Test
	public void addAndGet() throws SQLException {
		dao.deleteAll(); // 削除
		assertThat(dao.getCount(), is(0)); // カウント

		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2)); // 1件追加

		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));

		User userget2 = dao.get(user1.getId());
		assertThat(userget2.getName(), is(user1.getName()));
		assertThat(userget2.getPassword(), is(user1.getPassword()));
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException {
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		dao.get("unknown id ");
	}

	@Test
	public void count() throws SQLException {
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		dao.add(user1);
		assertThat(dao.getCount(), is(1));

		dao.add(user2);
		assertThat(dao.getCount(), is(2));

		dao.add(user3);
		assertThat(dao.getCount(), is(3));

	}

	@Test
	public void getAll() throws SQLException {
		dao.deleteAll();

		List<User> users0 = dao.getAll();
		assertThat(users0.size(), is(0));

		dao.add(user1);
		List<User> users1 = dao.getAll();
		assertThat(users1.size(), is(1));
		checkSameUser(user1, users1.get(0));

		dao.add(user2);
		List<User> users2 = dao.getAll();
		assertThat(users2.size(), is(2));
		checkSameUser(user1, users2.get(0));
		checkSameUser(user2, users2.get(1));

		dao.add(user3);
		List<User> users3 = dao.getAll();
		assertThat(users3.size(), is(3));
		checkSameUser(user3, users3.get(0));
		checkSameUser(user1, users3.get(1));
		checkSameUser(user2, users3.get(2));


	}

	private void checkSameUser(User user1, User user2) {
		assertThat(user1.getId(), is(user2.getId()));
		assertThat(user1.getName(), is(user2.getName()));
		assertThat(user1.getPassword(), is(user2.getPassword()));

	}
}
