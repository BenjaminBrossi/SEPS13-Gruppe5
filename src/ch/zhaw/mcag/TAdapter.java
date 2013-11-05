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

		switch (key) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
			c.getPlayer().setDx(0);
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_UP:
			c.getPlayer().setDy(0);
			break;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_LEFT:
			c.getPlayer().setDx(-Config.getMovePixels() * 2);
			break;
		case KeyEvent.VK_RIGHT:
			c.getPlayer().setDx(Config.getMovePixels() * 2);
			break;
		case KeyEvent.VK_DOWN:
			c.getPlayer().setDy(Config.getMovePixels() * 2);
			break;
		case KeyEvent.VK_UP:
			c.getPlayer().setDy(-Config.getMovePixels() * 2);
			break;
		case KeyEvent.VK_SPACE:
			c.getShots().add(c.getPlayer().shoot());
			break;
		}
	}
}