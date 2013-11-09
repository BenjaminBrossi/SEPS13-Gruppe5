package ch.zhaw.mcag.model;

import java.awt.Image;

import ch.zhaw.mcag.Config;

public class Extra extends Item implements Collectable {
	private boolean collected = false;

	public Extra(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);

	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() - Config.getMovePixels());
	}

	@Override
	public void collect() {
		if (!this.collected) {
			this.collected = true;
			this.disposed = true;
		}
	}
}
