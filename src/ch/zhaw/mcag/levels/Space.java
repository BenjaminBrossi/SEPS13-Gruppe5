package ch.zhaw.mcag.levels;

public class Space extends AbstractLevel {
	private String player = "Player.png";
	private String friendlyShot = "Shot.png";
	private String enemyShot = "Shot_Opponent.png";
	private String background = "Background.png";
	private String foreground = "Earth.png";
	private String[] enemies = { "Alien.png", "Alien2.png" };
	private String[] hardObstacles = { "HRTA.png", "HRTA2.png", "HRTA3.png", "HRTA4.png" };
	private String[] softObstacles = { "Satelite.png" };
	private String[] extras = { "Coin.gif" };

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

}
