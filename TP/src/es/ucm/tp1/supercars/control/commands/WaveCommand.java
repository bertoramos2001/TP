package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantActions.WaveAction;

public class WaveCommand extends Command implements Buyable {
	private static final String NAME = "wave";
	private static final String DETAILS = "[w]ave";
	private static final String SHORTCUT = "w";
	private static final String HELP = "do wave";
	private static final boolean PINTA_CARRETERA = true;
	private final int WAVE_COST = 5;
	
	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if (buy(game)) {
			game.execute(new WaveAction());
		} else {
			System.out.println("[ERROR]: Failed to add wave\n");
		}
		return PINTA_CARRETERA;
	}

	@Override
	public int cost() {
		return WAVE_COST;
	}
}
