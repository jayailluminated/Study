package springbook.user.dao;

import java.sql.SQLException;

import springbook.user.domain.User;


public class UserDaoTest {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMaker = new NConnectionMaker();
		UserDao dao = new UserDao(connectionMaker);
		
		User user = new User();
		user.setId("jjseo");
		user.setName("정주");
		user.setPassword("1111");
		
		dao.add(user);
		
		System.out.println(user.getId()+ "success");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		
	}
}
