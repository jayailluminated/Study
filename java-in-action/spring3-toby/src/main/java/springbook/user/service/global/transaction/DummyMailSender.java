package springbook.user.service.global.transaction;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class DummyMailSender implements MailSender {
	@Override
	public void send(SimpleMailMessage mailMessage) throws MailException {
	}

	@Override
	public void send(SimpleMailMessage[] mailMessage) throws MailException {
	}
}

