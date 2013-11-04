package ch.zhaw.mcag.threads;

import java.util.*;

import ch.zhaw.mcag.*;
import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.Enemy;
import ch.zhaw.mcag.model.obstacle.*;

public class Engine extends Thread {
	GameContext c;
	Board board;

	public Engine(GameContext c, Board board) {
		this.c = c;
		this.board = board;
	}

	public synchronized void run() {
		while (true) {
			moveAll();
			collisionDetection();
			disposeAll();
			board.repaint();
			try {
				Thread.yield();
				Thread.sleep(Config.getGameSpeed());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void collisionDetection() {
		LinkedList<Item> evil = new LinkedList<Item>();
		LinkedList<Item> good = new LinkedList<Item>();

		evil.addAll(c.getEnemies());
		evil.addAll(c.getSoftObstacles());
		evil.addAll(c.getHardObstacles());

		for (Shot shot : c.getShots()) {
			if (shot.isGood()) {
				good.add(shot);
			} else {
				evil.add(shot);
			}
		}

		good.add(c.getPlayer());

		for (Item evilItem : evil) {
			for (Item goodItem : good) {
				if (goodItem.hasCollision(evilItem)) {
					if (!evilItem.hadCollision() && goodItem.getClass().getName() == "ch.zhaw.mcag.model.creature.Player") {
						System.out.println("minus one life");
						evilItem.setCollision(true);
					} else if (evilItem instanceof Destroyable) {
						goodItem.destroy();
						evilItem.destroy();
					}
				}
			}
		}

	}

	private void moveAll() {
		moveEnemies();
		moveShots();
		movePlayer();
		moveObstacles();
		moveBackground();
	}

	private void disposeAll() {
		disposeEnemies();
		disposeObstacles();
		disposeShots();
	}

	private synchronized void disposeEnemies() {
		LinkedList<Enemy> disposedEnememies = new LinkedList<Enemy>();
		for (Enemy enemy : c.getEnemies()) {
			if (enemy.getPosition().getX() < 0 - enemy.getDimension().getLength() || enemy.isDisposed()) {
				disposedEnememies.add(enemy);
			}
		}
		for (Enemy enemy : disposedEnememies) {
			c.getEnemies().remove(enemy);
		}
	}

	private synchronized void disposeObstacles() {
		LinkedList<Obstacle> disposedObstacles = new LinkedList<Obstacle>();
		for (Soft obstacle : c.getSoftObstacles()) {
			if (obstacle.getPosition().getX() < 0 - obstacle.getDimension().getLength() || obstacle.isDisposed()) {
				disposedObstacles.add(obstacle);
			}
		}
		for (Obstacle obstacle : disposedObstacles) {
			c.getSoftObstacles().remove(obstacle);
		}

		disposedObstacles = new LinkedList<Obstacle>();
		for (Obstacle obstacle : c.getHardObstacles()) {
			if (obstacle.getPosition().getX() < 0 - obstacle.getDimension().getLength()) {
				disposedObstacles.add(obstacle);
			}
		}
		for (Obstacle obstacle : disposedObstacles) {
			c.getHardObstacles().remove(obstacle);
		}
	}

	private synchronized void disposeShots() {
		LinkedList<Shot> disposedEnememies = new LinkedList<Shot>();
		for (Shot shot : c.getShots()) {
			if (shot.getPosition().getX() < 0 - shot.getDimension().getLength() || shot.isDisposed()) {
				disposedEnememies.add(shot);
			}
		}

		for (Shot shot : disposedEnememies) {
			c.getShots().remove(shot);
		}
	}

	private void moveBackground() {
		c.getBackground().move();
	}

	private void movePlayer() {
		c.getPlayer().move();
	}

	private synchronized void moveObstacles() {
		for (Obstacle soft : c.getSoftObstacles()) {
			soft.move();
		}

		for (Obstacle hard : c.getHardObstacles()) {
			hard.move();
		}
	}

	private synchronized void moveEnemies() {
		for (Enemy enemy : c.getEnemies()) {
			enemy.move();
		}
	}

	private synchronized void moveShots() {
		for (Shot shot : c.getShots()) {
			shot.move();
		}
	}
}
