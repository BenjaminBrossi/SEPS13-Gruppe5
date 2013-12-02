/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.zhaw.mcag.model;

import java.io.Serializable;

/**
 *
 * @author beni
 */
public class HighscoreEntry implements Comparable, Serializable {

	private double points;
	private String name;

	public HighscoreEntry(double points, String name) {
		this.name = name;
		this.points = points;
	}

	public double getPoints() {
		return points;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Object o) {
		HighscoreEntry h = (HighscoreEntry) (o);
		return this.getPoints() < h.getPoints() ? 1 : -1;
	}
}
