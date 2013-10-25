package ch.zhaw.mcag.model.creature;

import java.awt.Image;

import ch.zhaw.mcag.Game;
import ch.zhaw.mcag.model.*;

public abstract class Creature extends Item implements Movable, Destroyable {
	protected int dx = 0;
	protected int dy = 0;

	public Creature(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	public void destroy() {
		Game.destroyItem(this);
	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() + dx);
		this.getPosition().setY(this.getPosition().getY() + dy);
	}
	
	abstract public boolean isGood();
}
