package ch.zhaw.mcag.model;

import java.awt.Image;

import ch.zhaw.mcag.Config;

public class Background extends Item {
	public Background(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}
	
	public void move(){
		if(this.getPosition().getX() + this.getDimension().getLength() < 0){
			this.getPosition().setX(0);
		}
		
		this.getPosition().setX(this.getPosition().getX() - Config.getBACKGROUND_SPEED());
	}
}
