package ch.zhaw.mcag.model;

/**
 * The position of an item
 *
 */
public class Position {

	private int x;
	private int y;

	/**
	 * Create a new position
	 *
	 * @param x axis
	 * @param y axis
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Get the x position
	 *
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set the x position
	 *
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get the y position
	 *
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the y position
	 *
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}
