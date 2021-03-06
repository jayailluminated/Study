package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.connection.ConnectionMaker;
import springbook.user.domain.User;

public class UserDaoUsingConnectionMaker {
	private ConnectionMaker connectionMaker;


	// public UserDao(ConnectionMaker connectionMaker) {
	// this.connectionMaker = connectionMaker;
	// }

	public ConnectionMaker getConnectionMaker() {
		return connectionMaker;
	}

	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {


		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password, level, login, recommend) values(?,?,?,?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setInt(4, user.getLevel().intValue());
		ps.setInt(5, user.getLogin());
		ps.setInt(6, user.getRecommend());

		ps.executeUpdate();

		ps.close();

		c.close();

	}

	public User get(String id) throws ClassNotFoundException, SQLException {

//		Connection c = getConnection();
//		Connection c = simpleConnectionMaker.makeNewConnection();
		Connection c = connectionMaker.makeConnection();
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

	/**
	 * このクラスの具現はサブクラスが担当する。
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
//	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

}
