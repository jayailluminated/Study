package dependency.injection.guice.amphibian;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 15, 2010
 * Time: 12:20:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class Amphibian {
	private Gills gills;
	private Lungs lungs;
	private Heart heart;


	// Constructor for life in water
	public Amphibian(Heart heart, Gills gills) {
		this.gills = gills;
		this.heart = heart;
	}

	// Constructor for life on land
	public Amphibian(Heart heart, Lungs lungs) {
		this.lungs = lungs;
		this.heart = heart;
	}
}

