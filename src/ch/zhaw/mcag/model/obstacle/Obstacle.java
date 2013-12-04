package ch.zhaw.mcag.model.obstacle;

import java.awt.Image;

import ch.zhaw.mcag.*;
import ch.zhaw.mcag.model.*;

/**
 * Abstract class for the obstacles
 *
 * @author beni
 */
public abstract class Obstacle extends Item implements Movable {

	/**
	 * Create a new Obstacle
	 *
	 * @param position
	 * @param dimension
	 * @param image
	 */
	public Obstacle(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	@Override
	public void move() {
		this.getPosition().setX(this.getPosition().getX() - Config.getMovePixels());
	}
}
