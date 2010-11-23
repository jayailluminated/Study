package springbook.spring3.user.dao;

import java.util.List;

import springbook.user.domain.User;

/**
 * @author moretajoo
 *
 *         Userdao applied spring jdbcTemplate!!
 */
public interface UserDao {

	int getCount();

	int getCount2();

	void add(final User user);

	User get(String id);

	List<User> getAll();

	void deleteAll();

	void deleteAll2();

	void update(User user);


}
