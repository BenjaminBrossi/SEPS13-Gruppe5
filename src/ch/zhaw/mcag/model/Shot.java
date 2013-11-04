package ch.zhaw.mcag.model;

import java.awt.Image;

import ch.zhaw.mcag.*;

public class Shot extends Item implements Movable, Destroyable {
	private int direction = 1;
	private boolean good = true;

	public Shot(Position position, Dimension dimension, Image image, boolean good) {
		super(position, dimension, image);
		if (!good) {
			this.direction = -1;
			this.good = good;
		}
	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() + Config.getMovePixels() * this.direction * 2);
	}

	public void destroy() {
		this.setDisposed(true);
	}

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

}