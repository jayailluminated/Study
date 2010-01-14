package dependency.injection.guice.beer;

import com.google.inject.Inject;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 14, 2010
 * Time: 11:49:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class BrewingVat {
	@Inject
	Barely barely;
	@Inject
	Yeast yeast;

	public Beer brew() {
		//make some beer from ingredients
		return null;
	}

}
