package ch.zhaw.mcag;

import ch.zhaw.mcag.levels.Level;
import ch.zhaw.mcag.model.Dimension;

public final class Config {
	private static int level = Level.LEVEL_DEEPSEA;
	
	private static Dimension boardDimension;

	private static int initialLifes = 5;

	// Speed settings
	private static int gameSpeed = 15;
	private static int movePixels = 2;

	private static int enemyFactor = 100;
	private static int obstacleFactor = 200;
	private static int shotFactor = 50;
	private static int extraFactor = 200;

	// Image path
	public final static String imagePath = "/images/";

	public static int getLevel(){
		return level;
	}
	
	public static int setLevel(int l){
		return level = l;
	}
	

	public static int getGameSpeed() {
		return gameSpeed;
	}

	public static void setGameSpeed(int speed) {
		gameSpeed = speed;
	}

	public static Dimension getBoardDimension() {
		return boardDimension;
	}

	public static void setBoardDimension(Dimension dimension) {
		boardDimension = dimension;
	}

	public static int getMovePixels() {
		return movePixels;
	}

	public static void setMovePixels(int movePixels) {
		Config.movePixels = movePixels;
	}

	public static int getEnemyFactor() {
		return enemyFactor;
	}

	public static void setEnemyFactor(int enemyFactor) {
		Config.enemyFactor = enemyFactor;
	}

	public static int getObstacleFactor() {
		return obstacleFactor;
	}

	public static void setObstacleFactor(int obstacleFactor) {
		Config.obstacleFactor = obstacleFactor;
	}

	public static int getShotFactor() {
		return shotFactor;
	}

	public static void setShotFactor(int shotFactor) {
		Config.shotFactor = shotFactor;
	}

	public static int getInitialLifes() {
		return initialLifes;
	}

	public static void setInitialLifes(int initialLifes) {
		Config.initialLifes = initialLifes;
	}

	public static int getExtraFactor() {
		return extraFactor;
	}

	public static void setExtraFactor(int extraFactor) {
		Config.extraFactor = extraFactor;
	}
	
}
