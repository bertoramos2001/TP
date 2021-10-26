package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;

// TODO add your imports

public class GameObjectGenerator {

	public static void generateGameObjects(Game game, Level level) {

		for (int x = game.getVisibility() / 2; x < game.getRoadLength(); x++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.obstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.coinFrequency());
		}
	}

	public static void reset(Level level) {
		// TODO add your code
		Obstacle.reset();
		Coin.reset();
	}

	public static void generateRuntimeObjects(Game game) {
		// TODO add your code
	}
}
