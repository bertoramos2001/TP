package es.ucm.tp1.supercars.logic;


public interface Collider {

	boolean doCollision();

	default boolean receiveCollision(Player player) {
		return false;
	}

}
