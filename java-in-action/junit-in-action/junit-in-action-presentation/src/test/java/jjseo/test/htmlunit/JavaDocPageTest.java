package jjseo.test.htmlunit;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;

public class JavaDocPageTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testClassNav() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        WebClient webClient = new WebClient();
        HtmlPage mainPage = (HtmlPage) webClient.getPage("http://htmlunit.sourceforge.net/apidocs/index.html");
        HtmlPage packagePage = (HtmlPage) mainPage.getFrameByName("packageFrame").getEnclosedPage();

        HtmlPage bVerPage = packagePage.getAnchorByHref("com/gargoylesoftware/htmlunit/BrowserVersion.html").click();

        HtmlParagraph p = (HtmlParagraph) bVerPage.getElementsByTagName("p").item(0);


        logger.debug(p.asText());

        Assert.assertTrue("Unexpected text", p.asText().startsWith(
                "Objects of this class represent one specific version of a given browser."));
        webClient.closeAllWindows();
    }

}
