package ch.zhaw.mcag.view;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.Game;
import ch.zhaw.mcag.model.ItemFactory;
import ch.zhaw.mcag.model.Position;
import ch.zhaw.mcag.level.Level;
import ch.zhaw.mcag.model.HighscoreEntry;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Iterator;
import javax.swing.ImageIcon;

/**
 * The menu
 */
public class Menu {

	private int cursorY;
	private int selected;
	private int state;
	private final Board board;
	private final Game context;
	private String playerName;
	private final Font big = new Font("sans", Font.PLAIN, 50);
	private final Font medium = new Font("sans", Font.PLAIN, 36);
	private final Font small = new Font("sans", Font.PLAIN, 24);
	private final int menuX = Config.getBoardDimension().getLength() / 2 - 170;
	private final int menuY = Config.getBoardDimension().getHeight() / 2 - 200;
	private int levelX = menuX;
	private int selectedLevel;
	private final int level;
	private final ImageIcon spaceLevelImage;
	private final ImageIcon deepseaLevelImage;

	/**
	 * Create a new menu
	 * 
	 * @param board
	 * @param context
	 */
	public Menu(Board board, Game context) {
		cursorY = menuY + 75;
		state = 1;
		selected = 2;
		selectedLevel = 1;
		level = 1;
		this.board = board;
		this.context = context;
		this.playerName = "";
		spaceLevelImage = new ImageIcon(this.getClass().getResource(
				Config.getImagePath() + "Player.png"));
		deepseaLevelImage = new ImageIcon(this.getClass().getResource(
				Config.getImagePath() + "Submarine.png"));

	}

	/**
	 * Draw the menu
	 * 
	 * @param g2d
	 *            graphic
	 */
	public void draw(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(0, 0, 0, 128)); // semi transparent black
		g2d.fillRect(Config.getBoardDimension().getLength() / 2 - 250, Config
				.getBoardDimension().getHeight() / 2 - 300, 500, 500);
		g2d.setColor(Color.WHITE);
		g2d.setFont(big);
		g2d.drawString("MCAG", menuX, menuY);
		g2d.setFont(medium);

