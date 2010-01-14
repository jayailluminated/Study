package dependency.injection.constructor;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 14, 2010
 * Time: 11:55:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Atlas {
	private final Earth earthOnBack;

	//Atlas depends on Earth and cannot be changed once wired.
	public Atlas(Earth earth) {
		this.earthOnBack = earth;

		//Raises a compile error
//		this.earthOnBack = null;
	}

	public void reset() {
		//Raises a compile error
//		earchOnBack = new Earth();
	}
}
