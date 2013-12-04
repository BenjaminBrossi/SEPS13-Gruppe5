/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.zhaw.mcag.model;

import ch.zhaw.mcag.Config;
import java.io.*;
import java.util.*;

/**
 * The highscore implemented as singleton
 */
public class Highscore implements Iterable {

	private LinkedList<HighscoreEntry> table = new LinkedList<>();
	private final String path;

	private Highscore(LinkedList<HighscoreEntry> table, String path) {
		this.path = path;
		this.table = table;
	}

	/**
	 * Get the highscore
	 *
	 * @param path
	 * @return
	 */
	public static Highscore getHighscore(String path) {
		LinkedList<HighscoreEntry> table = new LinkedList<>();
		File f = new File(path);
		if (f.exists()) {
			FileInputStream fileIn;
			ObjectInputStream in;
			try {
				fileIn = new FileInputStream(path);
				in = new ObjectInputStream(fileIn);
				table = (LinkedList<HighscoreEntry>) in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("READ ERROR");
			}
		}
		Highscore hs = new Highscore(table, path);
		return hs;
	}

	/**
	 * Add an entry to the highscore
	 *
	 * @param points
	 * @param name
	 */
	public void addEntry(double points, String name) {
		this.table.add(new HighscoreEntry(points, name));
		Collections.sort(this.table);
		if (this.table.size() > Config.getHighscoreLimit()) {
			this.table.removeLast();
		}
		writeMe();
	}

	/**
	 * Get the points of the last entry
	 *
	 * @return points
	 */
	public double getLowestPointsInTable() {
		if (this.table.size() < Config.getHighscoreLimit()) {
			return 0;
		}
		return this.table.getLast().getPoints();
	}

	private void writeMe() {
		FileOutputStream fileOut;
		ObjectOutputStream out;

		try {
			fileOut = new FileOutputStream(this.path);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(table);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			System.out.println("WRITE ERROR");
		}
	}

	@Override
	public Iterator<HighscoreEntry> iterator() {
		return this.table.iterator();
	}
}
