package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;
import es.ucm.tp1.supercars.logic.Game;

public class ShowRecordCommand extends Command {
	private static final String NAME = "record";
	private static final String DETAILS = "rec[o]rd";
	private static final String SHORTCUT = "o";
	private static final String HELP = "show level record";
	private static final boolean PINTA_CARRETERA = false;
	private final String RECORD_NAME = "record.txt";
	private final String FAIL_RECORD_MSG = "Failed to open record file";
	private final String FAIL_CURRENT_RECORD_MSG = "Record in milliseconds must be a double";

	public ShowRecordCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try (BufferedReader reader = new BufferedReader(new FileReader(RECORD_NAME))) {
			String line = reader.readLine();
			String levelName = game.getLevel().name();
			boolean found = false;
			double currentRecordInMs;

			while (line != null && !found) {
				String[] parts = line.split(":");

				if (parts[0].equalsIgnoreCase(levelName)) {
					found = true;
					currentRecordInMs = Double.parseDouble(parts[1]);
					System.out.println(levelName + " record is "
							+ String.format(Locale.FRANCE, "%.2f s", (currentRecordInMs / 1000)));
				}
				line = reader.readLine();
			}

			if (!found) {
				System.out.println("There is still no record saved for level " + levelName);
			}

		} catch (IOException e) {
			throw new InputOutputRecordException(String.format("[ERROR]: %s", FAIL_RECORD_MSG));
		} catch (NumberFormatException e) {
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAIL_CURRENT_RECORD_MSG));
		}
		return PINTA_CARRETERA;
	}

}