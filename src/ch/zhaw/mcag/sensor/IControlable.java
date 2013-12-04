package ch.zhaw.mcag.sensor;

/**
 * Controller interface
 */
public interface IControlable {

	/**
	 * Place the player item on the board
	 *
	 * @param x location x axis
	 * @param y location y axis
	 */
	public void placePlayer(int x, int y);

	/**
	 * Fire a shot
	 */
	public void shoot();
}