		if (state == 1) {
			showMainMenu(g2d);
		} else if (state == 2) {
			showLevelMenu(g2d);
		} else if (state == 3) {
			showHighscoreMenu(g2d);
		} else if (state == 4) {
			showNameMenu(g2d);
		}
	}

	private void showMainMenu(Graphics2D g2d) {
		if (context.getPoints() == 0) {
			g2d.drawString("Spiel beginnen", menuX + 20, menuY + 100);
			g2d.drawString("Level wählen", menuX + 20, menuY + 150);
			g2d.drawString("Highscore", menuX + 20, menuY + 200);
			g2d.drawString("Beenden", menuX + 20, menuY + 250);
			g2d.fillOval(menuX - 30, cursorY, 20, 20);
		} else {
			g2d.drawString("Spiel fortsetzen", menuX + 20, menuY + 50);
			g2d.drawString("Neues Spiel", menuX + 20, menuY + 100);
			g2d.drawString("Level wählen", menuX + 20, menuY + 150);
			g2d.drawString("Highscore", menuX + 20, menuY + 200);
			g2d.drawString("Beenden", menuX + 20, menuY + 250);
			g2d.fillOval(menuX - 30, cursorY, 20, 20);
		}

	}

	private void showHighscoreMenu(Graphics2D g2d) {
		g2d.drawString("Highscore ", menuX, menuY + 50);
		g2d.setFont(small);
		g2d.drawString("Name ", menuX, menuY + 100);
		g2d.drawString("Score ", menuX + 270, menuY + 100);
		g2d.drawLine(menuX, menuY + 110, menuX + 350, menuY + 110);
		Iterator<HighscoreEntry> itr = context.getHighscore().iterator();
		int i = 1;
		while (itr.hasNext()) {
			HighscoreEntry he = itr.next();
			g2d.drawString(he.getName(), menuX, menuY + 100 + 50 * i);
			g2d.drawString((int) he.getPoints() + "", menuX + 270, menuY + 100
					+ 50 * i);
			i++;
		}
	}

	/**
	 * Show menu to enter the name
	 * 
	 * @param g2d
	 *            graphic
	 */
	public void showNameMenu(Graphics2D g2d) {
		g2d.drawString("Name ", menuX, menuY + 50);
		g2d.drawString(playerName, menuX, menuY + 100);
	}

	private void showLevelMenu(Graphics2D g2d) {
		g2d.drawString("Level wählen ", menuX, menuY + 50);
		g2d.drawRect(levelX, menuY + 120, 120, 120);
		g2d.drawImage(spaceLevelImage.getImage(), menuX + 25, menuY + 160,
				board);
		g2d.drawImage(deepseaLevelImage.getImage(), menuX + 205, menuY + 130,
				board);
	}

	/**
	 * Select a menu
	 * 
	 * @param selected
	 */
	public void select(int selected) {
		switch (selected) {
		case 1: // Spiel fortsetzen
			board.toggleMenu();
			break;
		case 2: // Neues Spiel
			this.context.resetContext();
			board.toggleMenu();
			break;
		case 3: // Level ausw�hlen
			state = 2;
			break;
		case 4: // Highscore
			state = 3;
			break;
		case 5: // Beenden
			System.exit(0);
		}
	}

	/**
	 * Cursor up
	 */
	public void up() {
		if (state == 1) {
			if (context.getPoints() == 0) {
				if (cursorY > menuY + 75) {
					cursorY -= 50;
					selected--;
				} else {
					cursorY = menuY + 225;
					selected = 5;
				}
			} else {
				if (cursorY > menuY + 25) {
					cursorY -= 50;
					selected--;
				} else {
					cursorY = menuY + 225;
					selected = 5;
				}
			}
		}
	}

	/**
	 * Cursor down
	 */
	public void down() {
		if (state == 1) {
			if (context.getPoints() == 0) {
				if (cursorY < menuY + 225) {
					cursorY += 50;
					selected++;
				} else {
					cursorY = menuY + 75;
					selected = 2;
				}
			} else {
				if (cursorY < menuY + 225) {
					cursorY += 50;
					selected++;
				} else {
					cursorY = menuY + 25;
					selected = 1;
				}
			}
		}
	}

	/**
	 * Cursor left
	 */
	public void left() {
		if (state == 2) {
			if (levelX > menuX) {
				levelX = menuX;
				selectedLevel = 1;
			}
		}
	}

	/**
	 * Cursor right
	 */
	public void right() {
		if (state == 2) {
			if (levelX < menuX + 200) {
				levelX += 200;
				selectedLevel = 2;
			}
		}
	}

	/**
	 * Select level
	 */
	public void setLevel() {
		if (selectedLevel == 1) {
			Config.setLevel(Level.LEVEL_SPACE);
		}
		if (selectedLevel == 2) {
			Config.setLevel(Level.LEVEL_DEEPSEA);
		}
		Position position = context.getPlayer().getPosition();
		context.setPlayer(ItemFactory.createPlayer());
		context.getPlayer().setPosition(position);
		context.setBackground(ItemFactory.createBackground());
	}

	/**
	 * Get the level
	 * 
	 * @return
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Add a character to the name
	 * 
	 * @param c
	 *            char
	 */
	public void addCharToName(char c) {
		if (state == 4) {
			/*
			 * if (playerName.equals("PLAYER")) { playerName = ""; }
			 */
			if (playerName.length() < 16) {
				playerName = playerName + c;
			}
		}

	}

	/**
	 * Delete a character from the name
	 */
	public void deleteCharFromName() {
		if (playerName.length() > 0 && state == 4) {
			playerName = playerName.substring(0, playerName.length() - 1);
		}
	}

	/**
	 * Get the state
	 * 
	 * @return state
	 */
	public int getState() {
		return state;
	}

	/**
	 * Get the selected entry
	 * 
	 * @return selected
	 */
	public int getSelected() {
		return selected;
	}

	/**
	 * Set the state
	 * 
	 * @param i
	 *            state
	 */
	public void setState(int i) {
		state = i;
	}

	/**
	 * Reset menu
	 */
	public void reset() {
		if (context.getPoints() < 1) {
			cursorY = menuY + 75;
			selected = 2;
		} else {
			cursorY = menuY + 25;
			selected = 1;
		}
		state = 1;
	}

	/**
	 * Commit selection
	 */
	public void enter() {
		if (state == 1) {
			select(selected);
		} else if (state == 2) {
			setLevel();
		} else if (state == 4) {
			context.getHighscore().addEntry(context.getPoints(), playerName);
			this.context.resetContext();
			state = 3;
		} else if(state == 3){
                    this.reset();
                } else if (state != 1) {
			state = 1;
		}
	}
}
