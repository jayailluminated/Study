package com.example.tests;

import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

public class NewTest extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://www.google.com/", "*safari");
//		setUp("http://www.google.com/", "*chrome");
	}
	public void testUntitled() throws Exception {
		selenium.open("/");
		selenium.type("q", "selenium rc");
		selenium.click("btnG");
		selenium.waitForPageToLoad("3000");
		assertTrue(selenium.isTextPresent("Selenium Remote-Control"));
	}
}
