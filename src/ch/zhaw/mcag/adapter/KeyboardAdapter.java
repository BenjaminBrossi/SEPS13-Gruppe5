package ch.zhaw.mcag.adapter;

import ch.zhaw.mcag.view.Board;
import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.GameContext;
import java.awt.event.*;

public class KeyboardAdapter extends KeyAdapter {
	GameContext c;
	Board board;

	public KeyboardAdapter(GameContext c, Board board) {
		super();
		this.c = c;
		this.board = board;
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

		if (!board.showMenu()) {
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
				c.getPlayer().shoot(c.getShots());
				break;
			case KeyEvent.VK_ESCAPE:
				board.getMenu().reset();
				board.toggleMenu();
				break;
			}
		} else {
			switch (key) {
			case KeyEvent.VK_UP:
				board.getMenu().up();
				break;
			case KeyEvent.VK_DOWN:
				board.getMenu().down();
				break;
			case KeyEvent.VK_SPACE:
				board.getMenu().select(board.getMenu().getSelected());
				break;
			case KeyEvent.VK_ENTER:
				board.getMenu().select(board.getMenu().getSelected());
				break;
			case KeyEvent.VK_ESCAPE:
				if (board.getMenu().getState() == 1)
					board.toggleMenu();
				else
					board.getMenu().setState(1);
				break;
			}
		}
		board.repaint();
	}
}
