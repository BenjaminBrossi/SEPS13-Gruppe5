package ch.zhaw.mcag.model.obstacle;

import java.awt.Image;
import ch.zhaw.mcag.model.*;

/**
 * Soft obstacle item
 */
public class Soft extends Obstacle implements Destroyable {

	/**
	 * Create a new soft obstacle
	 *
	 * @param position
	 * @param dimension
	 * @param image
	 */
	public Soft(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	@Override
	public void destroy() {
		this.setDisposed(true);
	}

}
