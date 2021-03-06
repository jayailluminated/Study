package springbook.user.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.domain.Level;
import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext_daoInterface.xml")
public class IUserDaoTest {

	@Autowired
	IUserDao dao; // UserDao interfaceを継承しているクラスが注入される。
	@Autowired
	DataSource dataSource;

	ApplicationContext context;
	//UserDao dao;
	User user1;
	User user2;
	User user3;

	@Before
	public void setUp() {
		//context = new GenericXmlApplicationContext("applicationContext.xml");
		//dao = context.getBean("userDaoSpring", UserDao.class);
		user1 = new User("b-id", "name", "pass", Level.BASIC, 1, 0);
		user2 = new User("c-id2", "name2", "pass2", Level.SILVER, 55, 10);
		user3 = new User("a-id3", "name3", "pass3", Level.GOLD, 100, 40);
	}

	@Test
	public void addAndGet() throws SQLException {
		dao.deleteAll(); // 削除
		assertThat(dao.getCount(), is(0)); // カウント

		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2)); // 1件追加

		User userget1 = dao.get(user1.getId());
		checkSameUser(userget1, user1);

		User userget2 = dao.get(user2.getId());
		checkSameUser(userget2, user2);
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
		assertThat(user1.getLevel(), is(user2.getLevel()));
		assertThat(user1.getLogin(), is(user2.getLogin()));
		assertThat(user1.getRecommend(), is(user2.getRecommend()));
	}

	@Test(expected = DataAccessException.class)
	public void duplicateKey() {
		dao.deleteAll();

		dao.add(user1);
		dao.add(user1);
	}

	/**
	 * SQLException転換
	 */
	@Test
	public void sqlExceptionTranslate() {
		dao.deleteAll();

		try {
			dao.add(user1);
			dao.add(user1);

		} catch (DuplicateKeyException e) {
			SQLException sqlEx = (SQLException) e.getRootCause();
			SQLExceptionTranslator set = new SQLErrorCodeSQLExceptionTranslator(this.dataSource);

			assertThat(set.translate(null, null, sqlEx), is(DuplicateKeyException.class));
		}
	}

	@Test
	public void update() {
		dao.deleteAll();
		dao.add(user1); // 修正するユーザ
		dao.add(user2); // 修正しないユーザ

		user1.setName("정주");
		user1.setPassword("spring3");
		user1.setLevel(Level.GOLD);
		user1.setLogin(1000);
		user1.setRecommend(999);
		dao.update(user1);

		User user1update = dao.get(user1.getId());
		checkSameUser(user1update, user1);

		User user2same = dao.get(user2.getId());
		checkSameUser(user2same, user2);
	}
}
