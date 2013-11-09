package ch.zhaw.mcag.model;

import java.awt.*;

import ch.zhaw.mcag.Config;

public class Item implements Drawable {
	protected Dimension dimension;
	protected Position position;
	protected Image image;
	protected boolean good = false;
	protected boolean disposed = false;
	protected boolean hadCollision = false;
	protected int flicker = 0;
	protected boolean flickerEnabled = false;

	public Item(Position position, Dimension dimension, Image image) {
		this.position = position;
		this.dimension = dimension;
		this.image = image;
	}

	@Override
	public Dimension getDimension() {
		return dimension;
	}

	@Override
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public Image getImage() {
		return this.image;
	}

	@Override
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

	public Rectangle getLimits() {
		return new Rectangle(position.getX(), position.getY(), dimension.getLength(), dimension.getHeight());
	}

	public Position hasCollision(Item i) {
		if (!this.getLimits().intersects(i.getLimits())) {
			return new Position(0, 0);
		} else {
			Rectangle intersection = this.getLimits().intersection(i.getLimits());
			return new Position((int) intersection.getCenterX(), (int) intersection.getCenterY());
		}
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

	public void destroy() {

	}

	public void collide() {
		if (!this.hadCollision) {
			this.hadCollision = true;
			this.disposed = true;
		}
	}

	public boolean hadCollision() {
		return this.hadCollision;
	}

	public boolean flicker() {
		if (!flickerEnabled) {
			return true;
		}
		if (flicker > 500 / Config.getGameSpeed()) {
			this.disposed = true;
		}
		return ++flicker % 5 == 0;
	}

	public void setFlicker(boolean flicker) {
		this.flicker = 0;
		this.flickerEnabled = flicker;
	}
}