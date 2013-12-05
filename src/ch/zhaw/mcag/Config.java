package ch.zhaw.mcag;

import ch.zhaw.mcag.level.Level;
import ch.zhaw.mcag.model.Dimension;

/**
 * MCAG configuration
 */
public class Config {

	private static int level = Level.LEVEL_SPACE;
	private static Dimension boardDimension;

	private final static int LIFES = 5;
	private final static int EXTRA_POINTS = 100;
	private final static int OBSTACLE_POINTS = 50;
	private final static int CREATURE_POINTS = 20;
	private final static int HIGHSCORE_LIMIT = 5;

	// Speed settings
	private static int gameSpeed = 15;
	private final static int INITIAL_SPEED = 15;
	private final static int movePixels = 2;

	// Speed factors
	private final static int ENEMY_FACTOR = 150;
	private final static int OBSTACLE_FACTOR = 150;
	private final static int SHOT_FACTOR = 50;
	private final static int EXTRA_FACTOR = 200;

	// interval in milliseconds
	private final static long SHOT_INTERVAL = 200;
	private final static int FLICKER_TIME = 500;

	// Image path
	private final static String IMAGE_PATH = "/images/";

	// Images
	private final static String PLAYER = "Player.png";
	private final static String FRIENDLY_SHOT = "Shot.png";
	private final static String ENEMY_SHOT = "Shot_Opponent.png";
	private final static String BACKGROUND = "Background.png";
	private final static String FOREGROUND = "Earth.png";
	private final static String[] ENEMIES = {"Alien.png", "Alien2.png"};
	private final static String[] HARD_OBSTACLES = {"HRTA.png", "HRTA2.png", "HRTA3.png", "HRTA4.png"};
	private final static String[] SOFT_OBSTACLES = {"Satelite.png"};
	private final static String[] EXTRAS = {"alien.gif"};

	/**
	 * Get the selected Level
	 *
	 * @return selected Level
	 */
	public static int getLevel() {
		return level;
	}

	/**
	 * Set a level
	 *
	 * @param aLevel
	 */
	public static void setLevel(int aLevel) {
		level = aLevel;
	}

	/**
	 * Get the dimension of the Board
	 *
	 * @return board dimension
	 */
	public static Dimension getBoardDimension() {
		return boardDimension;
	}

	/**
	 * Set the dimension of the Board
	 *
	 * @param aBoardDimension
	 */
	public static void setBoardDimension(Dimension aBoardDimension) {
		boardDimension = aBoardDimension;
	}

	/**
	 * Get initial LIFES
	 *
	 * @return initial LIFES
	 */
	public static int getLifes() {
		return LIFES;
	}

	/**
	 * Get the points which are given for an extra point
	 *
	 * @return points for EXTRAS
	 */
	public static int getExtraPoint() {
		return EXTRA_POINTS;
	}

	/**
	 * Get the points which are given for an obstacle
	 *
	 * @return points for obstacles
	 */
	public static int getObstaclePoint() {
		return OBSTACLE_POINTS;
	}

	/**
	 * Get the points which are given for a creature
	 *
	 * @return points for creature
	 */
	public static int getCreaturePoint() {
		return CREATURE_POINTS;
	}

	/**
	 * Get the game speed
	 *
	 * @return game speed
	 */
	public static int getGameSpeed() {
		return gameSpeed;
	}

	/**
	 * Set the game Speed
	 *
	 * @param aGameSpeed
	 */
	public static void setGameSpeed(int aGameSpeed) {
            if(aGameSpeed > 0){
                gameSpeed = aGameSpeed;
            }
	}

	/**
	 * Get the initial speed
	 *
	 * @return initial speed
	 */
	public static int getInitialSpeed() {
		return INITIAL_SPEED;
	}

	/**
	 * Get the count of pixels to move
	 *
	 * @return pixel count
	 */
	public static int getMovePixels() {
		return movePixels;
	}

	/**
	 * Get the moving factor of an enemy
	 *
	 * @return move factor
	 */
	public static int getEnemyFactor() {
		return ENEMY_FACTOR;
	}

	/**
	 * Get the moving factor of an obstacle
	 *
	 * @return move factor
	 */
	public static int getObstacleFactor() {
		return OBSTACLE_FACTOR;
	}

	/**
	 * Get the moving factor of a shot
	 *
	 * @return moving factor
	 */
	public static int getShotFactor() {
		return SHOT_FACTOR;
	}

	/**
	 * Get the moving factor of an extra
	 *
	 * @return moving factor
	 */
	public static int getExtraFactor() {
		return EXTRA_FACTOR;
	}

	/**
	 * Get the interval between shots
	 *
	 * @return shot interval
	 */
	public static long getShotInterval() {
		return SHOT_INTERVAL;
	}

	/**
	 * Get the flicker time
	 *
	 * @return flicker time
	 */
	public static int getFlickerTime() {
		return FLICKER_TIME;
	}

	/**
	 * Get the name of the PLAYER icon
	 *
	 * @return PLAYER icon
	 */
	public static String getPlayer() {
		return PLAYER;
	}

	/**
	 * Get the name of the friendly shot icon
	 *
	 * @return shot icon
	 */
	public static String getFriendlyShot() {
		return FRIENDLY_SHOT;
	}

	/**
	 * Get the name of the enemy shot icon
	 *
	 * @return shot icon
	 */
	public static String getEnemyShot() {
		return ENEMY_SHOT;
	}

	/**
	 * Get the name of the BACKGROUND image
	 *
	 * @return BACKGROUND image
	 */
	public static String getBackground() {
		return BACKGROUND;
	}

	/**
	 * Get the name of the fore ground image
	 *
	 * @return fore ground image
	 */
	public static String getForeground() {
		return FOREGROUND;
	}

	/**
	 * Get the names of the enemy icons
	 *
	 * @return Array of enemy icons
	 */
	public static String[] getEnemies() {
		return ENEMIES;
	}

	/**
	 * Get the names of the hard obstacle icons
	 *
	 * @return Array of hard obstacle icons
	 */
	public static String[] getHardObstacles() {
		return HARD_OBSTACLES;
	}

	/**
	 * Get the names of the hard obstacle icons
	 *
	 * @return Array of soft obstacle icons
	 */
	public static String[] getSoftObstacles() {
		return SOFT_OBSTACLES;
	}

	/**
	 * Get the names of the extra icons
	 *
	 * @return Array of extra icons
	 */
	public static String[] getExtras() {
		return EXTRAS;
	}

	/**
	 * Get the highscore limit
	 *
	 * @return limit
	 */
	public static int getHighscoreLimit() {
		return HIGHSCORE_LIMIT;
	}

	/**
	 * Get the path to the image directory
	 *
	 * @return image path
	 */
	public static String getImagePath() {
		return IMAGE_PATH;
	}

}
