package es.ucm.tp1.supercars.control;

import java.util.Scanner;

import es.ucm.tp1.supercars.control.commands.Command;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GamePrinter;
import es.ucm.tp1.supercars.control.exceptions.GameException;

public class Controller {
	
	private static final String PROMPT = "Command > ";
	
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
	
	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}
	
	public void run() {
		game.startTimer();
		
		while (!game.isFinished()) {
			if (refreshDisplay) {
				printGame();
			}
			
			refreshDisplay = false;
			System.out.println(PROMPT);
			String s = scanner.nextLine();
			String[] parameters = s.toLowerCase().trim().split(" ");
			System.out.println("[DEBUG] Executing: " + s);
			
			try {
				Command command = Command.getCommand(parameters);
				refreshDisplay = command.execute(game);
				
			} catch (GameException ex) {
				System.out.format(ex.getMessage() + " %n %n");
			}
			
			if (!game.getPlayerIsAlive()) {
				game.gameOver();
			}
			
			if (game.playerWon()) {
				if ((game.getCurrentTime() * 1000) < game.showRecord()) {
					game.setNewRecord(game.getCurrentTime());
				}
				game.gameOver();
			}
		}
		printEndMessage();
	}
}