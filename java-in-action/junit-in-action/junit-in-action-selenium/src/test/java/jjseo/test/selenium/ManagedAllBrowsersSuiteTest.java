package jjseo.test.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs the test class {@link UnmanagedAllBrowsersTester} while managing a
 * Selenium server with {@link ManagedSeleniumServerSuite}.
 *
 * @author <a href="mailto:ggregory@apache.org">Gary Gregory</a>
 * @version $Id$
 */
@RunWith(ManagedSeleniumServerSuite.class)
@SuiteClasses({ UnmanagedAllBrowsersTester.class })
public class ManagedAllBrowsersSuiteTest {
    // See annotations.
}