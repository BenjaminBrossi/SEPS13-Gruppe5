package ch.zhaw.mcag.model.creature;

import ch.zhaw.mcag.model.ItemFactory;
import java.awt.Image;

import ch.zhaw.mcag.*;
import ch.zhaw.mcag.model.*;

public class Enemy extends Creature implements Destroyable {
	protected int direction = 1;

	public Enemy(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
		if (Math.random() > 0.5) {
			direction = -1;
		}
	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() - 1 * 3);
		this.getPosition().setY(this.getPosition().getY() - direction * 3);
		if (this.touchesEdge()) {
			direction *= -1;
		}
	}

	public Shot shoot() {
		return ItemFactory.createShot(this);
	}

	public void destroy() {
		this.setDisposed(true);
	}
}
