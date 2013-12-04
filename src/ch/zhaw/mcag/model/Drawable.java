package ch.zhaw.mcag.model;

import java.awt.Image;

/**
 * Interface for drawable items
 *
 */

public interface Drawable {

	/**
	 * Get the icon of item
	 *
	 * @return icon
	 */
	public Image getImage();

	/**
	 * Set the icon of the item
	 *
	 * @param image
	 */
	public void setImage(Image image);

	/**
	 * Get the dimension of the item
	 *
	 * @return dimension
	 */
	public Dimension getDimension();

	/**
	 * Set the dimension of the item
	 *
	 * @param dimension
	 */
	public void setDimension(Dimension dimension);

	/**
	 * Get the position of an item
	 *
	 * @return position
	 */
	public Position getPosition();

	/**
	 * Set the position of the item
	 *
	 * @param position
	 */
	public void setPosition(Position position);
}
