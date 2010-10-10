package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

	
	
	/* template method pattern
	 * @see springbook.user.dao.UserDao#getConnection()
	 */
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/spring3";
		String username = "postgres";
		String password = "postgres";
		Class.forName("org.postgresql.Driver");

		Connection c = DriverManager.getConnection(url, username, password);
		
		return c;
	}
}
