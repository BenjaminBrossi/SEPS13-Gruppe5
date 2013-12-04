package ch.zhaw.mcag.thread;

import ch.zhaw.mcag.model.ItemFactory;
import ch.zhaw.mcag.*;

/**
 * Thread Enemy creator
 */
public class EnemyCreator extends Thread {

	private final Game c;

	/**
	 * Create a new enemy creator
	 *
	 * @param c
	 */
	public EnemyCreator(Game c) {
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
