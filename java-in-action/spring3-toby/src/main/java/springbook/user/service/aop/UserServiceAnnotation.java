package springbook.user.service.aop;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import springbook.user.domain.User;

@Transactional
public interface UserServiceAnnotation {
	void add(User user);

	void deleteAll();

	void update(User user);

	void upgradeLevels();

	//transaction test
	@Transactional(readOnly = true)
	User get(String id);

	@Transactional(readOnly = true)
	List<User> getAll();

}
