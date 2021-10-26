package es.ucm.tp1.supercars.control.commands;

import java.util.Arrays;

import es.ucm.tp1.supercars.logic.Game;

public abstract class Command {

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";

	/* @formatter:off */
	private static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new UpdateCommand(),
		new MoveUpCommand(),
		new MoveDownCommand(),
		new ResetCommand(),
		new TestCommand(),
		new ExitCommand()
	};
	/* @formatter:on */

	//TODO: Esta función tenía dos parámetros; el array de string y el level, pero al llamarlo en el controller, no se usaba level (si finalmente se usara, habria que hacer import del elvel tambien)
	public static Command getCommand(String[] commandWords) {
		Command command = null;
		// TODO Add your code
		System.out.format("[ERROR]: %s%n%n", UNKNOWN_COMMAND_MSG);
		return command;
	}

	private final String name;
	private final String shortcut;
	private final String details;
	private final String help;

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game);

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s%n%n", name, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				return this;
			}
		}
		return null;
	}

	// TODO Add your code

}
