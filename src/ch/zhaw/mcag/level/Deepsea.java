package ch.zhaw.mcag.level;

public class Deepsea implements LevelInterface {
	private String player = "Submarine.png";
	private String friendlyShot = "Fish.png";
	private String enemyShot = "Torpedo.png";
	private String background = "Deepsea.jpg";
	private String foreground = "";
	private String explosion = "Wirbel.gif";
	private String life = "GreenHeart.png";
	private String[] enemies = {"Fish1.png", "Octopus.gif"};
	private String[] hardObstacles = {"HardCoral.png", "HardCoral2.png"};
	private String[] softObstacles = {"SoftCoral.png"};

	// Keep the order (Extra points, life point, clean the field, invincible)
	private String[] extras = {"Coin.gif", "LifePoint.png", "Flash.png", "Shield.png"};

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getFriendlyShot() {
		return friendlyShot;
	}

	public void setFriendlyShot(String friendlyShot) {
		this.friendlyShot = friendlyShot;
	}

	public String getEnemyShot() {
		return enemyShot;
	}

	public void setEnemyShot(String enemyShot) {
		this.enemyShot = enemyShot;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getForeground() {
		return foreground;
	}

	public void setForeground(String foreground) {
		this.foreground = foreground;
	}

	public String[] getEnemies() {
		return enemies;
	}

	public void setEnemies(String[] enemies) {
		this.enemies = enemies;
	}

	public String[] getHardObstacles() {
		return hardObstacles;
	}

	public void setHardObstacles(String[] hardObstacles) {
		this.hardObstacles = hardObstacles;
	}

	public String[] getSoftObstacles() {
		return softObstacles;
	}

	public void setSoftObstacles(String[] softObstacles) {
		this.softObstacles = softObstacles;
	}

	public String[] getExtras() {
		return extras;
	}

	public void setExtras(String[] extras) {
		this.extras = extras;
	}

	@Override
	public String getExplosion() {
		return this.explosion;
	}

	@Override
	public void setExplosion(String explosion) {
		this.explosion = explosion;
	}

	@Override
	public String getLife() {
		return this.life;
	}

	public void setLife(String life) {
		this.life = life;
	}

}
