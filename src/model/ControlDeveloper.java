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
	 * @param 		name is a static variable that only exists once in the class*/
	private static String name = "Control-Developer";
	private Command[] commands = new Command[4];   //<- Frage: Warum geht das nicht, ohne hier bereits mind. 4 Objekte zu erzeugen?
	
	//methods
	public static void main(String[] args) {
<<<<<<< HEAD
		/**	@exception 	exercise 1  Die ersten Schritte
		 * 				static erzeugt kein Objekt und lässt sich mit static getName und Attribut "String name" printen
		 * 				Statische Methoden und Variablen benötigen keinerlei Instanzen einer Klasse, um aufgerufen zu werden
		 *  @author 	Lukas Erkert */
=======
		//exercise 1
>>>>>>> origin/master
		//System.out.println(name);
		//System.out.println(getName());
		
		/**	@exception 	exercise 3 Polymorphie
		 * 				Objekt wird angelegt und mittels Methoden aufgerufen
		 * 	@author 	Lukas Erkert */
		ControlDeveloper controlDeveloper1 = new ControlDeveloper();
		controlDeveloper1.testCommands();
		controlDeveloper1.printCommands();
<<<<<<< HEAD
		
		/**	@exception 	exercise 4 Verkettete Liste 
		 * 				Objekt commandList wird angelegt
		 * 				Mittels add wird ein Array in der Klasse CommandList angelegt 
		 * 				Dieses Array wird dann mit "remove" "moveUp" "moveDown" bearbeitet
		 * 	@author 	Lukas Erkert */
		CommandList commandList = new CommandList();
		commandList.add(controlDeveloper1.commands[0]);
		commandList.add(controlDeveloper1.commands[1]);
		commandList.add(controlDeveloper1.commands[2]);
		commandList.add(controlDeveloper1.commands[3]);
		
//		commandList.add(controlDeveloper1.commands[1]);
//		commandList.add(new Direction(45));
//		commandList.remove(3);
// 		commandList.moveUp(-2);
// 		commandList.moveDown(5);
 		
//		System.out.println();
//		for (int i = 0; i<6; i++ )
//			System.out.println(commandList.get(i));
 		
 		commandList.moveUp(2);
 		
//		System.out.println();
//		for (int i = 0; i<6; i++ )
//			System.out.println(commandList.get(i));
 		
 		
 		commandList.moveDown(2);
// 		commandList.remove(3);

		System.out.println();
		for (int i = 0; i<6; i++ )
			System.out.println(commandList.get(i));
		
=======
>>>>>>> origin/master
	}
	/**@exception 	static String benötigt man um auf static name zuzugreifen da diese nur in der Klasse sichbar ist
	 * @return 		name
	 * @author 		Lukas Erkert */
	public static String getName(){
		return name;
	}
	/**@exception 	setzt den String das er aufgerufen werden kann
	 * @param 		newName
	 * @author 		Lukas Erkert */
	public static void setName(String newName){
		name = newName;
	}
	/**@exception 	Array[3] 0-3 wird angelegt das man nicht immer nochmal schreiben muss
	 * @author 		Lukas Erkert */
	public void testCommands(){
		commands[0] = new Direction();
		commands[1] = new Gear();
		commands[2] = new Repetition();
		commands[3] = new Pause();
	}
	/**@exception 	printCommands ruft die Klassen auf und printed von der jeweiligen Klasse das toString
	 * @author 		Lukas Erkert */
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