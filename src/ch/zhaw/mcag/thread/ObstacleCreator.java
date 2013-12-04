package ch.zhaw.mcag.thread;

import ch.zhaw.mcag.model.ItemFactory;
import ch.zhaw.mcag.*;

/**
 * Obstacle creator thread
 */
public class ObstacleCreator extends Thread {

	private final Game c;

	/**
	 * Create a new obstacle creator thread
	 *
	 * @param c
	 */
	public ObstacleCreator(Game c) {
		this.c = c;
	}

	@Override
	public void run() {
		while (true) {
			if (!c.isPaused()) {
				createItems();
			}
			try {
				Thread.sleep(Config.getGameSpeed() * Config.getObstacleFactor());
			} catch (InterruptedException e) {
			}
		}
	}

	private void createItems() {
		if (Math.random() > 0.6) {
			c.getHardObstacles().add(ItemFactory.createHardObstacle());
		} else {
			c.getSoftObstacles().add(ItemFactory.createSoftObstacle());
		}
	}
}
