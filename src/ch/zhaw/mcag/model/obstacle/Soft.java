package ch.zhaw.mcag.model.obstacle;

import ch.zhaw.mcag.Game;
import ch.zhaw.mcag.model.*;

public class Soft extends Obstacle implements Destroyable {

	public Soft() {
		super(0, 0, 0, 0);
	}

	public void destroy() {
		Game.destroyItem(this);
	}

}
