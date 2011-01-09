package jjseo.test.container;

import org.apache.cactus.extension.jetty.Jetty5xTestSetup;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestAllWithJetty {
    public static Test suite() {
        System.setProperty("cactus.contextURL", "http://localhost:8080/test");

        TestSuite suite = new TestSuite("All tests with Jetty");
        suite.addTestSuite(TestSampleServletIntegration.class);
        return new Jetty5xTestSetup(suite);
    }
}
