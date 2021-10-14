package es.ucm.tp1.logic;

public class ObstacleList {
	private Obstacle obstacles[];
	private static int numObstacles;

	public ObstacleList(int arrLength) {
		obstacles = new Obstacle[arrLength];
		numObstacles = 0;
	}
	
	public void add(Obstacle obs) {
		obstacles[numObstacles] = obs;
		numObstacles += 1;
	}
	
	public void remove(Obstacle obs) {
		 Obstacle aux[] = new Obstacle[obstacles.length];
		 int i = 0;
		 for (Obstacle actualCoin : obstacles) {
			 if ( actualCoin != obs) {
				 aux[i] = actualCoin;
				 i += 1;
			 }
		 }
		 obstacles = aux;
		 numObstacles = i;
	}
	
	public Obstacle getObstacleInPosition(int x, int y) {
		for (int i = 0; i < numObstacles; i++) {
			if (obstacles[i].getX() == x && obstacles[i].getY() == y) {
				return obstacles[i];
			}
		}
		return null;
	}
	
	public int getTotalObstacles() {
		return numObstacles;
	}
}
