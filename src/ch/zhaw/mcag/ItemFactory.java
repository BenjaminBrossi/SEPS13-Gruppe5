package ch.zhaw.mcag;

import javax.swing.ImageIcon;

import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.*;
import ch.zhaw.mcag.model.obstacle.*;

public class ItemFactory {
	Config conf = new Config();
	
	public static Enemy createEnemy(){
		int pick = (int) (Math.random() * Config.enemies.length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Config.enemies[pick]));
		int y = (int)(Math.random() * Config.getBOARD_DIMESION().getHeight()) - (imageIcon.getIconHeight()/2);
		int x = Config.getBOARD_DIMESION().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Enemy(position, dimension, imageIcon.getImage());
	}
	
	public static Enemy createExtra(){
		int pick = (int) (Math.random() * Config.extras.length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Config.extras[pick]));
		int y = (int)(Math.random() * Config.getBOARD_DIMESION().getHeight()) - (imageIcon.getIconHeight()/2);
		int x = Config.getBOARD_DIMESION().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Enemy(position, dimension, imageIcon.getImage());
	}
	
	public static Obstacle createHardObstacle(){
		int pick = (int) (Math.random() * Config.hardObstacles.length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Config.hardObstacles[pick]));
		int y = (int)(Math.random() * Config.getBOARD_DIMESION().getHeight()) - (imageIcon.getIconHeight()/2);
		int x = Config.getBOARD_DIMESION().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Hard(position, dimension, imageIcon.getImage());
	}
	
	public static Obstacle createSoftObstacle(){
		int pick = (int) (Math.random() * Config.softObstacles.length);
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Config.softObstacles[pick]));
		int y = (int)(Math.random() * Config.getBOARD_DIMESION().getHeight()) - (imageIcon.getIconHeight()/2);
		int x = Config.getBOARD_DIMESION().getLength();
		Position position = new Position(x, y);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Soft(position, dimension, imageIcon.getImage());
	}
	
	public static Player createPlayer(){
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Config.player));
		Position position = new Position(0, (int)Config.getBOARD_DIMESION().getHeight() / 2);
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		return new Player(position, dimension, imageIcon.getImage());
	}
	
	public static Shot createShot(Creature creature){
		String picture;
		if(creature.isGood()){
			picture = Config.friendlyShot;
		} else {
			picture = Config.enemyShot;
		}
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + picture));
		Dimension dimension = new Dimension(imageIcon.getIconHeight(), imageIcon.getIconWidth());
		Position position = new Position(creature.getPosition().getX(), creature.getPosition().getY() + (creature.getDimension().getHeight()/2) - (dimension.getHeight()/2));
		return new Shot(position, dimension, imageIcon.getImage(), creature.isGood());
	}

	public static Background createBackground() {
		ImageIcon imageIcon = new ImageIcon(ItemFactory.class.getResource(Config.imagePath + Config.background));
		Position position = new Position(0, 0);
		Dimension dimension = new Dimension(Config.getBOARD_DIMESION().getHeight(), Config.getBOARD_DIMESION().getLength());
		return new Background(position, dimension, imageIcon.getImage());
	}
}
