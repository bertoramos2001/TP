package es.ucm.tp1.supercars.control.exceptions;

public class GameException extends Exception {

	private static final long serialVersionUID = 1L;
	private String MSG;

	public GameException(String msg) {
		MSG = msg;
	}

	public String getMessage() {
		return MSG;
	}
}
