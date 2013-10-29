package ch.zhaw.mcag;

import java.util.*;

import javax.swing.Timer;

import ch.zhaw.mcag.model.Shot;
import ch.zhaw.mcag.model.creature.Enemy;
import ch.zhaw.mcag.model.obstacle.Obstacle;

public class Engine extends Thread{
	GameContext c;
	Timer timer;
	Board board;
	
	public Engine(GameContext c, Board board){
		this.c = c;
		this.board = board;
	}
	
	public void run(){
		c.setPlayer(ItemFactory.createPlayer());
		c.setBackground(ItemFactory.createBackground());
		board.repaint();
		for(int i = 0; i < 5000; i++){
//			try {
//				//Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			c.getEnemies().add(ItemFactory.createEnemy());
			moveEnemies();
			board.repaint();
		}
		
	}
	
	private void disposeEnemies() {
		LinkedList<Enemy> disposedEnememies = new LinkedList<Enemy>();
		Iterator<Enemy> enemies = c.getEnemies().iterator();
		while (enemies.hasNext()) {
			Enemy enemy = enemies.next();
			if (enemy.getPosition().getX() < 0 - enemy.getDimension().getLength()) {
				disposedEnememies.add(enemy);
			}
		}
		enemies = disposedEnememies.iterator();
		while (enemies.hasNext()) {
			c.getEnemies().remove(enemies.next());
		}
	}
	
	private void disposeObstacles() {
		LinkedList<Obstacle> disposedObstacles = new LinkedList<Obstacle>();
		Iterator<Obstacle> obstacles= c.getSoftObstacles().iterator();
		while (obstacles.hasNext()) {
			Obstacle obstacle = obstacles.next();
			if (obstacle.getPosition().getX() < 0 - obstacle.getDimension().getLength()) {
				disposedObstacles.add(obstacle);
			}
		}
		obstacles = disposedObstacles.iterator();
		while (obstacles.hasNext()) {
			c.getSoftObstacles().remove(obstacles.next());
		}
	}
	
	private void disposeShots() {
		LinkedList<Shot> disposedEnememies = new LinkedList<Shot>();
		Iterator<Shot> shots = c.getShots().iterator();
		while (shots.hasNext()) {
			Shot shot = shots.next();
			if (shot.getPosition().getX() < 0 - shot.getDimension().getLength()) {
				disposedEnememies.add(shot);
			}
		}
		shots = disposedEnememies.iterator();
		while (shots.hasNext()) {
			c.getShots().remove(shots.next());
		}
	}

	private void createItems() {
//		if (this.delayObstacle > Config.getGAME_SPEED() * 80) {
//			int choice = (int) (Math.random() * 2);
//			switch (choice) {
//			case 0:
//				this.obstacles.add(ItemFactory.createHardObstacle());
//				break;
//			case 1:
//				this.obstacles.add(ItemFactory.createSoftObstacle());
//				break;
//			}
//			this.delayObstacle = 0;
//		} else {
//			this.delayObstacle++;
//		}
//
//		if (this.delayEnemy > Config.getGAME_SPEED() * 40) {
//			this.enemies.add(ItemFactory.createEnemy());
//			this.delayEnemy = 0;
//		} else {
//			this.delayEnemy++;
//		}
//
//		if (this.delayShots > Config.getGAME_SPEED() * 10 && this.enemies.size() > 1) {
//			int choice = (int) (Math.random() * this.enemies.size());
//			this.shots.add(this.enemies.get(choice).shoot());
//			this.delayShots = 0;
//		} else {
//			this.delayShots++;
//		}
	}
	
	private void moveBackground(){
		c.getBackground().move();
	}

	private void movePlayer() {
		c.getPlayer().move();
	}

	private void moveObstacles() {
		Iterator<Obstacle> itr = c.getSoftObstacles().iterator();
		while (itr.hasNext()) {
			itr.next().move();
		}
		
		itr = c.getHardObstacles().iterator();
		while (itr.hasNext()) {
			itr.next().move();
		}
	}

	private void moveEnemies() {
		Iterator<Enemy> itr = c.getEnemies().iterator();
		while (itr.hasNext()) {
			Enemy enemy = itr.next();
			enemy.move();
		}
	}

	private void moveShots() {
		Iterator<Shot> itr = c.getShots().iterator();
		while (itr.hasNext()) {
			itr.next().move();
		}
	}

}
