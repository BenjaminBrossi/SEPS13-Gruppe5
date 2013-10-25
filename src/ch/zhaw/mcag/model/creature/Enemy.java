package ch.zhaw.mcag.model.creature;

import java.awt.Image;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.model.*;

public class Enemy extends Creature {
	protected boolean good = false;
	
	public Enemy(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}
	
	public boolean isGood(){
		return this.good;
	}
	
	public void move(){
		this.getPosition().setX(this.getPosition().getX() - Config.getBACKGROUND_SPEED() * 2);
	}
}
