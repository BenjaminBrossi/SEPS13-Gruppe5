package ch.zhaw.mcag.threads;

import ch.zhaw.mcag.*;

public class EnemyCreator extends Thread {
	GameContext c;

	public EnemyCreator(GameContext c) {
		this.c = c;
	}

	public synchronized void run() {
		while (true) {
			createItems();
			try {
				Thread.sleep(Config.getGameSpeed() * Config.getEnemyFactor());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void createItems() {
		c.getEnemies().add(ItemFactory.createEnemy());
	}
}