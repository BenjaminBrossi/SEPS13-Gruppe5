package ch.zhaw.mcag.model;

import java.awt.Image;

import ch.zhaw.mcag.*;

public class Shot extends Item implements Movable, Destroyable {

	public Shot(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() + Config.getMISSILE_SPEED());
		if (this.getPosition().getX() > 500) {
			this.destroy();
		}
	}

	public void destroy() {
		Game.destroyItem(this);
	}
}