package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerializer;

public class SaveCommand extends Command {
	
	private static final String NAME = "save";
	private static final String DETAILS = "sa[v]e <filename>";
	private static final String SHORTCUT = "v";
	private static final String HELP = "Save the state of the game to a file.";
	private static final boolean PINTA_CARRETERA = false;
	private final String IO_FAIL_MSG = "Error with Input";
	private final String SUCCESSFUL_SAVE_MSG = "Game successfully saved to file ";
	private String filename;

	public SaveCommand() {
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
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			
			GameSerializer gameSerializer = new GameSerializer(game);
			writer.write(gameSerializer.toString());
			
			System.out.println(SUCCESSFUL_SAVE_MSG + filename);
			
		} catch (IOException e) {
			throw new CommandExecuteException(String.format("[ERROR]: %s", IO_FAIL_MSG));
		}
		return PINTA_CARRETERA;
	}

}