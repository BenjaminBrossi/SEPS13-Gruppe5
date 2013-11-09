package ch.zhaw.mcag;

import ch.zhaw.mcag.level.Level;
import ch.zhaw.mcag.model.Dimension;

public final class Config {
	private static int level = Level.LEVEL_SPACE;
	private static Dimension boardDimension;

	private static int lifes = 5;

	// Speed settings
	private static int gameSpeed = 15;
	private static int initialSpeed = 10;
	private static int movePixels = 2;

	private static int enemyFactor = 150;
	private static int obstacleFactor = 150;
	private static int shotFactor = 50;
	private static int extraFactor = 200;

	// interval in milliseconds
	private static long shotInterval = 200;

	// Image path
	public final static String imagePath = "/images/";

	// Images
	public final static String player = "Player.png";
	public final static String friendlyShot = "Shot.png";
	public final static String enemyShot = "Shot_Opponent.png";
	public final static String background = "Background.png";
	public final static String foreground = "Earth.png";
	public final static String[] enemies = { "Alien.png", "Alien2.png" };
	public final static String[] hardObstacles = { "HRTA.png", "HRTA2.png", "HRTA3.png", "HRTA4.png" };
	public final static String[] softObstacles = { "Satelite.png" };
	public final static String[] extras = { "alien.gif" };

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

	public static int getLifes() {
		return lifes;
	}

	public static void setLifes(int lifes) {
		Config.lifes = lifes;
	}

	public static long getShotInterval() {
		return shotInterval;
	}

	public static void setShotInterval(long shotInterval) {
		Config.shotInterval = shotInterval;
	}

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		Config.level = level;
	}

	public static int getInitialSpeed() {
		return initialSpeed;
	}

	public static void setInitialSpeed(int initialSpeed) {
		Config.initialSpeed = initialSpeed;
	}

	public static int getExtraFactor() {
		return extraFactor;
	}

	public static void setExtraFactor(int extraFactor) {
		Config.extraFactor = extraFactor;
	}

}
