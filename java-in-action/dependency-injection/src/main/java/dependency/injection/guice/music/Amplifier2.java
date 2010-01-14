package dependency.injection.guice.music;

import com.google.inject.Inject;
import dependency.injection.model.Footpedal;
import dependency.injection.model.Guitar;
import dependency.injection.model.Speaker;
import dependency.injection.model.Synthesizer;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 14, 2010
 * Time: 12:16:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Amplifier2 {
	private Guitar guitar;
	private Speaker speaker;
	private Footpedal footpedal;
	private Synthesizer synthesizer;


	@Inject
	public void set(Guitar guitar, Speaker speaker, Footpedal footpedal, Synthesizer synthesizer) {
		this.guitar = guitar;
		this.speaker = speaker;
		this.footpedal = footpedal;
		this.synthesizer = synthesizer;

	}

	// you do not need the setter naming convention in Guice
}