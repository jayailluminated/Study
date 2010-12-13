package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.domain.Level;
import springbook.user.domain.User;


public class UserDaoGenericXmlTest {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

		// ConnectionMaker connectionMaker = new NConnectionMaker();
		// UserDao dao = new UserDao(connectionMaker);
		UserDaoUsingConnectionMaker dao = context.getBean("userDao", UserDaoUsingConnectionMaker.class);

		User user = new User();
		user.setId("jjseo");
		user.setName("정주");
		user.setPassword("1111");
		user.setLevel(Level.GOLD);
		user.setLogin(50);
		user.setRecommend(10);

		dao.add(user);

		System.out.println(user.getId()+ "success");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());

		UserDaoUsingConnectionMaker dao_1 = context.getBean("userDao", UserDaoUsingConnectionMaker.class);
		UserDaoUsingConnectionMaker dao_2 = context.getBean("userDao", UserDaoUsingConnectionMaker.class);
		System.out.println(dao_1);
		System.out.println(dao_2);

	}
}
