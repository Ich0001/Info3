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
/**
 * @see ICommand Klasse 
 */
import hsrt.mec.controldeveloper.core.com.command.ICommand;

public abstract class Command implements ICommand {
	private String name;

	
	/**
	 * @exception getName von String name
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @exception	abstract von Abstakten Klassen existieren keine Objekte 
	 * 
	 */
	public abstract String toString();
}
