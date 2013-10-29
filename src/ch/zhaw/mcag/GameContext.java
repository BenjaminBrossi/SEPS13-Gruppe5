package ch.zhaw.mcag;

import java.util.*;

import ch.zhaw.mcag.model.*;
import ch.zhaw.mcag.model.creature.*;
import ch.zhaw.mcag.model.obstacle.*;

public class GameContext {
	// Player
	private Player player;
	
	// Background
	private Background background;
	
	// Items
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	private List<Obstacle> hardObstacles = new LinkedList<Obstacle>();
	private List<Obstacle> softObstacles = new LinkedList<Obstacle>();
	private LinkedList<Shot> shots = new LinkedList<Shot>();
	
}
