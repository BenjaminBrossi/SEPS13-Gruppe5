package ch.zhaw.mcag.model.creature;

import ch.zhaw.mcag.model.Dimension;
import ch.zhaw.mcag.model.Position;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import ch.zhaw.mcag.model.Shot;
import com.leapmotion.leap.Vector;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Calendar;
import java.util.Date;

public class Player extends Creature {
	private ArrayList<Shot> shots;
	protected String imagePath = "alien.gif";
        private long nextShot;

	public Player(int x, int y, int h, int l) {
		super(x, y, h, l);
		shots = new ArrayList<Shot>();
		ImageIcon ii = new ImageIcon(this.getClass().getResource(this.imagePath));
		this.setImage(ii.getImage());
                this.nextShot = Calendar.getInstance().getTimeInMillis();
	}

	public void shoot() {
            long currentMils = Calendar.getInstance().getTimeInMillis();
            System.out.println("delta: " + (currentMils - nextShot));                    
                if(nextShot <= Calendar.getInstance().getTimeInMillis()){
                    int posX = this.getPosition().getX() + this.getDimension().getHeight();
                    int posY = this.getPosition().getY() + this.getDimension().getLength();
                    shots.add(new Shot(posX, posY, 0, 0));
                    nextShot = Calendar.getInstance().getTimeInMillis() + 400;
                }
	}
        
        public void PlacePlayer(Vector v, Dimension d){
            float currentX = (float) ((float)v.getX() + (d.getLength()/2 - 50) + (Math.pow(v.getX(),3))/10000);
            float currentY = (float) (((v.getY()) * 2) + (Math.pow(v.getY(),3))/10000) - 600;
            int maxWidth = d.getLength();
            int minWidth = 0;
            int maxHeight = d.getHeight();
            int minHeight = 0;
            
            int newX, newY;
            
            if(currentX > maxWidth) newX = (int)maxWidth;
            else if(currentX < minWidth) newX = (int)minWidth;
            else newX = (int) currentX;
            
            if(currentY > maxHeight) newY = (int)maxHeight;
            else if(currentY < minHeight) newY = (int)minHeight;
            else newY = maxHeight - (int)currentY;
            
            this.setPosition(new Position(newX, newY));
            this.dx = 0;
            this.dy = 0;
        }
        
        public void moveUp(){ this.dy = 1;}
        public void moveDown(){this.dy = -1;}
        public void moveForward(){this.dx = 1;}
        public void moveBackward(){this.dx = -1;}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			this.shoot();
		}

		if (key == KeyEvent.VK_LEFT) {
			this.dx = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.dx = 1;
		}

		if (key == KeyEvent.VK_UP) {
			this.dy = -1;
		}

		if (key == KeyEvent.VK_DOWN) {
			this.dy = 1;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			this.dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			this.dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			this.dy = 0;
		}
	}

	public ArrayList<Shot> getShots() {
		return this.shots;
	}

}
