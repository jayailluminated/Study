package dependency.injection.guice.circular;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 15, 2010
 * Time: 1:11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class CircularModule extends AbstractModule{
	@Override
	protected void configure() {
		bind(Host.class).to(HostImpl.class).in(Singleton.class);
		bind(Symbiote.class).to(SymbioteImpl.class).in(Singleton.class);
	}
}
