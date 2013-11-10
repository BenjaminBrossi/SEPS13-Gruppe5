package ch.zhaw.mcag.model.creature;

import java.awt.Image;

import ch.zhaw.mcag.*;
import ch.zhaw.mcag.model.*;
import java.util.Calendar;
import java.util.List;

public class Player extends Creature {
	protected boolean good = true;
	private long nextShot;
	public int flickerTime = Config.getFlickerTime() * 2;

	public Player(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
		nextShot = Calendar.getInstance().getTimeInMillis();
	}

	public void shoot(List<Shot> shots) {
		if (canShoot()) {
			shootInternal(shots);
		}
	}

	@Override
	public boolean isGood() {
		return this.good;
	}

	private boolean canShoot() {
		return nextShot <= Calendar.getInstance().getTimeInMillis();
	}

	private void shootInternal(List<Shot> shots) {
		shots.add(ItemFactory.createShot(this));
		// set next possible shoot time
		nextShot = Calendar.getInstance().getTimeInMillis() + Config.getShotInterval();
	}

	@Override
	public boolean flicker() {
		if (!flickerEnabled) {
			return true;
		}
		if (flicker > flickerTime / Config.getGameSpeed()) {
			this.flickerEnabled = false;
			this.flickerTime = Config.getFlickerTime() * 2;
		}
		return ++flicker % 5 == 0;
	}

	public void setFlickerTime(int flickerTime) {
		this.flickerTime = flickerTime;
	}
}
