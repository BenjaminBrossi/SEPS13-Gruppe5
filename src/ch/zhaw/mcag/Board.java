package ch.zhaw.mcag;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import ch.zhaw.mcag.levels.Level;
import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.Enemy;
import ch.zhaw.mcag.model.obstacle.*;

public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 6466804428038769553L;
	private GameContext c;

	public Board(GameContext c) {
		addKeyListener(new TAdapter(c));
		setFocusable(true);
		setDoubleBuffered(true);
		this.c = c;
		c.setPlayer(ItemFactory.createPlayer());
		c.setBackground(ItemFactory.createBackground());

	}

	public void paint(Graphics g) {
		super.paint(g);

		this.paintBackground((Graphics2D) g);
		this.paintObstacles((Graphics2D) g);
		this.paintEnemies((Graphics2D) g);
		this.paintShots((Graphics2D) g);
		this.paintPlayer((Graphics2D) g);
		this.paintExtras((Graphics2D) g);

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	private void paintBackground(Graphics2D g2d) {
		int x = c.getBackground().getPosition().getX();
		int y = c.getBackground().getPosition().getY();
		g2d.drawImage(c.getBackground().getImage(), x - c.getBackground().getDimension().getLength(), y, Config.getBoardDimension().getLength(), Config.getBoardDimension().getHeight(), this);
		g2d.drawImage(c.getBackground().getImage(), x, y, Config.getBoardDimension().getLength(), Config.getBoardDimension().getHeight(), this);
		g2d.drawImage(c.getBackground().getImage(), x + c.getBackground().getDimension().getLength(), y, Config.getBoardDimension().getLength(), Config.getBoardDimension().getHeight(), this);
		ImageIcon foreground = new ImageIcon(this.getClass().getResource(Config.imagePath + Level.getLevel().getForeground()));
		g2d.drawImage(foreground.getImage(), 0, Config.getBoardDimension().getHeight() - foreground.getIconHeight(), Config.getBoardDimension().getLength(), foreground.getIconHeight(), this);
	}

	private void paintPlayer(Graphics2D g2d) {
		g2d.drawImage(c.getPlayer().getImage(), c.getPlayer().getPosition().getX(), c.getPlayer().getPosition().getY(), this);
	}

	private synchronized void paintObstacles(Graphics2D g2d) {
		LinkedList<Hard> tmp = c.getHardObstacles();
		for (Obstacle obstacle : tmp) {
			g2d.drawImage(obstacle.getImage(), obstacle.getPosition().getX(), obstacle.getPosition().getY(), this);
		}

		LinkedList<Soft> tmp2 = c.getSoftObstacles();
		for (Obstacle obstacle : tmp2) {
			g2d.drawImage(obstacle.getImage(), obstacle.getPosition().getX(), obstacle.getPosition().getY(), this);
		}
	}

	private synchronized void paintEnemies(Graphics2D g2d) {
		LinkedList<Enemy> tmp = c.getEnemies();
		for (Enemy enemy : tmp) {
			g2d.drawImage(enemy.getImage(), enemy.getPosition().getX(), enemy.getPosition().getY(), this);
		}
	}

	private synchronized void paintShots(Graphics2D g2d) {
		LinkedList<Shot> tmp = c.getShots();
		for (Shot shot : tmp) {
			g2d.drawImage(shot.getImage(), shot.getPosition().getX(), shot.getPosition().getY(), this);
		}
	}
	
	private synchronized void paintExtras(Graphics2D g2d) {
		LinkedList<Extra> tmp = c.getExtras();
		for (Extra extra : tmp) {
			g2d.drawImage(extra.getImage(), extra.getPosition().getX(), extra.getPosition().getY(), this);
		}
	}

	public void actionPerformed(ActionEvent e) {
	}
}