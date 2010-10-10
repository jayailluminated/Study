package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

//public class DUserDao  extends UserDao {
	public class DUserDao   {
	public void add(User user) throws ClassNotFoundException, SQLException {


		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();

		c.close();

	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		rs.next();

		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		return user;

	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/spring3";
		String username = "postgres";
		String password = "postgres";
		Class.forName("org.postgresql.Driver");

		Connection c = DriverManager.getConnection(url, username, password);
		
		return c;
	}

}
