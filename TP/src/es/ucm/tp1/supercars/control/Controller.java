package es.ucm.tp1.supercars.control;

import java.util.Scanner;

import es.ucm.tp1.supercars.control.commands.Command;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GamePrinter;

public class Controller {
	
	private static final String PROMPT = "Command > ";
	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	
	
	private Game game;
	private GamePrinter printer;
	private Scanner scanner;
	
	private boolean refreshDisplay = true;
	
	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);
	}
	
	public void printGame() {
		System.out.println(printer);
	}
	
	
	public void run() {
		while (!game.isFinished()){
			
			if (refreshDisplay) {
				printGame();
			}
			
			refreshDisplay = false;
			System.out.println(PROMPT);
			String s = scanner.nextLine();
			String[] parameters = s.toLowerCase().trim().split(" ");
			System.out.println("[DEBUG] Executing: " + s);
			Command command = Command.getCommand(parameters);
			
			if (command != null) {
				refreshDisplay = command.execute(game);
			} else {
				System.out.println("[ERROR]: "+ UNKNOWN_COMMAND_MSG);
			}
		}
	}
}
