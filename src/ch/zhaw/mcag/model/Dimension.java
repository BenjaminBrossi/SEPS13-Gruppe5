package ch.zhaw.mcag.model;

/**
 * Dimension of an item
 *
 */
public class Dimension {

	private int height;
	private int length;

	/**
	 * Create a new Dimension
	 *
	 * @param height
	 * @param length
	 */
	public Dimension(int height, int length) {
		this.height = height;
		this.length = length;
	}

	/**
	 * Get height of an item in pixel
	 *
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set height of an item in pixel
	 *
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Get length of an item in pixel
	 *
	 * @return length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Set length of an item in pixel
	 *
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}

}
