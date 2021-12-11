package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;

public class ResetCommand extends Command {
	private static final String NAME = "r";
	private static final String DETAILS = "[r]eset [<level> <seed>]";
	private static final String SHORTCUT = "r";
	private static final String HELP = "reset game";
	private static final boolean PINTA_CARRETERA = true;
	private static final String UNKNOWN_LEVEL_MSG = "Level must be one of: TEST, EASY, HARD, ADVANCED";
	
	private Long newSeed;
	private Level newLevel;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		newSeed = null;
		newLevel = null;
	}

	@Override
	public boolean execute(Game game) {
		if ((newLevel != null) && (newSeed != null)) {
			game.initialize(newSeed, newLevel);
		} else {
			game.initialize();
		}
		
		return PINTA_CARRETERA;
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (words.length == 3) {
			if (matchCommandName(words[0])) {
				try {
					newLevel = Level.valueOfIgnoreCase(words[1]);
					
					if (newLevel != null) {
						newSeed = Long.parseLong(words[2]);	
						return this;
					} else {
						throw new CommandParseException(String.format("[ERROR]: %s", UNKNOWN_LEVEL_MSG));
					}
				} catch (NumberFormatException e){
					throw new CommandParseException(String.format("[ERROR]: %s", "the seed is not a proper long number"));
				}
			} else {
				return null;
			}
		} else {
			return super.parse(words);
		}
	}
}