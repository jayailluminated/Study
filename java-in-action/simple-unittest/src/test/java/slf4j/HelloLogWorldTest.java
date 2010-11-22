package slf4j;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 31, 2010
 * Time: 1:50:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloLogWorldTest {

	static HelloLogWorld clz;

	@BeforeClass
	public static void setUpOnce() {
		clz = new HelloLogWorld();
	}

	@Test
	public void testPrintLogLevel() {
		clz.printLogLevel();
	}

	@Test
	public void testUsingSlf4jPlaceholder() {
		clz.usingSlf4jPlaceholder(1);
		clz.usingSlf4jPlaceholder(4);
		clz.usingSlf4jPlaceholder(5);
		clz.usingSlf4jPlaceholder(8);
		clz.usingSlf4jPlaceholder(10);
		clz.usingSlf4jPlaceholder(200);
	}

}
