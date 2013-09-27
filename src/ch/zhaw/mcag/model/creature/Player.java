package ch.zhaw.mcag.model.creature;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import ch.zhaw.mcag.model.Shot;

public class Player extends Creature {
	private ArrayList<Shot> shots;

	public Player(int x, int y, int h, int l) {
		super(x, y, h, l);
		shots = new ArrayList<Shot>();
	}

	public void shoot() {
		int posX = this.getPosition().getX() + this.getDimension().getHeight();
		int posY = this.getPosition().getY() + this.getDimension().getLength();
		shots.add(new Shot(posX, posY, 0, 0));
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			this.shoot();
		}

		if (key == KeyEvent.VK_LEFT) {
			this.dx = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.dx = 1;
		}

		if (key == KeyEvent.VK_UP) {
			this.dy = -1;
		}

		if (key == KeyEvent.VK_DOWN) {
			this.dy = 1;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			this.dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			this.dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			this.dy = 0;
		}
	}

	public ArrayList<Shot> getShots() {
		return this.shots;
	}

}
