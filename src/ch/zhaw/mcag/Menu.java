package ch.zhaw.mcag;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Menu{
	
		private int x;
		private int selected;
		private int state;
		private Board board;

		public Menu(Board board){
			x = 230;
			state = 1;
			selected = 1;
			this.board = board;
		}
		
		public void draw(Graphics2D g2d) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, Config.getBoardDimension().getLength(), Config.getBoardDimension().getHeight());
			g2d.setColor(Color.WHITE);
			Font font = new Font("sans", Font.PLAIN, 36);
			g2d.setFont(font);
			
			if (state == 1){
				showMainMenu(g2d);
			}
			if (state == 2){
				showNameMenu(g2d);
			}
			if (state == 3){
				showLevelMenu(g2d);
			}
		}
		
		public void showMainMenu(Graphics2D g2d){
			g2d.drawString("MCAG", Config.getBoardDimension().getLength()/2 - 100, 200);
			g2d.drawString("Neues Spiel", Config.getBoardDimension().getLength()/2 - 100, 250);
			g2d.drawString("Name Šndern", Config.getBoardDimension().getLength()/2 - 100, 300);
			g2d.drawString("Level auswŠhlen", Config.getBoardDimension().getLength()/2 - 100, 350);
			g2d.drawString("Controller einstellen", Config.getBoardDimension().getLength()/2 - 100, 400);
			g2d.drawString("Highscore", Config.getBoardDimension().getLength()/2 - 100, 450);
			g2d.drawString("Beenden", Config.getBoardDimension().getLength()/2 - 100, 500);
			
			g2d.fillOval(Config.getBoardDimension().getLength()/2 - 150, x, 20, 20);
		}
		
		public void showNameMenu(Graphics2D g2d){
			g2d.drawString("MCAG", Config.getBoardDimension().getLength()/2 - 100, 200);
			g2d.drawString("Name: ", Config.getBoardDimension().getLength()/2 - 100, 250);
		}
		
		public void showLevelMenu(Graphics2D g2d){
			g2d.drawString("MCAG", Config.getBoardDimension().getLength()/2 - 100, 200);
			g2d.drawString("Level wŠhlen: ", Config.getBoardDimension().getLength()/2 - 100, 250);
		}
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_UP) {
				up();
			}
			if (key == KeyEvent.VK_DOWN) {
				down();
			}
			if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
				select(selected);
			}
		}
		
		private void select(int selected) {
			switch(selected){	
				case 1: board.toggleMenu(); break; // Neues Spiel
				case 2: state = 2; break; // Name Šndern
				case 3: state = 3; break; // Level auswŠhlen
				case 4: break; // Controller einstellen
				case 5: break; // Highscore
				case 6: System.exit(0); // Beenden
			}
		}

		private void up(){
			if (x > 230){
				x -= 50;
				selected--;
			}
		}
		
		private void down(){
			if (x < 480){
				x += 50;
				selected++;
			}
		}
		
		public int getState(){
			return state;
		}

		public void reset() {
			x = 230;
			state = 1;
			selected = 1;
		}
}

