package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoConnectionCountingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDaoUsingConnectionMaker dao = context.getBean("userDao", UserDaoUsingConnectionMaker.class);

		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);

		System.out.println("Connection counter : " + ccm.getCounter());

	}

}
