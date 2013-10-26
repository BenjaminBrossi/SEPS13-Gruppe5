package ch.zhaw.mcag;

import java.awt.*;

import javax.swing.JFrame;

import ch.zhaw.mcag.model.Dimension;

public class Game extends JFrame {

	private static final long serialVersionUID = -6941538058687003272L;

	public Game() {
		java.awt.Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Config.setBOARD_DIMESION(new Dimension(dimension.height, dimension.width));
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		this.add(new Board());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		
		if (!gd.isFullScreenSupported()) {
	        gd.setFullScreenWindow(this);
	    } else {
	    	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    }
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Game();
	}

}