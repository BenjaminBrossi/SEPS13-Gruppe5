package ch.zhaw.mcag.model.creature;

import ch.zhaw.mcag.model.Dimension;
import ch.zhaw.mcag.model.Position;
import ch.zhaw.mcag.model.Shot;
import com.leapmotion.leap.Vector;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;

public class Player extends Creature {
    private ArrayList<Shot> shots;
    protected String imagePath = "alien.gif";
    private long nextShot;

    public Player(int x, int y, int h, int l) {
        super(x, y, h, l);
        shots = new ArrayList<Shot>();
        ImageIcon ii = new ImageIcon(this.getClass().getResource(this.imagePath));
        this.setDimension(new Dimension(ii.getIconHeight(), ii.getIconWidth()));
        this.setImage(ii.getImage());
        this.nextShot = Calendar.getInstance().getTimeInMillis();
    }

    public void shoot() {
        long currentMils = Calendar.getInstance().getTimeInMillis();
        System.out.println("delta: " + (currentMils - nextShot));
        if (nextShot <= Calendar.getInstance().getTimeInMillis()) {
            int posX = this.getPosition().getX() + this.getDimension().getHeight();
            int posY = this.getPosition().getY() + this.getDimension().getLength();
            shots.add(new Shot(posX, posY, 0, 0));
            nextShot = Calendar.getInstance().getTimeInMillis() + 400;
        }
    }

    public void PlacePlayer(Vector v, Dimension d) {
        float currentX = v.getX();
        float currentY = v.getY();

        // normalize
        if (currentX < -100) {
            currentX = -100;
        } else if (currentX > 100) {
            currentX = 100;
        }

        if (currentY < 100) {
            currentY = 100;
        } else if (currentY > 250) {
            currentY = 250;
        }

        currentX += 100;
        currentY -= 100;

        int newX, newY;
        int maxWidth = d.getLength() - this.getDimension().getLength();
        int maxHeight = d.getHeight() - this.getDimension().getHeight();
        newX = (int) (currentX / 2 * maxWidth / 100);
        newY = maxHeight - (int) ((currentY / 1.50) * maxHeight / 100);

        System.out.println(d.getHeight() + " " + d.getLength());

        this.setPosition(new Position(newX, newY));
        this.dx = 0;
        this.dy = 0;
    }

    public void moveUp() {
        this.dy = 1;
    }

    public void moveDown() {
        this.dy = -1;
    }

    public void moveForward() {
        this.dx = 1;
    }

    public void moveBackward() {
        this.dx = -1;
    }

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
