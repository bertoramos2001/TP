package es.ucm.tp1.supercars.view;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class GameSerializer {

	private final String HEADING = "---- ROAD FIGHTER SERIALIZED ----\n";

	private Game game;

	public GameSerializer(Game game) {
		this.game = game;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		s.append(HEADING);
		s.append(getGameInfo());

		if (!game.testMode()) {
			s.append("EllapsedTime: " + (int) (game.getCurrentTime() * 1000) + "\n");
		}

		s.append("Game Objects: \n");

		for (int i = 0; i < game.getRoadLength(); i++) {
			for (int j = 0; j < game.getRoadWidth(); j++) {
				s.append(game.serialize(i, j));
			}
		}

		return s.toString();
	}

	private String getGameInfo() {

		String info = String.format("Level: %s\nCycles: %d\nCoins: %d\n", game.getLevel().toString(), game.getCycle(),
				game.getActualCoins());

		return info;
	}
}