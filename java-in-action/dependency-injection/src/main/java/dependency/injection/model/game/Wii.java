package dependency.injection.model.game;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 12, 2010
 * Time: 12:11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Wii {
    private WiiGame game;

    public Wii(WiiGame game) {
        this.game = game;
    }

    public void play() {
        //do wii play
    }
}
