package ch.zhaw.mcag.thread;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.Game;
import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.Player;
import ch.zhaw.mcag.model.obstacle.Hard;
import java.util.LinkedList;

/**
 *
 * @author beni
 */
public class CollisionHandler {

	LinkedList<Item> me;
	LinkedList<Item> them;
	Game c;

	CollisionHandler(LinkedList<Item> me, LinkedList<Item> them, Game c) {
		this.me = me;
		this.them = them;
		this.c = c;
	}

	public void searchCollision() {
		for (Item thoseItem : them) {
			this.checkCollision(thoseItem, me);
		}
	}

	private void checkCollision(Item thoseItem, LinkedList<Item> me) {
		for (Item myItem : me) {
			Position intersection = myItem.hasCollision(thoseItem);
			if (intersection.getX() > 0 && intersection.getY() > 0 && !thoseItem.hadCollision()) {
				this.handleCollision(myItem, thoseItem, intersection);
			}
		}
	}

	private void handleCollision(Item myItem, Item thoseItem, Position intersection) {
		if (thoseItem instanceof Collectable && "ch.zhaw.mcag.model.creature.Player".equals(myItem.getClass().getName())) {
			Extra e = (Extra) thoseItem;
			e.collect(c);
		}
		if (myItem instanceof Player && myItem.isFlickering()) {
			return;
		}

		if (thoseItem instanceof Destroyable && "ch.zhaw.mcag.model.creature.Player".equals(myItem.getClass().getName())) {
			c.setLifes(c.getLifes() - 1);
			myItem.setFlicker(true);
			thoseItem.destroy();
		} else if (thoseItem instanceof Hard && "ch.zhaw.mcag.model.creature.Player".equals(myItem.getClass().getName())) {
			c.setLifes(c.getLifes() - 1);
			myItem.setFlicker(true);
			thoseItem.collide();
		} else if (thoseItem instanceof Destroyable) {
			c.setPoints(c.getPoints() + Config.getCreaturePoint());
			myItem.destroy();
			thoseItem.destroy();
			Explosion explosion = ItemFactory.createExplosion(intersection.getX(), intersection.getY());
			explosion.setFlicker(true);
			c.getExplosions().add(explosion);
		}
	}

}
