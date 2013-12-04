package ch.zhaw.mcag;

import ch.zhaw.mcag.view.Board;
import ch.zhaw.mcag.thread.EnemyCreator;
import ch.zhaw.mcag.thread.ShotCreator;
import ch.zhaw.mcag.thread.ExtraCreator;
import ch.zhaw.mcag.thread.Engine;
import ch.zhaw.mcag.thread.ObstacleCreator;
import java.awt.*;

import javax.swing.JFrame;

import ch.zhaw.mcag.model.Dimension;

/**
 *
 * Game frame
 *
 * This class starts the game and initializes the context and starts the threads
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = -6941538058687003272L;

	/**
	 * Create new GameFrame
	 */
	public GameFrame() {
	}

	private void start() {

		java.awt.Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Config.setBoardDimension(new Dimension(dimension.height, dimension.width));
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

		Game c = new Game();
		Board board = new Board(c);

		// Threads
		Engine engine = new Engine(c, board);
		ObstacleCreator oCreator = new ObstacleCreator(c);
		EnemyCreator eCreator = new EnemyCreator(c);
		ShotCreator sCreator = new ShotCreator(c);
		ExtraCreator xCreator = new ExtraCreator(c);

		engine.start();
		oCreator.start();
		eCreator.start();
		sCreator.start();
		xCreator.start();

		this.add(board);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);

		if (gd.isFullScreenSupported()) {
			//gd.setFullScreenWindow(this);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		} else {
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}

		this.setVisible(true);
	}

	/**
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		GameFrame game = new GameFrame();
		game.start();
	}

}
