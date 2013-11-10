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


		for (Shot shot : (LinkedList<Shot>) c.getShots().clone()) {
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
						e.collect(c);
					} else if (thoseItem instanceof Destroyable && "ch.zhaw.mcag.model.creature.Player".equals(myItem.getClass().getName())) {
						c.setLifes(c.getLifes() - 1);
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
		for (Item item : c.getAllStuff()) {
			item.move();
		}
		c.getBackground().move();
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
		for (Extra extra : (LinkedList<Extra>) c.getExtras().clone()) {
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
		for (Enemy enemy : (LinkedList<Enemy>) c.getEnemies().clone()) {
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
		for (Soft obstacle : (List<Soft>) c.getSoftObstacles().clone()) {
			if (obstacle.getPosition().getX() < 0 - obstacle.getDimension().getLength() || obstacle.isDisposed()) {
				disposedSofts.add(obstacle);
			}
		}
		for (Soft obstacle : disposedSofts) {
			c.getSoftObstacles().remove(obstacle);
		}

		LinkedList<Hard> disposedHards = new LinkedList<>();
		for (Hard obstacle : (List<Hard>) c.getHardObstacles().clone()) {
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
		for (Shot shot : (List<Shot>) c.getShots().clone()) {
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

	private void disposeExposions() {
		LinkedList<Explosion> disposedExplosions = new LinkedList<>();
		for (Explosion explosion : (List<Explosion>) c.getExplosions().clone()) {
			if (explosion.isDisposed()) {
				disposedExplosions.add(explosion);
			}
		}
		for (Explosion explosion : disposedExplosions) {
			c.getExplosions().remove(explosion);
		}
	}
}
