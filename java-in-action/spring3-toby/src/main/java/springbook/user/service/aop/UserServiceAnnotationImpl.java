package springbook.user.service.aop;

import java.util.List;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import springbook.user.dao.IUserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserServiceAnnotationImpl implements UserServiceAnnotation {
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECOMMEND_FOR_GOLD = 30;

	private IUserDao userDao;
	private MailSender mailSender;


	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}


	@Override
	public void add(User user) {
		if (user.getLevel() == null)
			user.setLevel(Level.BASIC);
		userDao.add(user);
	}

	@Override
	public void upgradeLevels() {
		List<User> users = userDao.getAll();
		for (User user : users) {
			if (canUpgradeLevel(user)) {
				upgradeLevel(user);
			}
		}
	}

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
			throw new IllegalArgumentException("Unknown Level: " + currentLevel);
		}
	}

	protected void upgradeLevel(User user) {
		user.upgradeLevel();
		userDao.update(user);
		sendUpgradeEMail(user);
	}

	private void sendUpgradeEMail(User user) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom("moreta@naver.com");
		mailMessage.setSubject("Upgrade level");
		mailMessage.setText("your level upgraded : " + user.getLevel().name());

		this.mailSender.send(mailMessage);
	}

	@Override
	public User get(String id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void deleteAll() {
		userDao.deleteAll();
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

}

