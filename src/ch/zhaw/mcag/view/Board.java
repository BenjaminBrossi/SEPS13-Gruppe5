package ch.zhaw.mcag.view;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.GameContext;
import ch.zhaw.mcag.ItemFactory;
import ch.zhaw.mcag.adapter.KeyboardAdapter;
import ch.zhaw.mcag.adapter.SensorAdapter;
import ch.zhaw.mcag.model.Extra;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import ch.zhaw.mcag.model.Shot;
import ch.zhaw.mcag.model.creature.Enemy;
import ch.zhaw.mcag.model.obstacle.Obstacle;
import ch.zhaw.mcag.sensor.IControlable;
import ch.zhaw.mcag.sensor.SensorListener;
import ch.zhaw.mcag.sensor.ShootListener;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Listener;

public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 6466804428038769553L;
	private GameContext c;
        private Controller leapController;
        private Listener sensorListener;
        private Listener shootListener;
        private IControlable leapAdapter;	
        private Menu menu;
	private boolean showMenu = true;


	public Board(GameContext c) {
                // add leap motion controller
                leapAdapter = new SensorAdapter(c);
                sensorListener = new SensorListener(leapAdapter);
                shootListener = new ShootListener(leapAdapter);
                leapController = new Controller();
                leapController.addListener(sensorListener);
                leapController.addListener(shootListener);
                
                addKeyListener(new KeyboardAdapter(c, this));
                
                this.menu = new Menu(this, c);
		setFocusable(true);
		setDoubleBuffered(true);
		this.c = c;
		c.setPlayer(ItemFactory.createPlayer());
		c.setBackground(ItemFactory.createBackground());

	}

	public void paint(Graphics g) {
		super.paint(g);

		this.paintBackground((Graphics2D) g);
		this.paintObstacles((Graphics2D) g);
		this.paintEnemies((Graphics2D) g);
		this.paintShots((Graphics2D) g);
		this.paintPlayer((Graphics2D) g);
                this.paintExtras((Graphics2D) g);

		Font font = new Font("sans", Font.PLAIN, 36);
		g.setColor(Color.green);
		g.setFont(font);
		g.drawString(c.getPoints() + "", 10, 50);

		if (showMenu == true) {
			this.paintMenu((Graphics2D) g);
		}


		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
        
        private void paintMenu(Graphics2D g2d) {
		menu.draw(g2d);
	}


	private void paintBackground(Graphics2D g2d) {
		int x = c.getBackground().getPosition().getX();
		int y = c.getBackground().getPosition().getY();
		g2d.drawImage(c.getBackground().getImage(), x - c.getBackground().getDimension().getLength(), y, Config.getBoardDimension().getLength(), Config.getBoardDimension().getHeight(), this);
		g2d.drawImage(c.getBackground().getImage(), x, y, Config.getBoardDimension().getLength(), Config.getBoardDimension().getHeight(), this);
		g2d.drawImage(c.getBackground().getImage(), x + c.getBackground().getDimension().getLength(), y, Config.getBoardDimension().getLength(), Config.getBoardDimension().getHeight(), this);
		ImageIcon foreground = new ImageIcon(this.getClass().getResource(Config.imagePath + Config.foreground));
		g2d.drawImage(foreground.getImage(), 0, Config.getBoardDimension().getHeight() - foreground.getIconHeight(), Config.getBoardDimension().getLength(), foreground.getIconHeight(), this);
	}

	private void paintPlayer(Graphics2D g2d) {
		g2d.drawImage(c.getPlayer().getImage(), c.getPlayer().getPosition().getX(), c.getPlayer().getPosition().getY(), this);
	}

	private synchronized void paintObstacles(Graphics2D g2d) {
		LinkedList<Obstacle> tmp = new LinkedList<Obstacle>(c.getHardObstacles());
		for (Obstacle obstacle : tmp) {
			g2d.drawImage(obstacle.getImage(), obstacle.getPosition().getX(), obstacle.getPosition().getY(), this);
		}

		tmp = new LinkedList<Obstacle>(c.getSoftObstacles());
		for (Obstacle obstacle : tmp) {
			g2d.drawImage(obstacle.getImage(), obstacle.getPosition().getX(), obstacle.getPosition().getY(), this);
		}
	}

	private synchronized void paintEnemies(Graphics2D g2d) {
		LinkedList<Enemy> tmp = new LinkedList<Enemy>(c.getEnemies());
		for (Enemy enemy : tmp) {
			g2d.drawImage(enemy.getImage(), enemy.getPosition().getX(), enemy.getPosition().getY(), this);
		}
	}

	private synchronized void paintShots(Graphics2D g2d) {
		LinkedList<Shot> tmp = new LinkedList<Shot>(c.getShots());
		for (Shot shot : tmp) {
			g2d.drawImage(shot.getImage(), shot.getPosition().getX(), shot.getPosition().getY(), this);
		}
	}
        
        private synchronized void paintExtras(Graphics2D g2d) {
        LinkedList<Extra> tmp = c.getExtras();
        for (Extra extra : tmp) {
                g2d.drawImage(extra.getImage(), extra.getPosition().getX(), extra.getPosition().getY(), this);
        }
        
        
	}


	public void actionPerformed(ActionEvent e) {
	}
        
        	public void toggleMenu() {
		c.setPause(!c.isPaused());
		showMenu = !showMenu;
	}

	public Menu getMenu() {
		return menu;
	}

	public boolean showMenu() {
		return showMenu;
	}

}