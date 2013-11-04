package ch.zhaw.mcag.model;

import java.awt.*;

import ch.zhaw.mcag.Config;

public class Item implements Drawable {
	protected Dimension dimension;
	protected Position position;
	protected Image image;
	protected boolean good = false;
	protected boolean disposed = false;

	public Item(Position position, Dimension dimension, Image image) {
		this.position = position;
		this.dimension = dimension;
		this.image = image;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}


	public boolean isOutside() {
		int l = this.getDimension().getLength();
		int x = this.getPosition().getX();
		int board = Config.getBoardDimension().getLength();

		if (x + l < 0 || x > board) {
			return true;
		}

		return false;
	}

	public boolean touchesEdge() {
		int h = this.getDimension().getHeight();
		int y = this.getPosition().getY();
		int board = Config.getBoardDimension().getHeight();

		if (y <= 0 || y + h >= board) {
			return true;
		}
		return false;
	}
	
	public Rectangle getLimits(){
		return new Rectangle(position.getX(), position.getY(), dimension.getLength(), dimension.getHeight());
	}
	
	public boolean hasCollision(Item i){
		return this.getLimits().intersects(i.getLimits());
	}

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

	public boolean isDisposed() {
		return disposed;
	}

	public void setDisposed(boolean disposed) {
		this.disposed = disposed;
	}
	
	public void destroy(){
		
	}
}
