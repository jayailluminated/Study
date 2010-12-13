package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbook.user.connection.ConnectionMaker;
import springbook.user.connection.DConnectionMaker;

@Configuration
public class CountingDaoFactory {

	@Bean
	public UserDaoUsingConnectionMaker userDao() {
		// return new UserDao(connectionMaker());
		UserDaoUsingConnectionMaker userDao = new UserDaoUsingConnectionMaker();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}

	@Bean
	private ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}

	@Bean
	private ConnectionMaker realConnectionMaker() {
		return new DConnectionMaker();
	}
}
