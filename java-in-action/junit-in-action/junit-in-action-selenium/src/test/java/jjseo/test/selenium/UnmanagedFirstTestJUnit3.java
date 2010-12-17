package jjseo.test.selenium;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 * A Selenium-classic test based on JUnit 3 which requires that the Selenium
 * managed elsewhere.
 * <p>
 * Maven will pick up this test so it must be excluded in pom.xml.
 * </p>
 * 
 * @author <a href="mailto:ggregory@apache.org">Gary Gregory</a>
 * @version $Id$
 */
public class UnmanagedFirstTestJUnit3 extends SeleneseTestCase {
    @Override
    public void setUp() throws Exception {
        this.setUp("http://www.google.com/", "*iexplore");
    }

    public void testSearch() {
        this.selenium.open("/");
        SeleneseTestCase.assertEquals("Google", this.selenium.getTitle());
        this.selenium.type("q", "Manning Publishing Co.");
        this.selenium.click("btnG");
        this.selenium.waitForPageToLoad("30000");
        SeleneseTestCase.assertEquals("Manning Publishing Co. - Google Search", this.selenium.getTitle());
        this.selenium.click("link=Manning Publications Co.");
        this.selenium.waitForPageToLoad("30000");
        SeleneseTestCase.assertEquals("Manning Publications Co.", this.selenium.getTitle());
    }
}
