package ch.zhaw.mcag.level;

/**
 * Level Deepsea
 */
public class Deepsea implements LevelInterface {

	private static final String PLAYER = "Submarine.png";
	private static final String FRIENDLY_SHOT = "Fish.png";
	private static final String ENEMY_SHOT = "Torpedo.png";
	private static final String BACKGROUND = "Deepsea.jpg";
	private static final String FOREGROUND = "";
	private static final String EXPLOSIONS = "Wirbel.gif";
	private static final String LIFE = "GreenHeart.png";
	private static final String[] ENEMIES = {"Fish1.png", "Octopus.gif"};
	private static final String[] HARD_OBSTACLES = {"HardCoral.png", "HardCoral2.png"};
	private static final String[] SOFT_OBSTACLES = {"SoftCoral.png"};

	// Keep the order (Extra points, LIFE point, clean the field, invincible)
	private final String[] EXTRAS = {"Coin.gif", "LifePoint.png", "Flash.png", "Shield.png"};

	@Override
	public String getPlayer() {
		return PLAYER;
	}

	@Override
	public String getFriendlyShot() {
		return FRIENDLY_SHOT;
	}

	@Override
	public String getEnemyShot() {
		return ENEMY_SHOT;
	}

	@Override
	public String getBackground() {
		return BACKGROUND;
	}

	@Override
	public String getForeground() {
		return FOREGROUND;
	}

	@Override
	public String[] getEnemies() {
		return ENEMIES;
	}

	@Override
	public String[] getHardObstacles() {
		return HARD_OBSTACLES;
	}

	@Override
	public String[] getSoftObstacles() {
		return SOFT_OBSTACLES;
	}

	@Override
	public String[] getExtras() {
		return EXTRAS;
	}

	@Override
	public String getExplosion() {
		return this.EXPLOSIONS;
	}

	@Override
	public String getLife() {
		return this.LIFE;
	}
}
