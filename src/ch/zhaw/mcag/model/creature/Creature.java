package ch.zhaw.mcag.model.creature;

import java.awt.Image;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.model.*;

/**
 * Abstract class of a creature
 *
 */
public abstract class Creature extends Item implements Movable {

	/**
	 * Delta x
	 */
	protected int dx = 0;

	/**
	 * Delta y
	 */
	protected int dy = 0;

	/**
	 * Create a new creature
	 *
	 * @param position
	 * @param dimension
	 * @param image
	 */
	public Creature(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	@Override
	public void move() {
		int h = this.getDimension().getHeight();
		int l = this.getDimension().getLength();
		int y = this.getPosition().getY();
		int x = this.getPosition().getX();
		int boardH = Config.getBoardDimension().getHeight();
		int boardL = Config.getBoardDimension().getLength();

		if (!(y < 0 && dy < 0) && !(y + h > boardH && dy > 0)) {
			this.getPosition().setY(this.getPosition().getY() + dy);
		}
		if (!(x < 0 && dx < 0) && !(x + l > boardL && dx > 0)) {
			this.getPosition().setX(this.getPosition().getX() + dx);
		}
	}

	/**
	 * Get delta x
	 *
	 * @return delta x
	 */
	public int getDx() {
		return dx;
	}

	/**
	 * Set delta x
	 *
	 * @param dx
	 */
	public void setDx(int dx) {
		this.dx = dx;
	}

	/**
	 * Get delta y
	 *
	 * @return
	 */
	public int getDy() {
		return dy;
	}

	/**
	 * Set delta y
	 *
	 * @param dy
	 */
	public void setDy(int dy) {
		this.dy = dy;
	}
}
