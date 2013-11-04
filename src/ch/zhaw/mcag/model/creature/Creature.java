package ch.zhaw.mcag.model.creature;

import java.awt.Image;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.model.*;

public abstract class Creature extends Item implements Movable {
	protected int dx = 0;
	protected int dy = 0;

	public Creature(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	public void move() {
		int h = this.getDimension().getHeight();
		int l = this.getDimension().getLength();
		int y = this.getPosition().getY();
		int x = this.getPosition().getX();
		int boardH = Config.getBoardDimension().getHeight();
		int boardL = Config.getBoardDimension().getLength();

		if (!(y < 0 && dy < 0) && !(y + h > boardH && dy > 0)) {
			this.getPosition().setY(this.getPosition().getY() + dy);
		}
		if (!(x < 0 && dx < 0) && !(x + l > boardL && dx > 0)) {
			this.getPosition().setX(this.getPosition().getX() + dx);
		}
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
}
