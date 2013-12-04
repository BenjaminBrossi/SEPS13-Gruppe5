package ch.zhaw.mcag.level;

import ch.zhaw.mcag.Config;

/**
 * Class to select the level
 *
 */
public class Level {

	/**
	 * Level space
	 */
	public static final int LEVEL_SPACE = 0;

	/**
	 * Level deep sea
	 */
	public static final int LEVEL_DEEPSEA = 1;

	/**
	 * Return the selected level
	 *
	 * @return
	 */
	public static LevelInterface getLevel() {
		switch (Config.getLevel()) {
			case LEVEL_SPACE:
				return new Space();
			case LEVEL_DEEPSEA:
				return new Deepsea();
			default:
				return new Space();
		}
	}

}
