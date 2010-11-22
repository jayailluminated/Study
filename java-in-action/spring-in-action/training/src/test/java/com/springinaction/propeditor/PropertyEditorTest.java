package com.springinaction.propeditor;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 27, 2010
 * Time: 9:36:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyEditorTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testPropery() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-propeditor.xml");
		Contact contact = (Contact) ctx.getBean("contactProp");
		PhoneNumber phoneNumber = contact.getPhoneNumber();
		assertEquals("888", phoneNumber.getAreaCode());
		assertEquals("555", phoneNumber.getPrefix());
		assertEquals("1212", phoneNumber.getNumber());
		logger.info("success test : {}", this.getClass());
	}
}
