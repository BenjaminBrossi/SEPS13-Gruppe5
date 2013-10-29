package ch.zhaw.mcag;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import ch.zhaw.mcag.model.Shot;
import ch.zhaw.mcag.model.creature.Enemy;
import ch.zhaw.mcag.model.obstacle.Obstacle;

public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 6466804428038769553L;
	private GameContext c;

	public Board(GameContext c) {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setDoubleBuffered(true);
		this.c = c;
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		this.paintBackground((Graphics2D) g);
		this.paintObstacles((Graphics2D) g);
		this.paintEnemies((Graphics2D) g);
		this.paintShots((Graphics2D) g);
		this.paintPlayer((Graphics2D) g);

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	private void paintBackground(Graphics2D g2d){
		int x = c.getBackground().getPosition().getX();
		int y = c.getBackground().getPosition().getY();
		g2d.drawImage(c.getBackground().getImage(), x - c.getBackground().getDimension().getLength(), y, Config.getBOARD_DIMESION().getLength(), Config.getBOARD_DIMESION().getHeight(), this);
		g2d.drawImage(c.getBackground().getImage(), x, y, Config.getBOARD_DIMESION().getLength(), Config.getBOARD_DIMESION().getHeight(), this);
		g2d.drawImage(c.getBackground().getImage(), x + c.getBackground().getDimension().getLength(), y, Config.getBOARD_DIMESION().getLength(), Config.getBOARD_DIMESION().getHeight(), this);
		ImageIcon foreground = new ImageIcon(this.getClass().getResource(Config.imagePath + Config.foreground));
		g2d.drawImage(foreground.getImage(), 0, Config.getBOARD_DIMESION().getHeight() - foreground.getIconHeight(), Config.getBOARD_DIMESION().getLength(), foreground.getIconHeight(), this);
	}

	private void paintPlayer(Graphics2D g2d) {
		g2d.drawImage(c.getPlayer().getImage(), c.getPlayer().getPosition().getX(), c.getPlayer().getPosition().getY(), this);
	}

	private void paintObstacles(Graphics2D g2d) {
		Iterator<Obstacle> itr = c.getHardObstacles().iterator();
		while (itr.hasNext()) {
			Obstacle obstacle = itr.next();
			g2d.drawImage(obstacle.getImage(), obstacle.getPosition().getX(), obstacle.getPosition().getY(), this);
		}
	}

	private void paintEnemies(Graphics2D g2d) {
		Iterator<Enemy> itr = c.getEnemies().iterator();
		while (itr.hasNext()) {
			Enemy enemy = itr.next();
			g2d.drawImage(enemy.getImage(), enemy.getPosition().getX(), enemy.getPosition().getY(), this);
		}
	}

	private void paintShots(Graphics2D g2d) {
		Iterator<Shot> shots = c.getShots().iterator();
		while (shots.hasNext()) {
			Shot shot = shots.next();
			g2d.drawImage(shot.getImage(), shot.getPosition().getX(), shot.getPosition().getY(), this);
		}
	}
	
	private class TAdapter extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			c.getPlayer().keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_SPACE) {
				c.getShots().add(c.getPlayer().shoot());
			} else {
				c.getPlayer().keyPressed(e);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
	}
}