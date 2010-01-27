import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Simple test using the WicketTester
 */
public class TestJdbc extends TestCase {

	private Connection connection;

	@Before
	public void setUp() throws ClassNotFoundException, SQLException {
		Class driverClass = Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres");

	}

	@After
	public void tearDown() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	@Test
	public void testJDBC() {
		try {
			Statement stmt = connection.createStatement();

			String sql = "select * from member";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);

			String username = null;
			while (rs.next()) {
				username = rs.getString("username");
				System.out.println(username);
				assertEquals("test", username);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

	}
}
