package dependency.injection.servicelocator;

/**
 * User: jungjooseo
 * Date: Jan 9, 2010
 * Time: 2:37:31 AM
 *
 * Service Locator pattern is kind of Factory
 * JNDI is a goods example of service location pattern.
 */
public class ServiceLocator {
	public Object get(String name) {
		//find service
		return new Object();
	}
}
