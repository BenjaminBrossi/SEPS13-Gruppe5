package ch.zhaw.mcag.model.obstacle;

import java.awt.Image;

import ch.zhaw.mcag.model.*;

/**
 * Hard obstacle item
 */
public class Hard extends Obstacle {

	/**
	 * Create a new hard obstacle
	 *
	 * @param position
	 * @param dimension
	 * @param image
	 */
	public Hard(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	@Override
	public void collide() {
		if (!this.hadCollision) {
			this.hadCollision = true;
		}
	}
}
