package ch.zhaw.mcag;

import javax.swing.JFrame;

import ch.zhaw.mcag.model.*;

public class Game extends JFrame {

	private static final long serialVersionUID = -6941538058687003272L;

	public Game() {

		add(new Board());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setTitle("R - Type");
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Game();
	}

	public static void destroyItem(Destroyable item) {
		item = null;
	}
}