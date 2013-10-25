package ch.zhaw.mcag;

import ch.zhaw.mcag.model.Dimension;

public final class Config {
	private static Dimension BOARD_DIMESION;

	// Speed settings
	private static int GAME_SPEED = 10;

	// Image path
	public final static String imagePath = "/images/";

	// Images
	public final static String player = "alien.gif";
	public final static String friendlyShot = "rocket.gif";
	public final static String enemyShot = "bullet.png";
	public final static String[] enemies = { "enemy.png" };
	public final static String[] hardObstacles = { "brick.jpg" };
	public final static String[] softObstacles = { "wood.jpg" };
	public final static String[] extras = { "alien.gif" };

	public static int getGAME_SPEED() {
		return GAME_SPEED;
	}

	public static void setGAME_SPEED(int speed) {
		GAME_SPEED = speed;
	}

	public static Dimension getBOARD_DIMESION() {
		return BOARD_DIMESION;
	}

	public static void setBOARD_DIMESION(Dimension dimension) {
		BOARD_DIMESION = dimension;
	}

	public static int getMISSILE_SPEED() {
		return GAME_SPEED / 5;
	}

	public static int getBACKGROUND_SPEED() {
		return GAME_SPEED / 10;
	}
}
