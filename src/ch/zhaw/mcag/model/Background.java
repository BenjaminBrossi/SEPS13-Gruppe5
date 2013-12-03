package ch.zhaw.mcag.model;

import java.awt.Image;

public class Background extends Item {

	public Background(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	@Override
	public void move() {
		if (this.getPosition().getX() + this.getDimension().getLength() < 0) {
			this.getPosition().setX(0);
		}

		this.getPosition().setX(this.getPosition().getX() - 1);
	}
}
