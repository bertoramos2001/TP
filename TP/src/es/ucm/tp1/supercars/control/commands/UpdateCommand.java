package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class UpdateCommand extends Command {

	private static final String NAME = "none";
	private static final String DETAILS = "[n]one | []";
	private static final String SHORTCUT = "n";
	private static final String HELP = "update";
	private static final boolean PINTA_CARRETERA = true;

	public UpdateCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.movePlayerForward();
		return PINTA_CARRETERA;
	}

	@Override
	protected Command parse(String[] commandWords) {
		if ("".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = SHORTCUT;
		}
		return super.parse(commandWords);
	}
}
