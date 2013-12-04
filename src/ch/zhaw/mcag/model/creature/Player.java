package ch.zhaw.mcag.model.creature;

import ch.zhaw.mcag.model.ItemFactory;
import java.awt.Image;

import ch.zhaw.mcag.*;
import ch.zhaw.mcag.model.*;
import java.util.Calendar;
import java.util.List;

/**
 * The player item
 */
public class Player extends Creature {

	private long nextShot;

	/**
	 * Create a new player
	 *
	 * @param position
	 * @param dimension
	 * @param image
	 */
	public Player(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
		good = true;
		flickerTime = Config.getFlickerTime() * 2;
		nextShot = Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * Fire a shot
	 *
	 * @param shots
	 */
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
		if (flicker > this.flickerTime / Config.getGameSpeed()) {
			this.flickerEnabled = false;
			this.flickerTime = Config.getFlickerTime() * 2;
		}
		return ++flicker % 3 == 0;
	}

	/**
	 * Set the time to flicker
	 *
	 * @param flickerTime
	 */
	public void setFlickerTime(int flickerTime) {
		this.flickerTime = flickerTime;
	}
}
