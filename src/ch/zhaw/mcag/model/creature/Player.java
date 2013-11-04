package ch.zhaw.mcag.model.creature;

import java.awt.Image;

import ch.zhaw.mcag.*;
import ch.zhaw.mcag.model.*;

public class Player extends Creature {
	protected boolean good = true;

	public Player(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	public Shot shoot() {
		return ItemFactory.createShot(this);
	}
	
	public boolean isGood(){
		return this.good;
	}
}
