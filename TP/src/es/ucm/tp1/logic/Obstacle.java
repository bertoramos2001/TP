package es.ucm.tp1.logic;

public class Obstacle {
	private int x, y;
	private Game game;
	public final static String INFO = "[Obstacle] hits car";
	private final String OBSTACLE_SYMBOL = "░";

	public Obstacle(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) 
			return true;
		
		if (obj == null) 
			return false;
		
		if (obj.getClass() != this.getClass())
			return false;
		
		Obstacle obstacle = (Obstacle) obj;
		return ((x == obstacle.x) && (y == obstacle.y));
	}
	
	@Override
	public String toString() {
		return OBSTACLE_SYMBOL;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
