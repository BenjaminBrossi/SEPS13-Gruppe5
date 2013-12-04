package ch.zhaw.mcag.level;

/**
 * Interface for the levels
 *
 */
public interface LevelInterface {

	/**
	 * Get the player icon
	 *
	 * @return icon
	 */
	public String getPlayer();

	/**
	 * Get the friendly shot icon
	 *
	 * @return icon
	 */
	public String getFriendlyShot();

	/**
	 * Get the enemy shot icon
	 *
	 * @return icon
	 */
	public String getEnemyShot();

	/**
	 * Get the background icon
	 *
	 * @return icon
	 */
	public String getBackground();

	/**
	 * Get the foreground icon
	 *
	 * @return icon
	 */
	public String getForeground();

	/**
	 * Get the enemy icons
	 *
	 * @return icons
	 */
	public String[] getEnemies();

	/**
	 * Get the hard obstacle icons
	 *
	 * @return icons
	 */
	public String[] getHardObstacles();

	/**
	 * Get the soft obstacle icons
	 *
	 * @return icons
	 */
	public String[] getSoftObstacles();

	/**
	 * Get the extra icons
	 *
	 * Order: Extra points, LIFE point, clean the field, invincible
	 *
	 * @return icons
	 */
	public String[] getExtras();

	/**
	 * Get the explosion icon
	 *
	 * @return icons
	 */
	public String getExplosion();

	/**
	 * Get the life icon
	 *
	 * @return icon
	 */
	public String getLife();

}
