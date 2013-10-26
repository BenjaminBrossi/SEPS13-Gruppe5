package ch.zhaw.mcag.model.creature;

import java.awt.Image;
import java.awt.event.KeyEvent;

import ch.zhaw.mcag.ItemFactory;
import ch.zhaw.mcag.model.*;

public class Player extends Creature {
	protected boolean good = true;

	public Player(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	public Shot shoot() {
		return ItemFactory.createShot(this);
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			this.shoot();
		}

		if (key == KeyEvent.VK_LEFT) {
			this.dx = -2;
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.dx = 2;
		}

		if (key == KeyEvent.VK_UP) {
			this.dy = -2;
		}

		if (key == KeyEvent.VK_DOWN) {
			this.dy = 2;
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

	public boolean isGood(){
		return this.good;
	}
}
