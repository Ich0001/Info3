/**
* exercise sheet: 1
* exercise      : 2
* operating time: 12.00 - 
* annotations: 
*  * 
*
* @author Jonathan Pfrommer (Aabed Solayman)
* @version 1.0
*/

package model;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public abstract class Command implements ICommand {
	private String name;

	public String getName(){
		return name;
	}
	
	public abstract String toString();
}
