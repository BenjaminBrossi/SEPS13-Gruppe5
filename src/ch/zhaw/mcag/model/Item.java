package ch.zhaw.mcag.model;

import java.awt.Image;

public class Item implements Drawable {
	private Dimension dimension;
	protected Position position;
	protected Image image;

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
}
