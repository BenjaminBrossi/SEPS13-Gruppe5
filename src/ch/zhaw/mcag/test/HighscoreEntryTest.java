/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.zhaw.mcag.test;

import ch.zhaw.mcag.model.HighscoreEntry;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author beni
 */
public class HighscoreEntryTest extends TestCase {

	private HighscoreEntry entryA;
	private HighscoreEntry entryB;
	private HighscoreEntry entryC;
	private HighscoreEntry entryD;

	/**
	 * Set up the test. Initialize the Highscore entries
	 */
	@Override
	public void setUp() {
		entryA = new HighscoreEntry(10000, "Benjamin");
		entryB = new HighscoreEntry(20000, "Samuel");
		entryC = new HighscoreEntry(30000, "Thomas");
		entryD = new HighscoreEntry(40000, "Michael");
	}

	/**
	 * Tear the test down. Unset the object.
	 */
	@Override
	public void tearDown() {
		entryA = null;
		entryB = null;
		entryC = null;
		entryD = null;
	}

	/**
	 * Test getPoints method, of class HighscoreEntry.
	 */
	@Test
	public void testGetPoints() {
		HighscoreEntryTest.assertEquals(10000d, entryA.getPoints());
		HighscoreEntryTest.assertEquals(20000d, entryB.getPoints());
		HighscoreEntryTest.assertEquals(30000d, entryC.getPoints());
		HighscoreEntryTest.assertEquals(40000d, entryD.getPoints());
	}

	/**
	 * Test getName method, of class HighscoreEntry.
	 */
	@Test
	public void testGetName() {
		HighscoreEntryTest.assertEquals("Benjamin", entryA.getName());
		HighscoreEntryTest.assertEquals("Samuel", entryB.getName());
		HighscoreEntryTest.assertEquals("Thomas", entryC.getName());
		HighscoreEntryTest.assertEquals("Michael", entryD.getName());
	}

	/**
	 * Test compareTo method, of class HighscoreEntry.
	 */
	@Test
	public void testCompareTo() {
		HighscoreEntryTest.assertEquals(1, entryA.compareTo(entryB));
		HighscoreEntryTest.assertEquals(1, entryA.compareTo(entryC));
		HighscoreEntryTest.assertEquals(1, entryA.compareTo(entryD));
		HighscoreEntryTest.assertEquals(1, entryB.compareTo(entryC));
		HighscoreEntryTest.assertEquals(1, entryB.compareTo(entryD));
		HighscoreEntryTest.assertEquals(1, entryC.compareTo(entryD));

		HighscoreEntryTest.assertEquals(-1, entryD.compareTo(entryC));
		HighscoreEntryTest.assertEquals(-1, entryD.compareTo(entryB));
		HighscoreEntryTest.assertEquals(-1, entryD.compareTo(entryA));
		HighscoreEntryTest.assertEquals(-1, entryC.compareTo(entryB));
		HighscoreEntryTest.assertEquals(-1, entryC.compareTo(entryA));
		HighscoreEntryTest.assertEquals(-1, entryB.compareTo(entryA));

		HighscoreEntryTest.assertEquals(-1, entryA.compareTo(entryA));
		HighscoreEntryTest.assertEquals(-1, entryB.compareTo(entryB));
		HighscoreEntryTest.assertEquals(-1, entryC.compareTo(entryC));
		HighscoreEntryTest.assertEquals(-1, entryD.compareTo(entryD));
	}

}
