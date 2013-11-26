package ch.zhaw.mcag.view;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.GameContext;
import ch.zhaw.mcag.ItemFactory;
import ch.zhaw.mcag.level.Level;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Menu {

	private int cursorY;
	private int selected;
	private int state;
	private Board board;
	private GameContext context;
	private String playerName;
	private Font big = new Font("sans", Font.PLAIN, 50);
	private Font medium = new Font("sans", Font.PLAIN, 36);
	private Font small = new Font("sans", Font.PLAIN, 24);
	private int menuX = Config.getBoardDimension().getLength() / 2 - 170;
	private int levelX = menuX;
	private int selectedLevel;
	private int level;
	//private Config config;
	private ImageIcon spaceLevelImage;
	private ImageIcon deepseaLevelImage;

	public Menu(Board board, GameContext context) {
		cursorY = 280;
		state = 1;
		selected = 2;
		selectedLevel = 1;
		level = 1;
		this.board = board;
		this.context = context;
		this.playerName = "PLAYER";
		//config = context.getConfig();
		spaceLevelImage = new ImageIcon(Config.getImagePath()+"Player.png");
		deepseaLevelImage = new ImageIcon(Config.getImagePath()+"Submarine.png");
		
	}

	public void draw(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(0, 0, 0, 128)); // semi transparent black
		g2d.fillRect(Config.getBoardDimension().getLength() / 2 - 250, Config
				.getBoardDimension().getHeight() / 2 - 300, 500, 600);
		g2d.setColor(Color.WHITE);
		g2d.setFont(big);
		g2d.drawString("MCAG", menuX, 180);
		g2d.setFont(medium);

		if (state == 1) {
			showMainMenu(g2d);
		} else if (state == 2) {
			showNameMenu(g2d);
		} else if (state == 3) {
			showLevelMenu(g2d);
		} else if (state == 4) {
			showControllerMenu(g2d);
		} else if (state == 5) {
			showHighscoreMenu(g2d);
		}
	}

	private void showMainMenu(Graphics2D g2d) {
		if (context.getPoints() != 0 && context.getLifes() > 0) {
			g2d.drawString("Spiel fortsetzen", Config.getBoardDimension()
					.getLength() / 2 - 150, 250);
		}
		if (context.getPoints() == 0) {
			g2d.drawString("Spiel beginnen", menuX + 20, 300);
		} else {
			g2d.drawString("Neues Spiel", menuX + 20, 300);
		}
		g2d.drawString("Name Šndern",
				Config.getBoardDimension().getLength() / 2 - 150, 350);
		g2d.drawString("Level auswŠhlen", menuX + 20, 400);
		g2d.drawString("Controller einstellen", menuX + 20, 450);
		g2d.drawString("Highscore", menuX + 20, 500);
		g2d.drawString("Beenden", menuX + 20, 550);

		g2d.fillOval(menuX - 30, cursorY, 20, 20);
		
	}

	private void showControllerMenu(Graphics2D g2d) {
		g2d.drawString("Controller wŠhlen ", menuX, 250);
	}

	private void showHighscoreMenu(Graphics2D g2d) {
		g2d.drawString("Highscore ", menuX, 250);
		g2d.setFont(small);
		g2d.drawString("Name ", menuX, 300);
		g2d.drawString("Score ", menuX + 270, 300);
		g2d.drawLine(menuX, 310, menuX + 350, 310);
	}

	private void showNameMenu(Graphics2D g2d) {
		g2d.drawString("Name ", menuX, 250);
		g2d.drawString(playerName, menuX, 300);
	}

	private void showLevelMenu(Graphics2D g2d) {
		g2d.drawString("Level wŠhlen ", menuX, 250);
		g2d.drawRect(levelX, 300, 100, 100);
		//JLabel j = new JLabel((Icon) spaceLevelImage.getImage());
		//g2d.drawImage(spaceLevelImage.getImage(), levelX, 300, null);
		//spaceLevelImage.paintIcon(null, g2d, levelX, 300);
		g2d.drawImage(spaceLevelImage.getImage(), levelX, 300, board);
		//g2d.drawImage(spaceLevelImage.getImage(), levelX + 200, 300, null);
	}

	public void select(int selected) {
		switch (selected) {
		case 1: // Spiel fortsetzen
			board.toggleMenu();
			break;
		case 2: // Neues Spiel
			this.context.resetContext();
			board.toggleMenu();
			break;
		case 3: // Name Šndern
			state = 2;
			break;
		case 4: // Level auswŠhlen
			state = 3;
			break;
		case 5: // Controller einstellen
			state = 4;
			break;
		case 6: // Highscore
			state = 5;
			break;
		case 7: // Beenden
			System.exit(0);
		}
	}

	public void up() {
		if (state == 1) {
			if (context.getPoints() == 0) {
				if (cursorY > 280) {
					cursorY -= 50;
					selected--;
				} else {
					cursorY = 530;
					selected = 7;
				}
			} else {
				if (cursorY > 230) {
					cursorY -= 50;
					selected--;
				} else {
					cursorY = 530;
					selected = 7;
				}
			}
		}
	}

	public void down() {
		if (state == 1) {
			if (context.getPoints() == 0) {
				if (cursorY < 530) {
					cursorY += 50;
					selected++;
				} else {
					cursorY = 280;
					selected = 2;
				}
			} else {
				if (cursorY < 530) {
					cursorY += 50;
					selected++;
				} else {
					cursorY = 230;
					selected = 1;
				}
			}
		}
	}

	public void left() {
		if (state == 3) {
			if (levelX > menuX) {
				levelX = menuX;
				selectedLevel = 1;
			}
		}
	}

	public void right() {
		if (state == 3) {
			if (levelX < menuX + 200) {
				levelX += 200;
				selectedLevel = 2;
			}
		}
	}

	public void setLevel() {
		if (selectedLevel == 1) {
			Config.setLevel(Level.LEVEL_SPACE);
		}
		if (selectedLevel == 2) {
			Config.setLevel(Level.LEVEL_DEEPSEA);
		}
		context.setPlayer(ItemFactory.createPlayer());
		context.setBackground(ItemFactory.createBackground());
	}

	public int getLevel() {
		return level;
	}

	public void addCharToName(char a) {
		if (state == 2) {
			playerName = playerName + a;
		}

	}

	public void deleteCharFromName() {
		if (playerName.length() > 0 && state == 2) {
			playerName = playerName.substring(0, playerName.length() - 1);
		}
	}

	public int getState() {
		return state;
	}

	public int getSelected() {
		return selected;
	}

	public void setState(int i) {
		state = i;
	}

	public void reset() {
		cursorY = 230;
		state = 1;
		selected = 1;
	}
}
