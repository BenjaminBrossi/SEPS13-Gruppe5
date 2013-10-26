package ch.zhaw.mcag;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.*;
import ch.zhaw.mcag.model.obstacle.Obstacle;

public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 6466804428038769553L;
	private Timer timer;
	private Player player;
	private Background background;
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	private LinkedList<Obstacle> obstacles = new LinkedList<Obstacle>();
	protected LinkedList<Shot> shots = new LinkedList<Shot>();
	private int delayEnemy = 0;
	private int delayObstacle = 0;
	private int delayShots = 0;

	public Board() {
		addKeyListener(new TAdapter(this));
		setFocusable(true);
		setDoubleBuffered(true);
		
		this.background = ItemFactory.createBackground();
		this.player = ItemFactory.createPlayer();

		timer = new Timer(Config.getGAME_SPEED(), this);
		timer.start();
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
		int x = background.getPosition().getX();
		int y = background.getPosition().getY();
		g2d.drawImage(background.getImage(), x - background.getDimension().getLength(), y, Config.getBOARD_DIMESION().getLength(), Config.getBOARD_DIMESION().getHeight(), this);
		g2d.drawImage(background.getImage(), x, y, Config.getBOARD_DIMESION().getLength(), Config.getBOARD_DIMESION().getHeight(), this);
		g2d.drawImage(background.getImage(), x + background.getDimension().getLength(), y, Config.getBOARD_DIMESION().getLength(), Config.getBOARD_DIMESION().getHeight(), this);
		ImageIcon foreground = new ImageIcon(this.getClass().getResource(Config.imagePath + Config.foreground));
		g2d.drawImage(foreground.getImage(), 0, Config.getBOARD_DIMESION().getHeight() - foreground.getIconHeight(), Config.getBOARD_DIMESION().getLength(), foreground.getIconHeight(), this);
	}

	private void paintPlayer(Graphics2D g2d) {
		g2d.drawImage(player.getImage(), player.getPosition().getX(), player.getPosition().getY(), this);
	}

	private void paintObstacles(Graphics2D g2d) {
		Iterator<Obstacle> itr = this.obstacles.iterator();
		while (itr.hasNext()) {
			Obstacle obstacle = itr.next();
			g2d.drawImage(obstacle.getImage(), obstacle.getPosition().getX(), obstacle.getPosition().getY(), this);
		}
	}

	private void paintEnemies(Graphics2D g2d) {
		Iterator<Enemy> itr = this.enemies.iterator();
		while (itr.hasNext()) {
			Enemy enemy = itr.next();
			g2d.drawImage(enemy.getImage(), enemy.getPosition().getX(), enemy.getPosition().getY(), this);
		}
	}

	private void paintShots(Graphics2D g2d) {
		Iterator<Shot> shots = this.shots.iterator();
		while (shots.hasNext()) {
			Shot shot = shots.next();
			g2d.drawImage(shot.getImage(), shot.getPosition().getX(), shot.getPosition().getY(), this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		this.createItems();
		this.moveBackground();
		this.movePlayer();
		this.moveEnemies();
		this.moveObstacles();
		this.moveShots();
		this.disposeEnemies();
		this.disposeObstacles();
		this.disposeShots();
		repaint();
	}

	private void disposeEnemies() {
		LinkedList<Enemy> disposedEnememies = new LinkedList<Enemy>();
		Iterator<Enemy> enemies = this.enemies.iterator();
		while (enemies.hasNext()) {
			Enemy enemy = enemies.next();
			if (enemy.getPosition().getX() < 0 - enemy.getDimension().getLength()) {
				disposedEnememies.add(enemy);
			}
		}
		enemies = disposedEnememies.iterator();
		while (enemies.hasNext()) {
			this.enemies.remove(enemies.next());
		}
	}
	
	private void disposeObstacles() {
		LinkedList<Obstacle> disposedObstacles = new LinkedList<Obstacle>();
		Iterator<Obstacle> obstacles= this.obstacles.iterator();
		while (obstacles.hasNext()) {
			Obstacle obstacle = obstacles.next();
			if (obstacle.getPosition().getX() < 0 - obstacle.getDimension().getLength()) {
				disposedObstacles.add(obstacle);
			}
		}
		obstacles = disposedObstacles.iterator();
		while (obstacles.hasNext()) {
			this.obstacles.remove(obstacles.next());
		}
	}
	
	private void disposeShots() {
		LinkedList<Shot> disposedEnememies = new LinkedList<Shot>();
		Iterator<Shot> shots = this.shots.iterator();
		while (shots.hasNext()) {
			Shot shot = shots.next();
			if (shot.getPosition().getX() < 0 - shot.getDimension().getLength()) {
				disposedEnememies.add(shot);
			}
		}
		shots = disposedEnememies.iterator();
		while (shots.hasNext()) {
			this.shots.remove(shots.next());
		}
	}

	private void createItems() {
		if (this.delayObstacle > Config.getGAME_SPEED() * 80) {
			int choice = (int) (Math.random() * 2);
			switch (choice) {
			case 0:
				this.obstacles.add(ItemFactory.createHardObstacle());
				break;
			case 1:
				this.obstacles.add(ItemFactory.createSoftObstacle());
				break;
			}
			this.delayObstacle = 0;
		} else {
			this.delayObstacle++;
		}

		if (this.delayEnemy > Config.getGAME_SPEED() * 40) {
			this.enemies.add(ItemFactory.createEnemy());
			this.delayEnemy = 0;
		} else {
			this.delayEnemy++;
		}

		if (this.delayShots > Config.getGAME_SPEED() * 10 && this.enemies.size() > 1) {
			int choice = (int) (Math.random() * this.enemies.size());
			this.shots.add(this.enemies.get(choice).shoot());
			this.delayShots = 0;
		} else {
			this.delayShots++;
		}
	}
	
	private void moveBackground(){
		this.background.move();
	}

	private void movePlayer() {
		this.player.move();
	}

	private void moveObstacles() {
		Iterator<Obstacle> itr = this.obstacles.iterator();
		while (itr.hasNext()) {
			itr.next().move();
		}
	}

	private void moveEnemies() {
		Iterator<Enemy> itr = this.enemies.iterator();
		while (itr.hasNext()) {
			Enemy enemy = itr.next();
			enemy.move();
		}
	}

	private void moveShots() {
		Iterator<Shot> itr = this.shots.iterator();
		while (itr.hasNext()) {
			itr.next().move();
		}
	}

	private class TAdapter extends KeyAdapter {
		Board board;

		public TAdapter(Board board) {
			this.board = board;
		}

		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_SPACE) {
				this.board.shots.addLast(this.board.player.shoot());
			} else {
				this.board.player.keyPressed(e);
			}
		}
	}
}