package es.ucm.tp1.supercars.view;

import es.ucm.tp1.supercars.logic.Game;

public class GameSerializer {
	
	private Game game;
	
	public GameSerializer(Game game) {
		this.game = game;
	}
	
	@Override
	public String toString() {
		return "hola";
	}
}
