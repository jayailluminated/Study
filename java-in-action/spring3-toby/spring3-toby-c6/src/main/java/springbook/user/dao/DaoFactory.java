package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbook.user.connection.ConnectionMaker;
import springbook.user.connection.DConnectionMaker;

@Configuration
public class DaoFactory {
	@Bean
	public UserDaoUsingConnectionMaker userDao() {
		// return new UserDao(connectionMaker());
		UserDaoUsingConnectionMaker userDao = new UserDaoUsingConnectionMaker();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}

	@Bean
	public AccountDao accountDao() {
		return new AccountDao(connectionMaker());
	}

	@Bean
	public MessageDao messageDao() {
		return new MessageDao(connectionMaker());
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
