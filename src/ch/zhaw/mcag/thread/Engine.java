package ch.zhaw.mcag.thread;

import ch.zhaw.mcag.view.Board;
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
			if (!c.isPaused()) {
				moveAll();
				collisionDetection();
				disposeAll();
				c.setPoints(c.getPoints() + 1);
				board.repaint();
				Config.setGameSpeed(Config.getInitialSpeed() - (int) (Math.log10(c.getPoints()) - 2));
			}
			try {
				Thread.sleep(Config.getGameSpeed());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void collisionDetection() {
		LinkedList<Item> them = new LinkedList<Item>();
		LinkedList<Item> me = new LinkedList<Item>();

		them.addAll(c.getEnemies());
		them.addAll(c.getSoftObstacles());
		them.addAll(c.getHardObstacles());

		List<Shot> tmp = c.getShots();

		for (Shot shot : tmp) {
			if (shot.isGood()) {
				me.add(shot);
			} else {
				them.add(shot);
			}
		}

		me.add(c.getPlayer());

		for (Item thoseItem : them) {
			for (Item myItem : me) {
				if (myItem.hasCollision(thoseItem)) {
					if (!thoseItem.hadCollision() && myItem.getClass().getName() == "ch.zhaw.mcag.model.creature.Player") {
						System.out.println("minus one life");
						thoseItem.setCollision(true);
					} else if (thoseItem instanceof Destroyable) {
						c.setPoints(c.getPoints() + 100);

						myItem.destroy();
						thoseItem.destroy();
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
		moveExtras();
		moveBackground();
	}

	private synchronized void disposeAll() {
		disposeEnemies();
		disposeObstacles();
		disposeShots();
		disposeExtras();
	}

	private void disposeExtras() {
		LinkedList<Extra> disposedExtras = new LinkedList<Extra>();
		List<Extra> tmp = c.getExtras();
		for (Extra extra : tmp) {
			if (extra.getPosition().getX() < 0 - extra.getDimension().getLength() || extra.isDisposed()) {
				disposedExtras.add(extra);
			}
		}
		for (Extra extra : disposedExtras) {
			c.getExtras().remove(extra);
		}
	}

	private synchronized void disposeEnemies() {
		LinkedList<Enemy> disposedEnememies = new LinkedList<Enemy>();
		List<Enemy> tmp = c.getEnemies();
		for (Enemy enemy : tmp) {
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
		List<Soft> tmp = c.getSoftObstacles();
		for (Soft obstacle : tmp) {
			if (obstacle.getPosition().getX() < 0 - obstacle.getDimension().getLength() || obstacle.isDisposed()) {
				disposedObstacles.add(obstacle);
			}
		}
		for (Obstacle obstacle : disposedObstacles) {
			c.getSoftObstacles().remove(obstacle);
		}

		disposedObstacles = new LinkedList<Obstacle>();
		List<Hard> tmp2 = c.getHardObstacles();
		for (Obstacle obstacle : tmp2) {
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
		List<Shot> tmp = c.getShots();
		for (Shot shot : tmp) {
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
		List<Soft> tmp = c.getSoftObstacles();
		for (Obstacle soft : tmp) {
			soft.move();
		}

		List<Hard> tmp2 = c.getHardObstacles();
		for (Obstacle hard : tmp2) {
			hard.move();
		}
	}

	private synchronized void moveEnemies() {
		List<Enemy> tmp = c.getEnemies();
		for (Enemy enemy : tmp) {
			enemy.move();
		}
	}

	private synchronized void moveExtras() {
		List<Extra> tmp = c.getExtras();
		for (Extra extra : tmp) {
			extra.move();
		}
	}

	private synchronized void moveShots() {
		List<Shot> tmp = c.getShots();
		for (Shot shot : tmp) {
			shot.move();
		}
	}
}
