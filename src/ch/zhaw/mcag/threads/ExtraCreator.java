package ch.zhaw.mcag.threads;

import ch.zhaw.mcag.*;

public class ExtraCreator extends Thread {
	GameContext c;

	public ExtraCreator(GameContext c) {
		this.c = c;
	}

	public synchronized void run() {
		while (true) {
			c.getExtras().add(ItemFactory.createExtra());
			System.out.println("ciao");
			try {
				Thread.sleep(Config.getGameSpeed() * Config.getExtraFactor());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
