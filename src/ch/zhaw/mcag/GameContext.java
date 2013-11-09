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
	private double points = 1;

	// Background
	private Background background;

	// Items
	private LinkedList<Enemy> enemies = new LinkedList<>();
	private LinkedList<Hard> hardObstacles = new LinkedList<>();
	private LinkedList<Soft> softObstacles = new LinkedList<>();
	private LinkedList<Shot> shots = new LinkedList<>();
	private LinkedList<Extra> extras = new LinkedList<>();
	private LinkedList<Explosion> explosions = new LinkedList<>();

	// State
	private boolean pause = true;

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

	public LinkedList<Hard> getHardObstacles() {
		return hardObstacles;
	}

	public void setHardObstacles(LinkedList<Hard> hardObstacles) {
		this.hardObstacles = hardObstacles;
	}

	public LinkedList<Soft> getSoftObstacles() {
		return softObstacles;
	}

	public void setSoftObstacles(LinkedList<Soft> softObstacles) {
		this.softObstacles = softObstacles;
	}

	public LinkedList<Shot> getShots() {
		return shots;
	}

	public void setShots(LinkedList<Shot> shots) {
		this.shots = shots;
	}

	public boolean isPaused() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public LinkedList<Extra> getExtras() {
		return this.extras;
	}

	public LinkedList<Explosion> getExplosions() {
		return explosions;
	}

	public void setExplosions(LinkedList<Explosion> explosions) {
		this.explosions = explosions;
	}
}