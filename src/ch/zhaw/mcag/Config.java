package ch.zhaw.mcag;

import ch.zhaw.mcag.model.Dimension;

public final class Config {
	private static Dimension BOARD_DIMESION;

	// Speed settings
	private static int GAME_SPEED = 3;

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
		return (int)(GAME_SPEED / 1.5);
	}

	public static int getBACKGROUND_SPEED() {
		return (int)(GAME_SPEED / 2);
	}
}
