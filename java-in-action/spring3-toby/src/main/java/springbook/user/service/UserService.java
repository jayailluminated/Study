package springbook.user.service;

import java.util.List;

import springbook.spring3.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserService {
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Deprecated
	public void upgradeLevels() {
		List<User> users = userDao.getAll();

		for (User user : users) {
			Boolean changed = null;
			if (user.getLevel() == Level.BASIC && user.getLogin() >= 50) {
				user.setLevel(Level.SILVER);
				changed = true;
			} else if (user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
				user.setLevel(Level.GOLD);
				changed = true;
			} else if (user.getLevel() == Level.GOLD) {
				changed = false;
			} else {
				changed = false;
			}

			if (changed)
				userDao.update(user);
		}
	}

	public void simpleUpgradeLevels() {
		List<User> users = userDao.getAll();
		for (User user : users) {
			if (canUpgradeLevel(user)) {
				upgradelevel(user);
			}
		}
	}

	//private void upgradelevel(User user) {

	/**
	 * テストのため private ⇒ protectedに変更
	 * @param user
	 */
	protected void upgradelevel(User user) {
		// next levelの判断はenumに任せる
//		if (user.getLevel() == Level.BASIC)
//			user.setLevel(Level.SILVER);
//		else if (user.getLevel() == Level.SILVER)
//			user.setLevel(Level.GOLD);
		user.upgradeLevel();
		userDao.update(user);
	}

	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECOMMEND_FOR_GOLD = 30;

	private boolean canUpgradeLevel(User user) {
		Level currentLevel = user.getLevel();
		switch (currentLevel) {
		case BASIC:
			return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
		case SILVER:
			return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
		case GOLD:
			return false;
		default:
			throw new IllegalArgumentException("Unknow Level:" + currentLevel);
		}
	}

	/**
	 * @param user
	 */
	public void add(User user) {
		if (user.getLevel() == null)
			user.setLevel(Level.BASIC);
		userDao.add(user);

	}
}
