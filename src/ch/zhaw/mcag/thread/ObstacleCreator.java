package ch.zhaw.mcag.thread;

import ch.zhaw.mcag.*;

public class ObstacleCreator extends Thread {
	GameContext c;

	public ObstacleCreator(GameContext c) {
		this.c = c;
	}

	public synchronized void run() {
		while (true) {
			if (!c.isPaused()) {
				createItems();
			}
			try {
				Thread.sleep(Config.getGameSpeed() * Config.getObstacleFactor());
			} catch (InterruptedException e) {
				e.printStackTrace();
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
