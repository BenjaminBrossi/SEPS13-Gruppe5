/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.zhaw.mcag.model;

import java.io.Serializable;

/**
 * The Highscore entry
 */
public class HighscoreEntry implements Comparable, Serializable {

	private final double points;
	private final String name;

	/**
	 * Create a new highscore entry
	 *
	 * @param points
	 * @param name
	 */
	public HighscoreEntry(double points, String name) {
		this.name = name;
		this.points = points;
	}

	/**
	 * Get the points of an entry
	 *
	 * @return
	 */
	public double getPoints() {
		return points;
	}

	/**
	 * Get the name of en entry
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Object o) {
		HighscoreEntry h = (HighscoreEntry) (o);
		return this.getPoints() < h.getPoints() ? 1 : -1;
	}
}
