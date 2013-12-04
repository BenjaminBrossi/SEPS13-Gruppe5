package ch.zhaw.mcag.level;

/**
 * Level space
 *
 */
public class Space implements LevelInterface {

	private final String PLAYER = "Player.png";
	private final String FRIENDLY_SHOT = "Shot.png";
	private final String ENEMY_SHOT = "Shot_Opponent.png";
	private final String BACKGROUND = "Background.png";
	private final String FOREGROUND = "Earth.png";
	private final String EXPLOSIONS = "Impact.png";
	private final String LIFE = "GreenHeart.png";
	private final String[] ENEMIES = {"Alien.png", "Alien2.png", "Enemy.png"};
	private final String[] HARD_OBSTACLES = {"HRTA.png", "HRTA2.png", "HRTA3.png", "HRTA4.png"};
	private final String[] SOFT_OBSTACLES = {"Satelite.png"};

	// Keep the order (Extra points, life point, clean the field, invincible)
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
		return EXPLOSIONS;
	}

	@Override
	public String getLife() {
		return this.LIFE;
	}
}
