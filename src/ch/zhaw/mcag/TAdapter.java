package ch.zhaw.mcag;

import java.awt.event.*;

public class TAdapter extends KeyAdapter {
	GameContext c;

	public TAdapter(GameContext c) {
		super();
		this.c = c;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			c.getPlayer().setDx(0);
		}

		if (key == KeyEvent.VK_RIGHT) {
			c.getPlayer().setDx(0);
		}

		if (key == KeyEvent.VK_UP) {
			c.getPlayer().setDy(0);
		}

		if (key == KeyEvent.VK_DOWN) {
			c.getPlayer().setDy(0);
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			c.getPlayer().setDx(-Config.getMovePixels() * 2);
		}

		if (key == KeyEvent.VK_RIGHT) {
			c.getPlayer().setDx(Config.getMovePixels() * 2);
		}

		if (key == KeyEvent.VK_UP) {
			c.getPlayer().setDy(-Config.getMovePixels() * 2);
		}

		if (key == KeyEvent.VK_DOWN) {
			c.getPlayer().setDy(Config.getMovePixels() * 2);
		}

		if (key == KeyEvent.VK_SPACE) {
			c.getPlayer().shoot(c.getShots());
		}
	}
}