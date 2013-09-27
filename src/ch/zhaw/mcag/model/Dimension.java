package ch.zhaw.mcag.model;

public class Dimension {
	private int height;
	private int length;

	public Dimension(int height, int length) {
		this.height = height;
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
