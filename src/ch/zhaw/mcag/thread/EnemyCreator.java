package ch.zhaw.mcag.thread;

import ch.zhaw.mcag.*;

public class EnemyCreator extends Thread {
	GameContext c;

	public EnemyCreator(GameContext c) {
		this.c = c;
	}

	@Override
	public void run() {
		while (true) {
			if (!c.isPaused()) {
				createItems();
			}
			try {
				Thread.sleep(Config.getGameSpeed() * Config.getEnemyFactor());
			} catch (InterruptedException e) {
			}
		}
	}

	private void createItems() {
		c.getEnemies().add(ItemFactory.createEnemy());
	}
}
