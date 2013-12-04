package ch.zhaw.mcag.inputAdapter;

import ch.zhaw.mcag.view.Board;
import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.Game;
import java.awt.event.*;

/**
 * Keyboard adapter Read the input of the keyboard, in case there is no motion control sensor, and for the menu navigation
 */
public class KeyboardAdapter extends KeyAdapter {

	private final Game context;
	private final Board board;

	/**
	 * Create a new keyboard adapter
	 *
	 * @param context
	 * @param board
	 */
	public KeyboardAdapter(Game context, Board board) {
		super();
		this.context = context;
		this.board = board;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
				context.getPlayer().setDx(0);
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_UP:
				context.getPlayer().setDy(0);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (!board.showMenu()) {
			switch (key) {
				case KeyEvent.VK_LEFT:
					context.getPlayer().setDx(-Config.getMovePixels() * 2);
					break;
				case KeyEvent.VK_RIGHT:
					context.getPlayer().setDx(Config.getMovePixels() * 2);
					break;
				case KeyEvent.VK_DOWN:
					context.getPlayer().setDy(Config.getMovePixels() * 2);
					break;
				case KeyEvent.VK_UP:
					context.getPlayer().setDy(-Config.getMovePixels() * 2);
					break;
				case KeyEvent.VK_SPACE:
					context.getPlayer().shoot(context.getShots());
					break;
				case KeyEvent.VK_ESCAPE:
					board.getMenu().reset();
					board.toggleMenu();
					break;
				default:
					break;
			}
		} else {
			if ((key >= 48 && key <= 57) || (key >= 65 && key <= 90)
					|| key == KeyEvent.VK_SPACE) { // 0-9, A-Z and ' '
				board.getMenu().addCharToName((char) key);
			}
			switch (key) {
				case KeyEvent.VK_UP:
					board.getMenu().up();
					break;
				case KeyEvent.VK_DOWN:
					board.getMenu().down();
					break;
				case KeyEvent.VK_LEFT:
					board.getMenu().left();
					break;
				case KeyEvent.VK_RIGHT:
					board.getMenu().right();
					break;
				case KeyEvent.VK_SPACE:
					board.getMenu().select(board.getMenu().getSelected());
					break;
				case KeyEvent.VK_ENTER:
					board.getMenu().enter();
					break;
				case KeyEvent.VK_ESCAPE:
					if (board.getMenu().getState() == 1) {
						board.toggleMenu();
					} else {
						board.getMenu().setState(1);
					}
					break;
				case KeyEvent.VK_BACK_SPACE:
					board.getMenu().deleteCharFromName();
			}
		}
		board.repaint();
	}
}
