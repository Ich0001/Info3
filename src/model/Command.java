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

	public Command(String name) {
		this.name = name;
	}

	/**
	 * getName von String name macht nichts anderes als beim Aufruf den
	 * Wert/String von Name zurückzugeben
	 * 
	 * @return name
	 * @author Lukas Erkert
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Die abstrakte Methode String toString beschreibt den Prototyp dieser
	 * Methode. Das bedeuetet, dass erbende Klassen eine Methode toString mit
	 * Rueckgabetyp String implementierten muessen.
	 * 
	 * @return String der aus Name des Commands und dessen Eigenschaften besteht
	 */
	@Override
	public abstract String toString(); // abstract bedeutet von Abstakten
										// Klassen existieren keine Objekte

	/**
	 * Die abstrakte Methode String propertiesToString beschreibt den Prototyp
	 * dieser Methode. Die erbenden Klassen sollen mit dieser Methode ihre
	 * Eigenschaften als String zurueckgeben.
	 * 
	 * @return String der nur aus den Eigenschaften des Commands besteht.
	 */
	public abstract String propertiesToString();
}
