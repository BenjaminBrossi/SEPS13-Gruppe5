package ch.zhaw.mcag.model.creature;

import ch.zhaw.mcag.model.ItemFactory;
import java.awt.Image;

import ch.zhaw.mcag.model.*;

/**
 * Item enemy
 */
public class Enemy extends Creature implements Destroyable {

	/**
	 * Direction of the item
	 */
	protected int direction = 1;

	/**
	 * Create a new enemy
	 *
	 * @param position
	 * @param dimension
	 * @param image
	 */
	public Enemy(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
		if (Math.random() > 0.5) {
			direction = -1;
		}
	}

	@Override
	public void move() {
		this.getPosition().setX(this.getPosition().getX() - 1 * 3);
		this.getPosition().setY(this.getPosition().getY() - direction * 3);
		if (this.touchesEdge()) {
			direction *= -1;
		}
	}

	/**
	 * Fire a shot
	 *
	 * @return shot
	 */
	public Shot shoot() {
		return ItemFactory.createShot(this);
	}

	@Override
	public void destroy() {
		this.setDisposed(true);
	}
}
