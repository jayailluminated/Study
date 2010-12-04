package springbook.user.service.aop;

import springbook.user.domain.User;

public interface UserService {
	void add(User user);

	void upgradeLevels();
}
