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

/**@exception	Interface´s werden Aufgerufen die auf diesem Weg gespeichert sind 
 * @see 		ICommand Klasse 
 * @author 		Lukas Erkert
 */
import hsrt.mec.controldeveloper.core.com.command.ICommand;

public abstract class Command implements ICommand {
	private String name;

	/**
	 * @exception getName
	 *                von String name macht nichts anderes als beim Aufruf den
	 *                Wert/String von Name zurückzugeben
	 * @return name
	 * @author Lukas Erkert
	 */
	public String getName() {
		return name;
	}

	/**
	 * @exception abstract
	 *                von Abstakten Klassen existieren keine Objekte
	 * @author Lukas Erkert
	 */
	public abstract String toString();
}
