/**
 * exercise sheet: 1
 * exercise      : 2
 * operating time: 12.00 - 13.30
 * annotations: 
 *  * 
 *
 * @author Jonathan Pfrommer (Aabed Solayman)
 * @version 1.0
 */

package model;

/**	Interfaces werden aufgerufen die auf diesem Weg gespeichert sind 
 * @see 		ICommand
 * @author 		Lukas Erkert
 */
import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * Command ist eine abrakte Klasse, von der die Klassen Direction, Gear,
 * Repetition und Pause erben. Sie beinhaltet eine abstrakte Methode toString,
 * die in den Kindklassen ausimplementiert werden müssen. Sie überschreibt die
 * toString-Methode aus Java.lang.Object.
 * 
 * @author Jonathan Pfrommer
 * 
 */
public abstract class Command implements ICommand {
	private String name;

	public Command(String name){
		this.name = name;
	}
	
	/**
	 * getName von String name macht nichts anderes als beim Aufruf den
	 * Wert/String von Name zurückzugeben
	 * 
	 * @return name
	 * @author Lukas Erkert
	 */
	public String getName() {
		return name;
	}

	/**
	 * Die abstrakte Methode String toString beschreibt den Prototyp dieser
	 * Methode. Das bedeuetet, dass erbende Klassen eine Methode toString mit
	 * Rückgabetyp String implementierten müssen.
	 * 
	 * @author Lukas Erkert
	 */
	public abstract String toString(); // abstract bedeutet von Abstakten
										// Klassen existieren keine Objekte
}
