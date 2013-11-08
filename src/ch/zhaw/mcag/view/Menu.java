package ch.zhaw.mcag.view;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.GameContext;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Menu {

	private int x;
	private int selected;
	private int state;
	private Board board;
	private GameContext context;

	public Menu(Board board, GameContext context) {
		x = 280;
		state = 1;
		selected = 2;
		this.board = board;
		this.context = context;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(new Color(0, 0, 0, 128));
		g2d.fillRect(Config.getBoardDimension().getLength() / 2 - 250, Config
				.getBoardDimension().getHeight() / 2 - 300, 500, 600);
		g2d.setColor(Color.WHITE);
		Font font = new Font("sans", Font.PLAIN, 50);
		g2d.setFont(font);
		g2d.drawString("MCAG",
				Config.getBoardDimension().getLength() / 2 - 170, 180);
		font = new Font("sans", Font.PLAIN, 36);
		g2d.setFont(font);

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
		if (context.getPoints() != 0) {
			g2d.drawString("Spiel fortsetzen", Config.getBoardDimension()
					.getLength() / 2 - 150, 250);
		}
		g2d.drawString("Neues Spiel",
				Config.getBoardDimension().getLength() / 2 - 150, 300);
		g2d.drawString("Name ändern",
				Config.getBoardDimension().getLength() / 2 - 150, 350);
		g2d.drawString("Level auswählen", Config.getBoardDimension()
				.getLength() / 2 - 150, 400);
		g2d.drawString("Controller einstellen", Config.getBoardDimension()
				.getLength() / 2 - 150, 450);
		g2d.drawString("Highscore",
				Config.getBoardDimension().getLength() / 2 - 150, 500);
		g2d.drawString("Beenden",
				Config.getBoardDimension().getLength() / 2 - 150, 550);

		g2d.fillOval(Config.getBoardDimension().getLength() / 2 - 200, x, 20,
				20);
	}

	private void showControllerMenu(Graphics2D g2d) {
		g2d.drawString("Controller wählen: ", Config.getBoardDimension()
				.getLength() / 2 - 150, 250);
	}

	private void showHighscoreMenu(Graphics2D g2d) {
		g2d.drawString("Highscore: ",
				Config.getBoardDimension().getLength() / 2 - 150, 250);
	}

	private void showNameMenu(Graphics2D g2d) {
		g2d.drawString("Name: ",
				Config.getBoardDimension().getLength() / 2 - 150, 250);
	}

	private void showLevelMenu(Graphics2D g2d) {
		g2d.drawString("Level wählen: ",
				Config.getBoardDimension().getLength() / 2 - 150, 250);
	}

	public void select(int selected) {
		switch (selected) {
		case 1: // Spiel fortsetzen
			board.toggleMenu();
			break;
		case 2: // Neues Spiel
			board.toggleMenu();
			break;
		case 3: // Name ändern
			state = 2;
			break;
		case 4: // Level auswählen
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
				if (x > 280) {
					x -= 50;
					selected--;
				} else {
					x = 530;
					selected = 7;
				}
			} else {
				if (x > 230) {
					x -= 50;
					selected--;
				} else {
					x = 530;
					selected = 7;
				}
			}
		}
	}

	public void down() {
		if (state == 1) {
			if (context.getPoints() == 0) {
				if (x < 530) {
					x += 50;
					selected++;
				} else {
					x = 280;
					selected = 2;
				}
			} else {
				if (x < 530) {
					x += 50;
					selected++;
				} else {
					x = 230;
					selected = 1;
				}
			}
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
	
	public void reset(){
		x = 230;
		state = 1;
		selected = 1;
	}
}
