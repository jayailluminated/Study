package apache.common;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

/**
 * User: moretajoo
 * Date: May 18, 2010
 * Time: 1:30:51 AM
 */
public class FileDirectoryTest {

	@Before
	public void setUp () {
	}

	@After
	public void tearDown () {
	}

	@Test
	public void testFileDirectoryTest () throws IOException {
		FileDirectory fd = new FileDirectory();
		assertEquals("/Users/moretajoo/Workspaces/Study/java-in-action", fd.getDirectoryPath());
	}
}