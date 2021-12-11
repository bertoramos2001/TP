package es.ucm.tp1.supercars.control.exceptions;

public class NumberFormatException extends CommandParseException{

	private static final long serialVersionUID = 1L;

	public NumberFormatException(String msg) {
		super(msg);
	}

}
