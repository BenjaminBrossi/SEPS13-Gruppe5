package ch.zhaw.mcag.model.obstacle;

import java.awt.Image;
import ch.zhaw.mcag.model.*;

public class Soft extends Obstacle implements Destroyable {

	public Soft(Position position, Dimension dimension, Image image) {
		super(position, dimension, image);
	}

	public void destroy() {
	}

}
