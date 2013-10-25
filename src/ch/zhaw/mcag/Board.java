package ch.zhaw.mcag;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.Timer;

import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.*;
import ch.zhaw.mcag.model.obstacle.Obstacle;

public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 6466804428038769553L;
	private Timer timer;
	private Player player;
	private List<Creature> enemies = new LinkedList<Creature>();
	private List<Obstacle> obstacles = new LinkedList<Obstacle>();
	private int counter = 0;

	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		this.player = ItemFactory.createPlayer();

		timer = new Timer(Config.getGAME_SPEED(), this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);

		this.paintPlayer((Graphics2D) g);
		this.paintEnemies((Graphics2D) g);
		this.paintObstacles((Graphics2D) g);
		this.paintShots((Graphics2D) g);

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
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
		Iterator<Creature> itr = this.enemies.iterator();
		while (itr.hasNext()) {
			Creature creature = itr.next();
			g2d.drawImage(creature.getImage(), creature.getPosition().getX(), creature.getPosition().getY(), this);
		}
	}

	private void paintShots(Graphics2D g2d) {
		Iterator<Shot> itr = player.getShots().iterator();
		while (itr.hasNext()) {
			Shot shot = itr.next();
			g2d.drawImage(shot.getImage(), shot.getPosition().getX(), shot.getPosition().getY(), this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(this.counter  > Config.getGAME_SPEED() * 5){
			int choice = (int)(Math.random() * 3);
			switch(choice){
				case 0:
					this.enemies.add(ItemFactory.createEnemy());
					break;
				case 1:
					this.obstacles.add(ItemFactory.createHardObstacle());
					break;
				case 2:
					this.obstacles.add(ItemFactory.createSoftObstacle());
					break;
			}
			counter = 0;
		} else {
			counter++;
		}
		
		this.movePlayer();
		this.moveEnemies();
		this.moveObstacles();
		repaint();
	}
	
	private void movePlayer(){
		LinkedList<Shot> shots = player.getShots();
		Iterator<Shot> itr = shots.iterator();
		while (itr.hasNext()) {
			itr.next().move();
		}
		player.move();
	}
	private void moveObstacles(){
		Iterator<Obstacle> itr = this.obstacles.iterator();
		while(itr.hasNext()){
			Obstacle obstacle = itr.next();
			obstacle.move();
		}
	}
	private void moveEnemies(){
		Iterator<Creature> itr = this.enemies.iterator();
		while(itr.hasNext()){
			Creature creature = itr.next();
			creature.move();
		}
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