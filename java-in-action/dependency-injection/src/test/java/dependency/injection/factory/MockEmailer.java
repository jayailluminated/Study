package dependency.injection.factory;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 2:13:48 AM
 */
public class MockEmailer extends Emailer{
	public boolean correctlySent() {
		return false;  //To change body of created methods use File | Settings | File Templates.
	}
}
