package ch.zhaw.mcag.model.obstacle;

import java.awt.Image;

import ch.zhaw.mcag.*;
import ch.zhaw.mcag.model.*;

public class Obstacle extends Item implements Movable {

	public Obstacle(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() - Config.getMovePixels());
	}
}
