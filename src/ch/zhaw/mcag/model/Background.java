package ch.zhaw.mcag.model;

import java.awt.Image;

/**
 * The background item
 *
 */
public class Background extends Item {

	/**
	 * Create a new background
	 *
	 * @param position
	 * @param dimension
	 * @param image
	 */
	public Background(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	@Override
	public void move() {
		if (this.getPosition().getX() + this.getDimension().getLength() < 0) {
			this.getPosition().setX(0);
		}

		this.getPosition().setX(this.getPosition().getX() - 1);
	}
}
