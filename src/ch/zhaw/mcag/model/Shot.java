package ch.zhaw.mcag.model;

import java.awt.Image;

import ch.zhaw.mcag.*;

public class Shot extends Item implements Movable, Destroyable {
	private int direction = 1;
	private boolean good = true;

	public Shot(Position position, Dimension dimension, Image image, boolean good) {
		super(position, dimension, image);
		if(!good){
			this.direction = -1;
			this.good = false;
		}
	}

	public void move() {
		this.getPosition().setX(this.getPosition().getX() + Config.getMISSILE_SPEED() * this.direction * 2);
		if ((this.getPosition().getX() < 0 && !this.good) || 
				(this.getPosition().getX() > Config.getBOARD_DIMESION().getLength() && this.good)) {
			this.destroy();
		}
	}
	
	public void destroy() {
	}
}