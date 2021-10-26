package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class TestCommand extends Command {
	private static final String NAME = "test";
	private static final String DETAILS = "[t]est";
	private static final String SHORTCUT = "t";
	private static final String HELP = "enables test mode";

	public TestCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:");

		// TODO Add your code

		System.out.println(buffer.toString());

		return false;
	}
}
