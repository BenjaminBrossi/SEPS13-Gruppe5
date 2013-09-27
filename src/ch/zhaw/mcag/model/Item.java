package ch.zhaw.mcag.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Item implements Drawable {
	private Dimension dimension;
	protected Position position;
	protected Image image;
	protected String imagePath = "arr.png";

	public Item(int x, int y, int h, int l) {
		this.position = new Position(x, y);
		this.dimension = new Dimension(h, l);
		ImageIcon ii = new ImageIcon(this.getClass().getResource(this.imagePath));
		this.setImage(ii.getImage());
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
