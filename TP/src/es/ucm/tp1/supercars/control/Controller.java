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
		//TODO: antes el primer printgame estaba aqui, ahora esta dentro del bucle
		//printGame();
		
		while (!game.isFinished()) {
			//TODO: printgame va aqui bien?
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
		    //TODO: antes teniamos aqui el printgame
//			if (refreshDisplay) {
//				printGame();
//			}
			
			if (!game.getPlayerIsAlive() || game.playerWon()) {
				game.gameOver();
			}
		}
		printEndMessage();
	}
}