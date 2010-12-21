package jjseo.test.ajax;

import java.io.IOException;

import jjseo.test.htmlunit.ManagedWebClient;

import org.junit.Assert;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import static org.junit.Assert.assertEquals;

/**
 * Tests a form.
 * <p>
 * To test the form in IE, create a virtual directory in IIS, use the permission
 * wizard to grant default rights, and point your browser and tests to
 * http://localhost/webapp/formtest.html
 * </p>
 *
 * @author <a href="mailto:ggregory@apache.org">Gary Gregory</a>
 * @version $Id$
 */
public class AjaxFormTest extends ManagedWebClient {

    private static final String EXPECTED_MSG = "Hello World";

    /**
     * The directory /ch13-ajax/src/main/webapp has been configured as an IIS
     * virtual directory for this test.
     */
    private static final String TEST_URL = "http://localhost:8080/test/formtest-ajax.html";

    @Test
    public void testAjaxForm() throws IOException {
        // NicelyResynchronizingAjaxController class work together
        // call turn asynchronous Ajax calls into synchronous.
        this.webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = (HtmlPage) this.webClient.getPage(TEST_URL);
        HtmlButtonInput button = (HtmlButtonInput) page.getFirstByXPath("/html/body/form/input[1]");
        HtmlPage newPage = button.click();
        HtmlInput reply = (HtmlInput) newPage.getFirstByXPath("/html/body/form/input[2]");

        assertEquals(EXPECTED_MSG, reply.asText());
        //Assert.assertTrue(EXPECTED_MSG.equals(reply.asText()));
    }

    @Test
    public void testAjaxFormOutOfSync() throws IOException {
        HtmlPage page = (HtmlPage) this.webClient.getPage(TEST_URL);
        HtmlButtonInput button = (HtmlButtonInput) page.getFirstByXPath("/html/body/form/input[1]");
        HtmlPage newPage = button.click();
        HtmlInput reply = (HtmlInput) newPage.getFirstByXPath("/html/body/form/input[2]");

        assertEquals(EXPECTED_MSG, reply.asText());
        //Assert.assertFalse(EXPECTED_MSG.equals(reply.asText()));
    }

    @Test
    public void testAjaxFormWaitForBackgroundJavaScript() throws IOException {
        HtmlPage page = (HtmlPage) this.webClient.getPage(TEST_URL);
        HtmlButtonInput button = (HtmlButtonInput) page.getFirstByXPath("/html/body/form/input[1]");
        HtmlPage newPage = button.click();
        this.webClient.waitForBackgroundJavaScript(1000);
        HtmlInput reply = (HtmlInput) newPage.getFirstByXPath("/html/body/form/input[2]");

        assertEquals(EXPECTED_MSG, reply.asText());
        //Assert.assertTrue(EXPECTED_MSG.equals(reply.asText()));
    }
}