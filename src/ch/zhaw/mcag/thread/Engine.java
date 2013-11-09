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

	@Override
	public void run() {
		while (true) {
			if (!c.isPaused()) {
				moveAll();
				collisionDetection();
				disposeAll();
				c.setPoints(c.getPoints() + 0.01);
				board.repaint();
				Config.setGameSpeed(Config.getInitialSpeed() - (int) (Math.log10(c.getPoints()) - 2));
			}
			try {
				Thread.sleep(Config.getGameSpeed());
			} catch (InterruptedException e) {
			}
		}
	}

	private synchronized void collisionDetection() {
		LinkedList<Item> them = new LinkedList<>();
		LinkedList<Item> me = new LinkedList<>();

		them.addAll(c.getEnemies());
		them.addAll(c.getSoftObstacles());
		them.addAll(c.getHardObstacles());
		them.addAll(c.getExtras());

		List<Shot> tmp = (List<Shot>) c.getShots().clone();

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
				Position intersection = myItem.hasCollision(thoseItem);
				if (intersection.getX() > 0 && intersection.getY() > 0 && !thoseItem.hadCollision()) {
					if (thoseItem instanceof Collectable && "ch.zhaw.mcag.model.creature.Player".equals(myItem.getClass().getName())) {
						Extra e = (Extra) thoseItem;
						e.collect();
					} else if (thoseItem instanceof Destroyable && "ch.zhaw.mcag.model.creature.Player".equals(myItem.getClass().getName())) {
						Config.setLifes(Config.getLifes() - 1);
						myItem.setFlicker(true);
						thoseItem.destroy();
					} else if (thoseItem instanceof Hard && "ch.zhaw.mcag.model.creature.Player".equals(myItem.getClass().getName())) {
						Config.setLifes(Config.getLifes() - 1);
						myItem.setFlicker(true);
						thoseItem.collide();
					} else if (thoseItem instanceof Destroyable) {
						c.setPoints(c.getPoints() + 100);
						myItem.destroy();
						thoseItem.destroy();
						Explosion explosion = ItemFactory.createExplosion(intersection.getX(), intersection.getY());
						explosion.setFlicker(true);
						c.getExplosions().add(explosion);
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
		disposeExposions();
	}

	private synchronized void disposeExtras() {
		LinkedList<Extra> disposedExtras = new LinkedList<>();
		List<Extra> tmp = (LinkedList<Extra>) c.getExtras().clone();
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
		LinkedList<Enemy> disposedEnememies = new LinkedList<>();
		List<Enemy> tmp = (LinkedList<Enemy>) c.getEnemies().clone();
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
		LinkedList<Soft> disposedSofts = new LinkedList<>();
		List<Soft> tmp = (List<Soft>) c.getSoftObstacles().clone();
		for (Soft obstacle : tmp) {
			if (obstacle.getPosition().getX() < 0 - obstacle.getDimension().getLength() || obstacle.isDisposed()) {
				disposedSofts.add(obstacle);
			}
		}
		for (Soft obstacle : disposedSofts) {
			c.getSoftObstacles().remove(obstacle);
		}

		LinkedList<Hard> disposedHards = new LinkedList<>();
		List<Hard> tmp2 = (List<Hard>) c.getHardObstacles().clone();
		for (Hard obstacle : tmp2) {
			if (obstacle.getPosition().getX() < 0 - obstacle.getDimension().getLength()) {
				disposedHards.add(obstacle);
			}
		}
		for (Hard obstacle : disposedHards) {
			c.getHardObstacles().remove(obstacle);
		}
	}

	private synchronized void disposeShots() {
		LinkedList<Shot> disposedEnememies = new LinkedList<>();
		List<Shot> tmp = (List<Shot>) c.getShots().clone();
		for (Shot shot : tmp) {
			if (shot.isGood() == false && shot.getPosition().getX() < 0 - shot.getDimension().getLength() || shot.isDisposed()) {
				disposedEnememies.add(shot);
			}

			if (shot.isGood() && shot.getPosition().getX() > Config.getBoardDimension().getLength() || shot.isDisposed()) {
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
		List<Soft> tmp = (List<Soft>) c.getSoftObstacles().clone();
		for (Obstacle soft : tmp) {
			soft.move();
		}

		List<Hard> tmp2 = (List<Hard>) c.getHardObstacles().clone();
		for (Obstacle hard : tmp2) {
			hard.move();
		}
	}

	private synchronized void moveEnemies() {
		List<Enemy> tmp = (List<Enemy>) c.getEnemies().clone();
		for (Enemy enemy : tmp) {
			enemy.move();
		}
	}

	private synchronized void moveExtras() {
		List<Extra> tmp = (List<Extra>) c.getExtras().clone();
		for (Extra extra : tmp) {
			extra.move();
		}
	}

	private synchronized void moveShots() {
		List<Shot> tmp = (List<Shot>) c.getShots().clone();
		for (Shot shot : tmp) {
			shot.move();
		}
	}

	private void disposeExposions() {
		LinkedList<Explosion> disposedExplosions = new LinkedList<>();
		List<Explosion> tmp = (List<Explosion>) c.getExplosions().clone();
		for (Explosion explosion : tmp) {
			if (explosion.isDisposed()) {
				disposedExplosions.add(explosion);
			}
		}
		for (Explosion explosion : disposedExplosions) {
			c.getExplosions().remove(explosion);
		}
	}
}
