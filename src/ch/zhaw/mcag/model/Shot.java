package ch.zhaw.mcag.model;

import ch.zhaw.mcag.*;

public class Shot extends Item implements Movable, Destroyable {

    public Shot(int x, int y, int h, int l) {
		super(x, y, h, l);
	}

    public void move() {
        this.getPosition().setX(this.getPosition().getX() + Config.MISSILE_SPEED);
        if (this.getPosition().getX() > Config.BOARD_WIDTH){
            this.destroy();
        }
    }

	public void destroy() {
		Game.destroyItem(this);
	}
}