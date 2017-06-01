/**
 * exercise sheet: 2
 * exercise      : 1
 * operating time: 
 * annotations: 
 *  * 
 *
 * @author Jonathan Pfrommer, Aabed Solayman
 * @version 1.0
 */

package model;

/**
 * Diese Klasse erstellt Objekte vom Typ Command
 * (Direction/Gear/Repetition/Pause). Diese Objekte sind vom Name abhaengig
 * (setzen über setName).
 * 
 * @author Jonathan
 *
 */
public class CommandType {
	// attribut
	private String name;

	/**
	 * Standardkontruktor: Setzt auf name einen leeren String.
	 */
	public CommandType() {
		name = "";
	}

	/**
	 * Konstruktor: Setzt auf name den uebergebenen String. Der String wird
	 * zuvor auf Richtigkeit geprueft.
	 *
	 * @param name
	 *            setzt die Instanzvariable wenn sie entweder "Direction" oder
	 *            "Gear" oder "Repetition" oder "Pause" heißt. Wenn sie einen
	 *            ungueltigen Wert hat, wird die Instanzvariable wie beim
	 *            Standardkontruktor mit einem leeren String initialisiert.
	 */
	public CommandType(String name) {
		if (name.equals("Direction") || name.equals("Gear")
				|| name.equals("Repetition") || name.equals("Pause")) {
			this.name = name;
		} else
			this.name = "";

	}

	/**
	 * Set-Methode fuer name: Der String wird hier auf Richtigkeit geprueft.
	 * 
	 * @param name
	 *            Der Name wird als Instanzvariable im Objekt gespeichert.
	 * @return true wenn der eingegebene Name zulaessig ist
	 *         (Direction/Gear/Repetition/Pause)
	 * @return false wenn der eingegebene Name unzulaessig ist.
	 */
	public boolean setName(String name) {
		if (name.equals("Direction") || name.equals("Gear")
				|| name.equals("Repetition") || name.equals("Pause")) {
			this.name = name;
			return true;
		} else
			return false;
	}

	/**
	 * Get-Methode fuer name
	 * 
	 * @return Gibt den Name des Objektes als String zurueck
	 */
	public String getName() {
		return name;
	}

	/**
	 * Die Methode erstellt Objekte des Typs Command, je nach dem welcher Name
	 * in der Instanzvariablen name gespeichert ist (durch set-Methode
	 * einstellbar). Ist kein gueltiger Name gespeichert, wird als default null
	 * zurueckgegeben.
	 * 
	 * @return Das neu erstellte Objekt vom Typ Command
	 *         (Direction/Gear/Repetition/Pause) wird zurueckgegeben.
	 */
	public Command createInctance() {
		Command newCommand = null;

		switch (name) {
		case "Direction":
			newCommand = new Direction();
			break;
		case "Gear":
			newCommand = new Gear();
			break;
		case "Repetition":
			newCommand = new Repetition();
			break;
		case "Pause":
			newCommand = new Pause();
			break;
		default:
		}

		return newCommand;
	}

}
