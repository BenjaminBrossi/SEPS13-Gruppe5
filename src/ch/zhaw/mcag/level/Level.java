package ch.zhaw.mcag.level;

import ch.zhaw.mcag.Config;

public class Level {
	public static final int LEVEL_SPACE = 0;
	public static final int LEVEL_DEEPSEA = 1;

	public static AbstractLevel getLevel() {
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
