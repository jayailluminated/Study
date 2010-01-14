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
public class Amplifier {
	private Guitar guitar;
	private Speaker speaker;
	private Footpedal footpedal;
	private Synthesizer synthesizer;


	@Inject
	public void setGuitar(Guitar guitar) {
		this.guitar = guitar;
	}

	@Inject
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Inject
	public void setFootpedal(Footpedal footpedal) {
		this.footpedal = footpedal;
	}

	@Inject
	public void setSynthesizer(Synthesizer synthesizer) {
		this.synthesizer = synthesizer;
	}


	// you do not need the setter naming convention in Guice
}