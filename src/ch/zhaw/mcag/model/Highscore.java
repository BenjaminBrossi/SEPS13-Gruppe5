/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.zhaw.mcag.model;

import ch.zhaw.mcag.Config;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author beni
 */
public class Highscore implements Serializable {

	private LinkedList<HighscoreEntry> table = new LinkedList<>();

	public Highscore getHighscore() {
		return this;
	}

	public void addEntry(double points, String name) {
		this.table.add(new HighscoreEntry(points, name));
		Collections.sort(this.table);
		if (this.table.size() > Config.getHighscoreLimit()) {
			this.table.removeLast();
		}
	}

	public double getLowestPointsInTable() {
		return this.table.getLast().getPoints();
	}
}
