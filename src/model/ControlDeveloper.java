/**
* exercise sheet: 1
* exercise      : 1, 3
* operating time: 20 min for exercise 1
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
	private Command[] commands = new Command[4];   //<- Frage: Warum geht das nicht, ohne hier bereits mind. 4 Objekte zu erzeugen?
	
	//methods
	public static void main(String[] args) {
		//exercise 1
		//System.out.println(name);
		//System.out.println(getName());
		
		//exercise 3
		ControlDeveloper controlDeveloper1 = new ControlDeveloper();
		controlDeveloper1.testCommands();
		controlDeveloper1.printCommands();
	}
	
	public static String getName(){
		return name;
	}
	public static void setName(String newName){
		name = newName;
	}
	
	public void testCommands(){
		commands[0] = new Direction();
		commands[1] = new Gear();
		commands[2] = new Repetition();
		commands[3] = new Pause();
	}
	public void printCommands(){
		for(Command c:commands){
			if(c instanceof Direction)
				System.out.println(((Direction)c).toString());
			if(c instanceof Gear)
				System.out.println(((Gear)c).toString());
			if(c instanceof Repetition)
				System.out.println(((Repetition)c).toString());
			if(c instanceof Pause)
				System.out.println(((Pause)c).toString());
		}
	}
	
}