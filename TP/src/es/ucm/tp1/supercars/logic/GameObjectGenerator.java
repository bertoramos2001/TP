package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.*;

public class GameObjectGenerator {

	public static void generateGameObjects(Game game, Level level) {

		for (int x = game.getVisibility() / 2; x < game.getRoadLength(); x++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.obstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.coinFrequency());
			
			if (level.hasAdvancedObjects()) {
				//game.tryToAddObject(new Wall(game, x, game.getRandomLane()), level.advancedObjectsFrequency());
				game.tryToAddObject(new Turbo(game, x, game.getRandomLane()), level.advancedObjectsFrequency());
				if (!SuperCoin.hasSuperCoin()) {
					game.tryToAddObject(new SuperCoin(game, x, game.getRandomLane()), level.advancedObjectsFrequency());
				}
				game.tryToAddObject(new Truck(game, x, game.getRandomLane()), level.advancedObjectsFrequency());
				game.tryToAddObject(new Pedestrian(game, x, game.getRandomLane()), level.advancedObjectsFrequency());
			}
		}
	}
	
	public static void generateRuntimeObjects(Game game) {
		//TODO: falta implementar 
//		if (game.getLevel().hasAdvancedObjects()) {
//			game.execute(new ThunderAction());
//		}
	}

	public static void reset() {
		Obstacle.reset();
		Coin.reset();
	}
}
