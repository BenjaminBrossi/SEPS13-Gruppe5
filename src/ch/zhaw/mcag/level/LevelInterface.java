package ch.zhaw.mcag.level;

public interface LevelInterface {

	public String getPlayer();

	public void setPlayer(String player);

	public String getFriendlyShot();

	public void setFriendlyShot(String friendlyShot);

	public String getEnemyShot();

	public void setEnemyShot(String enemyShot);

	public String getBackground();

	public void setBackground(String background);

	public String getForeground();

	public void setForeground(String foreground);

	public String[] getEnemies();

	public void setEnemies(String[] enemies);

	public String[] getHardObstacles();

	public void setHardObstacles(String[] hardObstacles);

	public String[] getSoftObstacles();

	public void setSoftObstacles(String[] softObstacles);

	public String[] getExtras();

	public void setExtras(String[] extras);

	public String getExplosion();

	public void setExplosion(String explosion);

	public String getLife();
}
