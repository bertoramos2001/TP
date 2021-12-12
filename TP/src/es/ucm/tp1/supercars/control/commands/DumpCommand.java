package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class DumpCommand extends Command {
	private static final String NAME = "dump";
	private static final String DETAILS = "[d]ump <filename>";
	private static final String SHORTCUT = "d";
	private static final String HELP = "Shows the content of a saved file";
	private static final boolean PINTA_CARRETERA = false;
	private final String IO_FAIL_MSG = "An error ocurred on reading a file";
	private String filename;
	private final String VERSION = "3.0";
	private final String WELCOME_MSG = String.format("Super cars %s\n\n", VERSION);

	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 2) {
				throw new CommandParseException(String.format("[ERROR]: Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				filename = words[1];
				return this;
			}
		}
		return null;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		filename += ".txt";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			sb.append(WELCOME_MSG);
			
			while(line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = reader.readLine();
			}
			
			System.out.print(sb.toString());
			
		} catch (IOException e) {
			throw new CommandExecuteException(IO_FAIL_MSG);
		}
		return PINTA_CARRETERA;
	}

}