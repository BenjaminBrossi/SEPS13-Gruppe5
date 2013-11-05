package ch.zhaw.mcag.model;

import java.awt.Image;

import ch.zhaw.mcag.Config;

public class Extra extends Item {
	// private boolean good = true;

	public Extra(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);

	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() - Config.getMovePixels());
	}
}
