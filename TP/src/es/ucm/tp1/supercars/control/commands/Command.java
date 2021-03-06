package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;

/* (comentarios para el examen)
 * PASOS PARA AÑADIR COMANDOS:
 * 		1. crear la clase dentro de commands y que herede de Command. Arreglar los errores que de inicialmente
 * 		2. hacer override de execute y parse si fuera necesario
 * 		3. añadirlo a la lista de comandos aqui abajo
 * 		4. añadirlo en el help e info
 * 
 *  para var como añadir instant actions, ver el fichero de InstantAction
 */

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
			new TestCommand(),
			new ShootCommand(),
			new GrenadeCommand(),
			new WaveCommand(),
			new SerializeCommand(),
			new SaveCommand(),
			new DumpCommand(),
			new ShowRecordCommand(),
			new ClearCommand(),
			new CheatCommand()
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

	public static Command getCommand(String[] commandWords) throws CommandParseException {
		Command command = null;
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i < AVAILABLE_COMMANDS.length) {
			if (AVAILABLE_COMMANDS[i].parse(commandWords) != null) {
				encontrado = true;
				command = AVAILABLE_COMMANDS[i].parse(commandWords);
			}
			i++;
		}

		if (!encontrado) {
			throw new CommandParseException(String.format("[ERROR]: %s", UNKNOWN_COMMAND_MSG));
		}
		return command;
	}

	public abstract boolean execute(Game game) throws CommandExecuteException;

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				throw new CommandParseException(
						String.format("[ERROR]: Command %s: %s", name, INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				return this;
			}
		}
		return null;
	}

	public String helpText() {
		return details + ": " + help + "\n";
	}

}