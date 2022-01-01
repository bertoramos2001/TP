package es.ucm.tp1.supercars.logic;

/* (comentarios para el examen)
 * PASOS PARA AÑADIR INSTANT ACTIONS:
 * 		1. crear la clase dentro de la carpeta de instantActions y que implemente instantAction
 * 		2. hacer override de execute con la funcionalidad de esa accion
 * 		3. desde el game llamamos al execute de la instant action, donde se ejecutara la misma y hara sus cambios en el juego
 * 		4. estas pueden ser llamadas tanto desde los comandos(shoot, wave) como los objetos(grenade) o el propio generator(thunder) entre otros
 */

public interface InstantAction {
	void execute(Game game);
}