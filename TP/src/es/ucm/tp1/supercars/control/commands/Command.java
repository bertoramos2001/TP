package es.ucm.tp1.supercars.control.commands;

import java.util.Arrays;

import es.ucm.tp1.supercars.logic.Game;

public abstract class Command {

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";

	/* @formatter:off */
	protected static final Command[] AVAILABLE_COMMANDS = {
			new HelpCommand(),
			new InfoCommand(),
			new UpdateCommand(),
			new MoveUpCommand(),
			new MoveDownCommand(),
			new ExitCommand(),
			new ResetCommand(),
			new TestCommand()
	};
	/* @formatter:on */

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
	
	public static Command getCommand(String[] commandWords) {
		Command command = null;
		int i = 0;
		boolean encontrado = false;
		while(!encontrado && i < AVAILABLE_COMMANDS.length) {
			if(AVAILABLE_COMMANDS[i].parse(commandWords) != null) {
				encontrado = true;
				command = AVAILABLE_COMMANDS[i].parse(commandWords);
			}
			i++;
		}
		
		if (!encontrado) {
			System.out.println("[ERROR]: " + UNKNOWN_COMMAND_MSG);
		}
		return command;
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

	public String helpText(){
		return details +": "+ help +"\n";
	}

}
