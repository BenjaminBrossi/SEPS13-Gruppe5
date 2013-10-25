package ch.zhaw.mcag;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.Timer;

import ch.zhaw.mcag.model.Shot;
import ch.zhaw.mcag.model.creature.*;
import ch.zhaw.mcag.sensor.SensorListener;
import ch.zhaw.mcag.sensor.ShootListener;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Listener;

public class Board extends JPanel implements ActionListener, WindowListener {

	private static final long serialVersionUID = 6466804428038769553L;
	private Timer timer;
	public Player player;
        Controller controller;
        Listener sensorListener;
        Listener shootListener;

	public Board() {

		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		player = new Player(40, 60 , 0, 0);
                
                controller = new Controller();
                sensorListener = new SensorListener(this);
                controller.addListener(sensorListener);
                shootListener = new ShootListener(player);
                controller.addListener(shootListener);

		timer = new Timer(Config.GAME_SPEED, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(player.getImage(), player.getPosition().getX(), player.getPosition().getY(), this);
		
		ArrayList<Shot> shots = player.getShots();
		Iterator<Shot> itr = shots.iterator();
		
		while(itr.hasNext()){
			Shot shot = itr.next();
			g2d.drawImage(shot.getImage(), shot.getPosition().getX(), shot.getPosition().getY(), this);
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<Shot> shots = player.getShots();
		Iterator<Shot> itr = shots.iterator();
		
		while(itr.hasNext()){
			Shot shot = itr.next();
			shot.move();
		}
		player.move();
		repaint();
	}

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
	}

}