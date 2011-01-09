package jjseo.test.selenium;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

/**
 * Tests a form. The Selenium server must be managed elsewhere.
 * <p>
 * Maven will not pick up this test because it does not start or end with "Test"
 * or end with "TestCase".
 * </p>
 * <p>
 * To test the form in IE, create a virtual directory in IIS and point your
 * browser and tests to http://localhost/webapp/formtest.html
 * </p>
 *
 * @author <a href="mailto:ggregory@apache.org">Gary Gregory</a>
 * @version $Id$
 */
public class UnmanagedFormTester {
    private static final String APP_WINDOW = "selenium.browserbot.getCurrentWindow()";

    private static final String EXPECTED_MSG = "Hello World";

    /**
     * The directory /ch13-ajax/src/main/webapp has been configured as an IIS
     * virtual directory for this test.
     */
    private static final String TEST_URL = "http://localhost/webapp/";

    private static final String TEST_PAGE = "formtest.html";

    private static Selenium selenium;

    @BeforeClass
    public static void setUpOnce() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*iexplore", TEST_URL);
        selenium.start();
    }

    @AfterClass
    public static void tearDownOnce() throws Exception {
        if (selenium != null) {
            selenium.stop();
        }
        selenium = null;
    }

    @Test
    public void testFormBad() throws IOException {
        selenium.open(TEST_PAGE);
        selenium.click("name=getMsgBtn");
        String actualMsg = selenium.getText("name=serverMessage");
        // The message is not there!
        Assert.assertFalse(EXPECTED_MSG.equals(actualMsg));
    }

    @Test
    public void testFormBad2() throws IOException, InterruptedException {
        selenium.open(TEST_PAGE);
        selenium.click("name=getMsgBtn");
        Thread.sleep(2000);
        String actualMsg = selenium.getText("name=serverMessage");
        // The message is not there!
        Assert.assertFalse(EXPECTED_MSG.equals(actualMsg));
    }

    @Test
    public void testFormWithJavaScript() throws IOException {
        selenium.open(TEST_PAGE);
        selenium.click("name=getMsgBtn");
        selenium.waitForCondition(APP_WINDOW + ".document.helloForm.serverMessage.value=='" + EXPECTED_MSG + "'", "1000");
    }

}
