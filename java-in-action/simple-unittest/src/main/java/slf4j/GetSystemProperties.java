package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 30, 2010
 * Time: 1:41:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetSystemProperties {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(HelloLogWorld.class);
		Properties props = System.getProperties();
		Enumeration e = props.propertyNames();

		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			logger.info(key + " : " + props.getProperty(key));
		}

	}
}