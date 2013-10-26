package ch.zhaw.mcag.model.creature;

import java.awt.Image;

import ch.zhaw.mcag.*;
import ch.zhaw.mcag.model.*;

public class Enemy extends Creature {
	protected boolean good = false;

	public Enemy(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	public boolean isGood() {
		return this.good;
	}

	public void move() {
		int x = (int) (Math.random() * Config.getBACKGROUND_SPEED()) + 1;
		int y = (int) (Math.random() * Config.getBACKGROUND_SPEED()) + 1;
		if(Math.random() > 0.5){
			y = y * -1;
		}
		this.getPosition().setX(this.getPosition().getX() - x * 2);
		this.getPosition().setY(this.getPosition().getY() - y * 2);
	}

	public Shot shoot() {
		return ItemFactory.createShot(this);
	}
}
