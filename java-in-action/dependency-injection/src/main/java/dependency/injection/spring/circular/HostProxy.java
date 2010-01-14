package dependency.injection.spring.circular;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 15, 2010
 * Time: 1:17:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class HostProxy implements Host {
	private Host delegate;

	public void setDelegate(Host delegate) {
		this.delegate = delegate;
	}
}
