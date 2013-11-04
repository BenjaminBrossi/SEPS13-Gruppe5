package ch.zhaw.mcag.threads;

import ch.zhaw.mcag.*;

public class ShotCreator extends Thread {
	GameContext c;

	public ShotCreator(GameContext c) {
		this.c = c;
	}

	public synchronized void run() {
		while (true) {
			if (c.getEnemies().size() > 1) {
				int count = c.getEnemies().size();
				int pick = (int) (Math.random() * count);
				c.getShots().add(c.getEnemies().get(pick).shoot());
			}
			try {
				Thread.sleep(Config.getGameSpeed() * Config.getShotFactor());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
