package jjseo.test.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

/**
 * A Selenium test based on JUnit 4 which requires that the Selenium server be
 * managed elsewhere.
 * <p>
 * Maven will pick up this test so it must be excluded in pom.xml.
 * </p>
 * 
 * @author <a href="mailto:ggregory@apache.org">Gary Gregory</a>
 * @version $Id$
 */
public class UnmanagedFirstTestJUnit4 {
    private static Selenium selenium;

    @BeforeClass
    public static void setUpOnce() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*iexplore", "http://www.google.com/");
        selenium.start();
    }

    @AfterClass
    public static void tearDownOnce() throws Exception {
        if (selenium != null) {
            selenium.stop();
        }
        selenium = null;
    }

    private void captureScreenshot(Throwable t) throws Throwable {
        if (selenium != null) {
            String filename = this.getClass().getName() + ".png";
            try {
                selenium.captureScreenshot(filename);
                System.out.println("Saved screenshot " + filename + " for " + t.toString());
            } catch (Exception e) {
                System.err.println("Exception saving screenshot " + filename + " for " + t.toString() + ": " + e.toString());
                e.printStackTrace();
            }
            throw t;
        }
    }

    public void testSearch() {
        selenium.open("/");
        SeleneseTestCase.assertEquals("Google", selenium.getTitle());
        selenium.type("q", "Manning Publishing Co.");
        selenium.click("btnG");
        selenium.waitForPageToLoad("30000");
        SeleneseTestCase.assertEquals("Manning Publishing Co. - Google Search", selenium.getTitle());
        selenium.click("link=Manning Publications Co.");
        selenium.waitForPageToLoad("30000");
        SeleneseTestCase.assertEquals("Manning Publications Co.", selenium.getTitle());
    }

    @Test
    public void testSearchOnErrSaveScreen() throws Throwable {
        try {
            this.testSearch();
        } catch (Throwable t) {
            this.captureScreenshot(t);
        }
    }
}
