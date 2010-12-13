package springbook.user.service.aop;

import springbook.user.domain.User;

public interface UserServicePointcut {
	void add(User user);

	void upgradeLevels();
}
