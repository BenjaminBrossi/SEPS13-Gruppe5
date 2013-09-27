package ch.zhaw.mcag;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.Timer;

import ch.zhaw.mcag.model.Shot;
import ch.zhaw.mcag.model.creature.*;

public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 6466804428038769553L;
	private Timer timer;
	private Player player;

	public Board() {

		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		player = new Player(40, 60 , 0, 0);

		timer = new Timer(Config.GAME_SPEED, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(player.getImage(), player.getPosition().getX(), player.getPosition().getY(), this);
		
		ArrayList<Shot> shots = player.getShots();
		Iterator<Shot> itr = shots.iterator();
		
		while(itr.hasNext()){
			Shot shot = itr.next();
			g2d.drawImage(shot.getImage(), shot.getPosition().getX(), shot.getPosition().getY(), this);
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<Shot> shots = player.getShots();
		Iterator<Shot> itr = shots.iterator();
		
		while(itr.hasNext()){
			Shot shot = itr.next();
			shot.move();
		}
		
		player.move();
		repaint();
	}

	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
	}

}