package ch.zhaw.mcag;

import javax.swing.ImageIcon;

import ch.zhaw.mcag.level.Level;
import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.*;
import ch.zhaw.mcag.model.obstacle.*;

public class ItemFactory {
	Config conf = new Config();

	public static Enemy createEnemy() {
		Config.getLevel();
		int pick = (int) (Math.random() * Level.getLevel().getEnemies().length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Level.getLevel().getEnemies()[pick]));
		int y = (int) (Math.random() * Config.getBoardDimension().getHeight()) - (imageIcon.getIconHeight() / 2);
		int x = Config.getBoardDimension().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Enemy(position, dimension, imageIcon.getImage());
	}

	public static Extra createExtra() {
		int pick = (int) (Math.random() * Level.getLevel().getExtras().length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Level.getLevel().getExtras()[pick]));
		int y = (int) (Math.random() * Config.getBoardDimension().getHeight()) - (imageIcon.getIconHeight() / 2);
		int x = Config.getBoardDimension().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Extra(position, dimension, imageIcon.getImage());
	}

	public static Hard createHardObstacle() {
		int pick = (int) (Math.random() * Level.getLevel().getHardObstacles().length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Level.getLevel().getHardObstacles()[pick]));
		int y = (int) (Math.random() * Config.getBoardDimension().getHeight()) - (imageIcon.getIconHeight() / 2);
		int x = Config.getBoardDimension().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Hard(position, dimension, imageIcon.getImage());
	}

	public static Soft createSoftObstacle() {
		int pick = (int) (Math.random() * Level.getLevel().getSoftObstacles().length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Level.getLevel().getSoftObstacles()[pick]));
		int y = (int) (Math.random() * Config.getBoardDimension().getHeight()) - (imageIcon.getIconHeight() / 2);
		int x = Config.getBoardDimension().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Soft(position, dimension, imageIcon.getImage());
	}

	public static Player createPlayer() {
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Level.getLevel().getPlayer()));
		Position position = new Position(0, (int) Config.getBoardDimension().getHeight() / 2);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Player(position, dimension, imageIcon.getImage());
	}

	public static Shot createShot(Creature creature) {
		String picture;
		if (creature.isGood()) {
			picture = Level.getLevel().getFriendlyShot();
		} else {
			picture = Level.getLevel().getEnemyShot();
		}
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + picture));
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		Position position = new Position(creature.getPosition().getX(), creature.getPosition().getY() + (creature.getDimension().getHeight() / 2) - (dimension.getHeight() / 2));
		return new Shot(position, dimension, imageIcon.getImage(), creature.isGood());
	}

	public static Background createBackground() {
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Level.getLevel().getBackground()));
		Position position = new Position(0, 0);
		Dimension dimension = new Dimension(Config.getBoardDimension().getHeight(), Config.getBoardDimension().getLength());
		return new Background(position, dimension, imageIcon.getImage());
	}
}
