/**
* exercise sheet: 1
* exercise      : 1
* operating time: 20min
* annotations: 
*  * "static" means that the variables and methods do not exist in objects but only once in the class.
*
* @author Jonathan Pfrommer (Aabed Solayman)
* @version 1.0
*/

package model;

public class ControlDeveloper {
	//attributes
	/**
	 * @param name is a static variable that only exists once in the class*/
	private static String name = "Control-Developer";
	
	//methods
	public static void main(String[] args) {
//		ControlDeveloper controlDeveloper1 = new ControlDeveloper();
		System.out.println(name);
		System.out.println(getName());
	}
	
	public static String getName(){
		return name;
	}
	public static void setName(String newName){
		name = newName;
	}
}