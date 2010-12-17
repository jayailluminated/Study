package jjseo.test.selenium;

import org.junit.Test;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 *
 * @author <a href="mailto:ggregory@apache.org">Gary Gregory</a>
 * @version $Id$
 */
public class ManagedTestJUnit4v2 extends ManagedSeleniumServer {

    public void testSearch() {
        selenium.open("/");
        SeleneseTestCase.assertEquals("Google", selenium.getTitle());
        selenium.type("q", "Manning Publishing Co.");
        selenium.click("btnG");
        selenium.waitForPageToLoad("30000");
        SeleneseTestCase.assertEquals("Manning Publishing Co. - Google 検索", selenium.getTitle());
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
