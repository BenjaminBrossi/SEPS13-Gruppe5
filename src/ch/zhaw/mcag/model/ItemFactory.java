package ch.zhaw.mcag.model;

import ch.zhaw.mcag.Config;
import javax.swing.ImageIcon;

import ch.zhaw.mcag.level.Level;
import ch.zhaw.mcag.model.creature.*;
import ch.zhaw.mcag.model.obstacle.*;

/**
 * The item factory. Create all the items, displayed on the board
 */
public class ItemFactory {

	/**
	 * Create an enemy
	 *
	 * @return enemy
	 */
	public static Enemy createEnemy() {
		Config.getLevel();
		int pick = (int) (Math.random() * Level.getLevel().getEnemies().length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.getImagePath() + Level.getLevel().getEnemies()[pick]));
		int y = (int) (Math.random() * Config.getBoardDimension().getHeight()) - (imageIcon.getIconHeight() / 2);
		int x = Config.getBoardDimension().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Enemy(position, dimension, imageIcon.getImage());
	}

	/**
	 * Create an extra
	 *
	 * @return extra
	 */
	public static Extra createExtra() {
		int pick = (int) (Math.random() * Level.getLevel().getExtras().length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.getImagePath() + Level.getLevel().getExtras()[pick]));
		int y = (int) (Math.random() * Config.getBoardDimension().getHeight()) - (imageIcon.getIconHeight() / 2);
		int x = Config.getBoardDimension().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Extra(position, dimension, imageIcon.getImage(), pick);
	}

	/**
	 * Create a hard obstacle
	 *
	 * @return hard obstacle
	 */
	public static Hard createHardObstacle() {
		int pick = (int) (Math.random() * Level.getLevel().getHardObstacles().length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.getImagePath() + Level.getLevel().getHardObstacles()[pick]));
		int y = (int) (Math.random() * Config.getBoardDimension().getHeight()) - (imageIcon.getIconHeight() / 2);
		int x = Config.getBoardDimension().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Hard(position, dimension, imageIcon.getImage());
	}

	/**
	 * Create a soft obstacle
	 *
	 * @return soft obstacle
	 */
	public static Soft createSoftObstacle() {
		int pick = (int) (Math.random() * Level.getLevel().getSoftObstacles().length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.getImagePath() + Level.getLevel().getSoftObstacles()[pick]));
		int y = (int) (Math.random() * Config.getBoardDimension().getHeight()) - (imageIcon.getIconHeight() / 2);
		int x = Config.getBoardDimension().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Soft(position, dimension, imageIcon.getImage());
	}

	/**
	 * Create the player
	 *
	 * @return player
	 */
	public static Player createPlayer() {
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.getImagePath() + Level.getLevel().getPlayer()));
		Position position = new Position(0, (int) Config.getBoardDimension().getHeight() / 2);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Player(position, dimension, imageIcon.getImage());
	}

	/**
	 * Create a shot from the given creature
	 *
	 * @param creature
	 * @return shot
	 */
	public static Shot createShot(Creature creature) {
		String picture;
		if (creature.isGood()) {
			picture = Level.getLevel().getFriendlyShot();
		} else {
			picture = Level.getLevel().getEnemyShot();
		}
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.getImagePath() + picture));
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		Position position = new Position(creature.getPosition().getX(), creature.getPosition().getY() + (creature.getDimension().getHeight() / 2) - (dimension.getHeight() / 2));
		return new Shot(position, dimension, imageIcon.getImage(), creature.isGood());
	}

	/**
	 * Create the background
	 *
	 * @return background
	 */
	public static Background createBackground() {
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.getImagePath() + Level.getLevel().getBackground()));
		Position position = new Position(0, 0);
		Dimension dimension = new Dimension(Config.getBoardDimension().getHeight(), Config.getBoardDimension().getLength());
		return new Background(position, dimension, imageIcon.getImage());
	}

	/**
	 * Create an explosion at the given location
	 *
	 * @param x
	 * @param y
	 * @return explosion
	 */
	public static Explosion createExplosion(int x, int y) {
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.getImagePath() + Level.getLevel().getExplosion()));
		Position position = new Position(x - (imageIcon.getIconHeight() / 2), y - (imageIcon.getIconWidth() / 2));
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Explosion(position, dimension, imageIcon.getImage());
	}

	/**
	 * Create a Life at the given location
	 *
	 * @param x
	 * @param y
	 * @param imageIcon
	 * @return life
	 */
	public static Life createLife(int x, int y, ImageIcon imageIcon) {
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Life(position, dimension, imageIcon.getImage());
	}
}
