package ch.zhaw.mcag;

import java.awt.*;

import javax.swing.JFrame;

import ch.zhaw.mcag.model.Dimension;
import ch.zhaw.mcag.threads.*;

public class Game extends JFrame {

	private static final long serialVersionUID = -6941538058687003272L;

	public Game() {

		java.awt.Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Config.setBoardDimension(new Dimension(dimension.height, dimension.width));
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

		GameContext c = new GameContext();
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

	public static void main(String[] args) {
		new Game();
	}

}