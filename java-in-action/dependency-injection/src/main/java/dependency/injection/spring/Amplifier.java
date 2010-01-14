package dependency.injection.spring;

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


	public Guitar getGuitar() {
		return guitar;
	}

	public void setGuitar(Guitar guitar) {
		this.guitar = guitar;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public Footpedal getFootpedal() {
		return footpedal;
	}

	public void setFootpedal(Footpedal footpedal) {
		this.footpedal = footpedal;
	}

	public Synthesizer getSynthesizer() {
		return synthesizer;
	}

	public void setSynthesizer(Synthesizer synthesizer) {
		this.synthesizer = synthesizer;
	}
}
