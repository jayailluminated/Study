package springbook.user.service.aop;

import java.util.List;

import springbook.user.domain.User;

public interface UserService {
	void add(User user);

	//transaction test
	User get(String id);

	List<User> getAll();

	void deleteAll();

	void update(User user);

	void upgradeLevels();
}
