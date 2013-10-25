package ch.zhaw.mcag;

import java.awt.*;

import javax.swing.JFrame;

import ch.zhaw.mcag.model.*;

public class Game extends JFrame {

	private static final long serialVersionUID = -6941538058687003272L;

	public Game() {

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		this.add(new Board());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("MCAG");
		this.setUndecorated(true);
		
		if (gd.isFullScreenSupported()) {
	        gd.setFullScreenWindow(this);
	    } else {
	    	this.setExtendedState(JFrame.NORMAL);
	    }
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Game();
	}

	public static void destroyItem(Destroyable item) {
		item = null;
	}
}