package ch.zhaw.mcag.thread;

import ch.zhaw.mcag.*;

public class ShotCreator extends Thread {

	Game c;

	public ShotCreator(Game c) {
		this.c = c;
	}

	@Override
	public void run() {
		while (true) {
			if (!c.isPaused()) {
				if (c.getEnemies().size() > 1) {
					int count = c.getEnemies().size();
					int pick = (int) (Math.random() * count);
					c.getShots().add(c.getEnemies().get(pick).shoot());
				}
			}
			try {
				Thread.sleep(Config.getGameSpeed() * Config.getShotFactor());
			} catch (InterruptedException e) {
			}
		}
	}
}
