package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class WaveCommand extends Command {
	private static final String NAME = "wave";
	private static final String DETAILS = "[w]ave";
	private static final String SHORTCUT = "w";
	private static final String HELP = "do wave";
	private static final boolean PINTA_CARRETERA = true;
	
	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		// TODO falta implementar funcionalidad
		return PINTA_CARRETERA;
	}
	
	
}
