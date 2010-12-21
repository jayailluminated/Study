package jjseo.test.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs {@link UnmanagedFormChecker} while managing a Selenium server.
 *
 * @author <a href="mailto:ggregory@apache.org">Gary Gregory</a>
 * @version $Id$
 */
@RunWith(ManagedSeleniumServerSuite.class)
@SuiteClasses( { UnmanagedFormTester.class })
public class ManagedFormTest {
    // See annotations.
}
