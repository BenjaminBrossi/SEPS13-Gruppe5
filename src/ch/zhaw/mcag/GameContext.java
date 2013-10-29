package ch.zhaw.mcag;

import java.util.*;

import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.*;
import ch.zhaw.mcag.model.obstacle.*;

public class GameContext {
	// Config
	private Config config;
	
	// Player
	private Player player;
	
	// Background
	private Background background;
	
	// Items
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	private List<Obstacle> hardObstacles = new LinkedList<Obstacle>();
	private List<Obstacle> softObstacles = new LinkedList<Obstacle>();
	private LinkedList<Shot> shots = new LinkedList<Shot>();
	
	// State
	private boolean pause;

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public LinkedList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(LinkedList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public List<Obstacle> getHardObstacles() {
		return hardObstacles;
	}

	public void setHardObstacles(List<Obstacle> hardObstacles) {
		this.hardObstacles = hardObstacles;
	}

	public List<Obstacle> getSoftObstacles() {
		return softObstacles;
	}

	public void setSoftObstacles(List<Obstacle> softObstacles) {
		this.softObstacles = softObstacles;
	}

	public LinkedList<Shot> getShots() {
		return shots;
	}

	public void setShots(LinkedList<Shot> shots) {
		this.shots = shots;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	
}
