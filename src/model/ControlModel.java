/**
 * exercise sheet: 2
 * exercise      : 2
 * operating time: 
 * annotations: 
 *  * 
 *
 * @author Jonathan Pfrommer, Aabed Solayman
 * @version 1.0
 */

package model;

/**
 * Zentralverwaltung
 * @author Jonathan
 *
 */
public class ControlModel {

	private CommandList controlProcess = new CommandList();
	private CommandType commandTypes[] = new CommandType[4];

	/**
	 * Diese Methode erstellt von jedem Typ von Command ein Objekt und schreibt
	 * es in ein Array.
	 */
	public void createCommandTypes() {
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}

	/**
	 * Diese Methode gibt die verkettete Liste zurück
	 * 
	 * @return Gibt die verkettete Liste zurück
	 */
	public CommandList getControlProcess() {
		return controlProcess;
	}

}
