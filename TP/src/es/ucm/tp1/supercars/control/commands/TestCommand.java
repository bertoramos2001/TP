package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class TestCommand extends Command {
	private static final String NAME = "test";
	private static final String DETAILS = "[t]est";
	private static final String SHORTCUT = "t";
	private static final String HELP = "enables test mode";
	private static final boolean PINTA_CARRETERA = true;

	public TestCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.toggleTest();
		return PINTA_CARRETERA;
	}
}
