package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class HelpCommand extends Command {

	private static final String NAME = "help";
	private static final String DETAILS = "[h]elp";
	private static final String SHORTCUT = "h";
	private static final String HELP = "show this help";
	private static final boolean PINTA_CARRETERA = false;

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:\n");
		
		for (int i = 0; i < AVAILABLE_COMMANDS.length; i++) {
			buffer.append(AVAILABLE_COMMANDS[i].helpText());
		}
		
		System.out.print(buffer.toString());

		return PINTA_CARRETERA;
	}
}
