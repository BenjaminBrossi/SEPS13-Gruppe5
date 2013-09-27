package ch.zhaw.mcag.model.creature;

import ch.zhaw.mcag.Game;
import ch.zhaw.mcag.model.*;

public class Creature extends Item implements Movable, Destroyable {
	protected int dx = 0;
	protected int dy = 0;

	public Creature(int x, int y, int h, int l) {
		super(x, y, h, l);
	}

	public void destroy() {
		Game.destroyItem(this);
	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() + dx);
		this.getPosition().setY(this.getPosition().getY() + dy);
	}
}
