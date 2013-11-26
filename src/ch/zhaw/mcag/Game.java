package ch.zhaw.mcag;

import ch.zhaw.mcag.model.ItemFactory;
import java.util.*;

import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.*;
import ch.zhaw.mcag.model.obstacle.*;

public class Game {
	// Config
	private Config config;

	// Player
	private Player player;
	private double points = 0;
	private int lifes = Config.getLifes();

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

        public void resetContext()
        {
            this.points = 0;
            this.lifes = Config.getLifes();
            this.enemies = new LinkedList<>();
            this.hardObstacles = new LinkedList<>();
            this.softObstacles = new LinkedList<>();
            this.shots = new LinkedList<>();
            this.extras = new LinkedList<>();
            this.explosions = new LinkedList<>();
            setPlayer(ItemFactory.createPlayer());
            Config.setGameSpeed(Config.getInitialSpeed());
        }
        
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

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		if (lifes > 0) {
			this.lifes = lifes;
		} else {
			this.lifes = 0;
			this.setPause(true);
		}
	}

	public LinkedList<Item> getEvilStuff() {
		LinkedList<Item> tmp = new LinkedList<>();
		tmp.addAll(this.getEnemies());
		tmp.addAll(this.getHardObstacles());
		tmp.addAll(this.getSoftObstacles());
		tmp.addAll(this.getEnemies());

		List<Shot> shots = (List<Shot>) this.getShots().clone();

		for (Shot shot : shots) {
			if (!shot.isGood()) {
				tmp.add(shot);
			}
		}
		return tmp;
	}

	public LinkedList<Item> getGoodStuff() {
		LinkedList<Item> tmp = new LinkedList<>();

		List<Shot> shots = (List<Shot>) this.getShots().clone();

		for (Shot shot : shots) {
			if (shot.isGood()) {
				tmp.add(shot);
			}
		}
		tmp.add(this.getPlayer());
		return tmp;
	}

	public LinkedList<Item> getAllStuff() {
		LinkedList<Item> tmp = new LinkedList<>();
		tmp.addAll(this.getEnemies());
		tmp.addAll(this.getHardObstacles());
		tmp.addAll(this.getSoftObstacles());
		tmp.addAll(this.getEnemies());
		tmp.addAll(this.getShots());
		tmp.addAll(this.getExtras());
		tmp.addAll(this.getExplosions());
		tmp.add(this.getPlayer());
		return tmp;
	}
}