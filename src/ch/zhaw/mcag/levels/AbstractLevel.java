package ch.zhaw.mcag.levels;

public abstract class AbstractLevel {

	public abstract String getPlayer();

	public abstract void setPlayer(String player);

	public abstract String getFriendlyShot();

	public abstract void setFriendlyShot(String friendlyShot);

	public abstract String getEnemyShot();

	public abstract void setEnemyShot(String enemyShot);

	public abstract String getBackground();

	public abstract void setBackground(String background);

	public abstract String getForeground();

	public abstract void setForeground(String foreground);

	public abstract String[] getEnemies();

	public abstract void setEnemies(String[] enemies);

	public abstract String[] getHardObstacles();

	public abstract void setHardObstacles(String[] hardObstacles);

	public abstract String[] getSoftObstacles();

	public abstract void setSoftObstacles(String[] softObstacles);

	public abstract String[] getExtras();

	public abstract void setExtras(String[] extras);
}
