package es.ucm.tp1.supercars.view;

import es.ucm.tp1.supercars.logic.Game;

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
		s.append("EllapsedTime: " + game.getCurrentTime() + "\n");
		s.append("Game Objects: \n");
		s.append(game.serialize());
		
		return s.toString();
	}
	
private String getGameInfo() {
		
		String info = String.format("Level: %s\nCycles: %o\nCoins: %o\n",
				game.getLevel().toString(), game.getCycle(), game.getActualCoins());
		
		return info;
	}
}