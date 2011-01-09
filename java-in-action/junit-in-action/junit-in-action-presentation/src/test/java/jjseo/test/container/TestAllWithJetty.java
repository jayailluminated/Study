package jjseo.test.container;

import jjseo.test.cactus.HtmlUnitServletTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.cactus.extension.jetty.Jetty5xTestSetup;

/**
 *
 * @author <a href="mailto:ggregory@apache.org">Gary Gregory</a>
 * @version $Id: TestAllWithJetty.java 397 2009-04-30 19:00:19Z garydgregory $
 */
public class TestAllWithJetty {
    public static Test suite() {
        System.setProperty("cactus.contextURL", "http://localhost:8080/test");
        TestSuite suite = new TestSuite("All tests with Jetty");
        suite.addTestSuite(HtmlUnitServletTestCase.class);
        return new Jetty5xTestSetup(suite);
    }
}
