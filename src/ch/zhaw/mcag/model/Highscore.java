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
 *
 * @author beni
 */
public class Highscore implements Iterable {

	private LinkedList<HighscoreEntry> table = new LinkedList<>();

	private Highscore(LinkedList<HighscoreEntry> table) {
		this.table = table;
	}

	public static Highscore getHighscore() {
		LinkedList<HighscoreEntry> table = new LinkedList<>();
		File f = new File("highscore.ser");
		if (f.exists()) {
			FileInputStream fileIn;
			ObjectInputStream in;
			try {
				fileIn = new FileInputStream("highscore.ser");
				in = new ObjectInputStream(fileIn);
				table = (LinkedList<HighscoreEntry>) in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("READ ERROR");
			}
	}
		Highscore hs = new Highscore(table);
		return hs;
	}

	public void addEntry(double points, String name) {
		this.table.add(new HighscoreEntry(points, name));
		Collections.sort(this.table);
		if (this.table.size() > Config.getHighscoreLimit()) {
			this.table.removeLast();
		}
		writeMe();
	}

	public double getLowestPointsInTable() {
		if (this.table.isEmpty()) {
			return 0;
		}
		return this.table.getLast().getPoints();
	}

	private void writeMe() {
		FileOutputStream fileOut;
		ObjectOutputStream out;

		try {
			fileOut = new FileOutputStream("highscore.ser");
			out = new ObjectOutputStream(fileOut);
			out.writeObject(table);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
			System.out.println("WRITE ERROR");
		}
	}

	@Override
	public Iterator<HighscoreEntry> iterator() {
		return this.table.iterator();
	}
}
