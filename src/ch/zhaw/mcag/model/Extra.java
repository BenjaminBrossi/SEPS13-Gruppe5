package ch.zhaw.mcag.model;

import java.awt.Image;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.GameContext;

public class Extra extends Item implements Collectable {
	private boolean collected = false;
	private ExtraEnum type;

	public Extra(Position position, Dimension dimension, Image image, int type) {
		super(position, dimension, image);
		this.type = ExtraEnum.values()[type];
	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() - Config.getMovePixels());
	}

	@Override
	public void collect(GameContext c) {
		switch (this.type) {
			case EXTRA_POINTS:
				c.setPoints(c.getPoints() + Config.getExtraPoint());
				break;
			case EXTRA_LIFE:
				c.setLifes(c.getLifes() + 1);
				break;
			case KILL_ALL:
				for (Item item : c.getEvilStuff()) {
					item.setFlicker(true);
				}
				break;
			case INVINCIBLE:
				break;
		}

		if (!this.collected) {
			this.collected = true;
			this.disposed = true;
		}
	}
}
