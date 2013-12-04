package ch.zhaw.mcag.model;

import java.awt.*;

import ch.zhaw.mcag.Config;

/**
 * Basic class of a drawable item
 *
 */
public class Item implements Drawable, Destroyable, Movable {

	/**
	 * The dimension of the item
	 */
	protected Dimension dimension;

	/**
	 * Position of the item
	 */
	protected Position position;

	/**
	 * Image of the item
	 */
	protected Image image;

	/**
	 * Is the icon friendly?
	 */
	protected boolean good = false;

	/**
	 * Dispose the item?
	 */
	protected boolean disposed = false;

	/**
	 * Has the item a collision?
	 */
	protected boolean hadCollision = false;

	/**
	 * Is the icon flickering?
	 */
	protected int flicker = 0;

	/**
	 * Is flickering enabled?
	 */
	protected boolean flickerEnabled = false;

	/**
	 * Flicker time of the item
	 */
	protected int flickerTime = Config.getFlickerTime();

	/**
	 * Create a new item
	 *
	 * @param position
	 * @param dimension
	 * @param image
	 */
	public Item(Position position, Dimension dimension, Image image) {
		this.position = position;
		this.dimension = dimension;
		this.image = image;
	}

	@Override
	public Dimension getDimension() {
		return dimension;
	}

	@Override
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public Image getImage() {
		return this.image;
	}

	@Override
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * Returns true if the item is outside of the frame
	 *
	 * @return boolean
	 */
	public boolean isOutside() {
		int l = this.getDimension().getLength();
		int x = this.getPosition().getX();
		int board = Config.getBoardDimension().getLength();

		if (x + l < 0 || x > board) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the item touches the edge of the frame
	 *
	 * @return boolean
	 */
	public boolean touchesEdge() {
		int h = this.getDimension().getHeight();
		int y = this.getPosition().getY();
		int board = Config.getBoardDimension().getHeight();

		if (y <= 0 || y + h >= board) {
			return true;
		}
		return false;
	}

	/**
	 * Get the boarder around the item
	 *
	 * @return limit
	 */
	public Rectangle getLimits() {
		return new Rectangle(position.getX(), position.getY(), dimension.getLength(), dimension.getHeight());
	}

	/**
	 * Returns true if the item had a collision
	 *
	 * @param item other item
	 * @return
	 */
	public Position hasCollision(Item item) {
		if (!this.getLimits().intersects(item.getLimits())) {
			return new Position(0, 0);
		} else {
			Rectangle intersection = this.getLimits().intersection(item.getLimits());
			return new Position((int) intersection.getCenterX(), (int) intersection.getCenterY());
		}
	}

	/**
	 * Returns true if the item is good
	 *
	 * @return isGood
	 */
	public boolean isGood() {
		return good;
	}

	/**
	 * Returns true if the item is disposed
	 *
	 * @return isDisposed
	 */
	public boolean isDisposed() {
		return disposed;
	}

	/**
	 * Set an item disposed
	 *
	 * @param disposed
	 */
	public void setDisposed(boolean disposed) {
		this.disposed = disposed;
	}

	@Override
	public void destroy() {

	}

	/**
	 * Collision action
	 */
	public void collide() {
		if (!this.hadCollision) {
			this.hadCollision = true;
			this.disposed = true;
		}
	}

	/**
	 * Returns true if the item had a collision
	 *
	 * @return hadCollision
	 */
	public boolean hadCollision() {
		return this.hadCollision;
	}

	/**
	 * Flicker the item. Returns true if the item should be painted
	 *
	 * @return
	 */
	public boolean flicker() {
		if (!flickerEnabled) {
			return true;
		}
		if (flicker > flickerTime / Config.getGameSpeed()) {
			this.disposed = true;
		}
		return ++flicker % 5 == 0;
	}

	/**
	 * Set the item to flickering
	 *
	 * @param flicker
	 */
	public void setFlicker(boolean flicker) {
		this.flicker = 0;
		this.flickerTime = Config.getFlickerTime();
		this.flickerEnabled = flicker;
	}

	/**
	 * Returns true if the item is flickering
	 *
	 * @return
	 */
	public boolean isFlickering() {
		return flickerEnabled;
	}

	@Override
	public void move() {
	}

}
