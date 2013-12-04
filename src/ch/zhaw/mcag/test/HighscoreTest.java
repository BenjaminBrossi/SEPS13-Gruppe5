/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.zhaw.mcag.test;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.model.Highscore;
import ch.zhaw.mcag.model.HighscoreEntry;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author beni
 */
public class HighscoreTest extends TestCase {

	private Highscore highscore;
	private final String PATH = "testHighscore.ser";
	private File file;

	@Override
	public void setUp() {
		file = new File(PATH);
	}

	@Override
	public void tearDown() {
		file.delete();
	}

	/**
	 * Test of getHighscore method, of class Highscore.
	 */
	@Test
	public void testGetHighscore() {
		HighscoreTest.assertEquals("Highscore", Highscore.getHighscore(PATH).getClass().getSimpleName());
	}

	/**
	 * Test of addEntry method, of class Highscore.
	 */
	@Test
	public void testAddEntry() {
		this.highscore = Highscore.getHighscore(PATH);

		this.highscore.addEntry(10000, "Benjamin");
		this.highscore.addEntry(20000, "Samuel");
		this.highscore.addEntry(30000, "Thomas");
		this.highscore.addEntry(40000, "Michael");
		this.highscore.addEntry(50000, "Franz");

		HighscoreTest.assertEquals(true, this.file.isFile());
	}

	/**
	 * Test of getLowestPointsInTable method, of class Highscore.
	 */
	@Test
	public void testGetLowestPointsInTable() {
		this.highscore = Highscore.getHighscore(PATH);
		LinkedList<Double> numbers = new LinkedList<>();

		for (int i = 0; i < Config.getHighscoreLimit() + 4; i++) {
			Double rand = Math.random() * 50000;
			numbers.add(rand);

			this.highscore.addEntry(rand, "Benjamin");

			if (i + 1 < Config.getHighscoreLimit()) {
				HighscoreTest.assertEquals(0d, this.highscore.getLowestPointsInTable());
			} else {
				Collections.sort(numbers, Collections.reverseOrder());
				Double check = numbers.get(Config.getHighscoreLimit() - 1);
				HighscoreTest.assertEquals(check, this.highscore.getLowestPointsInTable());
			}

		}
	}

	/**
	 * Test of iterator method, of class Highscore.
	 */
	@Test
	public void testIterator() {
		this.highscore = Highscore.getHighscore(PATH);
		this.highscore.addEntry(123456, "Christoph");
		HighscoreTest.assertEquals(true, this.highscore.iterator().hasNext());
	}

}
