package springbook.spring3.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springbook.user.domain.User;

/**
 * @author moretajoo
 *
 *         Userdao applied spring jdbcTemplate!!
 */
public class UserDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	public int getCount() {
		return this.jdbcTemplate.queryForInt("select count(*) from users");
	}

	public int getCount2() {
		return this.jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				return con.prepareStatement("select count(*) from users");
			}
		}, new ResultSetExtractor<Integer>() {
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				return rs.getInt(1);
			}
		});
	}

	//	public int getCount() throws SQLException {
	//		Connection c = dataSource.getConnection();
	//
	//		PreparedStatement ps = c.prepareStatement("select count(*) from users");
	//
	//		ResultSet rs = ps.executeQuery();
	//		rs.next();
	//		int count = rs.getInt(1);
	//
	//		rs.close();
	//		ps.close();
	//		c.close();
	//		return count;
	//	}

	public void add(final User user) throws SQLException {
//		this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
//			@Override
//			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
//				PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
//				ps.setString(1, user.getId());
//				ps.setString(2, user.getName());
//				ps.setString(3, user.getPassword());
//				return ps;
//			}
//		});
		this.jdbcTemplate.update("insert into users(id, name, password) values(?,?,?)", user.getId(), user.getName(), user.getPassword());
	}

	//	public User get(String id) throws SQLException {
	//		Connection c = dataSource.getConnection();
	//		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
	//		ps.setString(1, id);
	//
	//		ResultSet rs = ps.executeQuery();
	//
	//		User user = null;
	//		if (rs.next()) {
	//			user = new User();
	//			user.setId(rs.getString("id"));
	//			user.setName(rs.getString("name"));
	//			user.setPassword(rs.getString("password"));
	//
	//		}
	//
	//		if (user == null)
	//			throw new EmptyResultDataAccessException(1);
	//
	//		return user;
	//	}

	public User get(String id) {
		return this.jdbcTemplate.queryForObject("select * from users where id = ?",
				new Object[] { id },
				new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setId(rs.getString("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						return user;
					}
		});
	}

	public List<User> getAll() {
		return this.jdbcTemplate.query("select * from users order by id",
				new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setId(rs.getString("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						return user;
					}

				});
	}

	public void deleteAll() throws SQLException {
		// this.jdbcContext.executeSql("delete from users");
		this.jdbcTemplate.update("delete from users");
	}

	public void deleteAll2() {
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				return con.prepareStatement("delete from users");
			}
		});
	}



}
