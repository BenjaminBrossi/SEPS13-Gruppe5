package ch.zhaw.mcag.model;

import java.awt.Image;

public interface Drawable {

	public Image getImage();

	public void setImage(Image image);

	public Dimension getDimension();

	public void setDimension(Dimension dimension);

	public Position getPosition();

	public void setPosition(Position position);
}
