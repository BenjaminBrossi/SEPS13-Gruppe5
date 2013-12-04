package ch.zhaw.mcag.model;

import ch.zhaw.mcag.Game;

/**
 * Interface for collectable items
 */
public interface Collectable {

	/**
	 * Collect the item
	 *
	 * @param context
	 */
	public void collect(Game context);
}
