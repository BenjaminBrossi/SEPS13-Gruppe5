package ch.zhaw.mcag.thread;

import ch.zhaw.mcag.model.ItemFactory;
import ch.zhaw.mcag.*;

public class ExtraCreator extends Thread {

	Game c;

	public ExtraCreator(Game c) {
		this.c = c;
	}

	@Override
	public void run() {
		while (true) {
			if (!c.isPaused()) {
				c.getExtras().add(ItemFactory.createExtra());
			}
			try {
				Thread.sleep(Config.getGameSpeed() * Config.getExtraFactor());
			} catch (InterruptedException e) {
			}
		}
	}
}
