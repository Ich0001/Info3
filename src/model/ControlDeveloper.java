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

import java.io.File;

//import java.util.Vector;

/**
 * Die Klasse ControlDeveloper enthält vorallem die main-Methode des Programms.
 * 
 * @author Jonathan
 */
public class ControlDeveloper {
	// attributes
	/**
	 * @param name
	 *            is a static variable that only exists once in the class
	 */
	private static String name = "Control-Developer";
	private Command[] commands = new Command[4]; // <- Frage: Warum geht das
													// nicht, ohne hier bereits
													// mind. 4 Objekte zu
													// erzeugen?

	// methods
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * exercise 1 Die ersten Schritte static erzeugt kein Objekt und lässt
		 * sich mit static getName und Attribut "String name" printen Statische
		 * Methoden und Variablen benötigen keinerlei Instanzen einer Klasse, um
		 * aufgerufen zu werden
		 * 
		 * @author Lukas Erkert
		 */

		// System.out.println(name);
		// System.out.println(getName());

		/**
		 * exercise 3 Polymorphie Objekt wird angelegt und mittels Methoden
		 * aufgerufen
		 * 
		 * @author Lukas Erkert
		 */
		// ControlDeveloper controlDeveloper1 = new ControlDeveloper();
		// controlDeveloper1.testCommands();
		// controlDeveloper1.printCommands();

		/**
		 * exercise 4 Verkettete Liste Objekt commandList wird angelegt Mittels
		 * add wird ein Array in der Klasse CommandList angelegt Dieses Array
		 * wird dann mit "remove" "moveUp" "moveDown" bearbeitet
		 * 
		 * @author Lukas Erkert
		 */
		// CommandList commandList = new CommandList();
		// commandList.add(controlDeveloper1.commands[0]);
		// commandList.add(controlDeveloper1.commands[1]);
		// commandList.add(controlDeveloper1.commands[2]);
		// commandList.add(controlDeveloper1.commands[3]);
		//
		// commandList.add(controlDeveloper1.commands[1]);
		// commandList.add(new Direction(45));
		// commandList.remove(3);
		// commandList.moveUp(-2);
		// commandList.moveDown(5);
		//
		// System.out.println();
		// for (int i = 0; i<6; i++ )
		// System.out.println(commandList.get(i));
		// commandList.moveUp(2);
		// System.out.println();
		// for (int i = 0; i<6; i++ )
		// System.out.println(commandList.get(i));
		//
		// commandList.moveDown(0);
		// commandList.remove(1);
		//
		// System.out.println();
		// for (int i = 0; i < 6; i++)
		// System.out.println(commandList.get(i));

		/**
		 * Aufgabenblatt 2
		 * 
		 */
		ControlModel controlModel = ControlModel.getInstance();
		controlModel.createCommandTypes();
		controlModel.getControlProcess().add(new Gear(5, .5));
		controlModel.getControlProcess().add(new Pause(2));
		ControlDeveloper controlDeveloper1 = new ControlDeveloper();
		controlDeveloper1.testCommands();
		controlModel.getControlProcess().add(controlDeveloper1.commands[0]);
		controlModel.getControlProcess().add(controlDeveloper1.commands[1]);
		controlModel.getControlProcess().add(controlDeveloper1.commands[2]);
		controlModel.getControlProcess().add(controlDeveloper1.commands[3]);
		controlModel.save(new File(System.getProperty("user.dir")
				+ "\\CommandList.txt")); // Befehl: Speichere meine verkettete
											// Liste ab.
		controlModel.load(new File(System.getProperty("user.dir")
				+ "\\CommandList.txt"));
	}

	//
	/**
	 * 
	 * static String getName gibt den Namen der Klasse wieder.
	 * 
	 * @return name
	 * @author Lukas Erkert
	 */
	// static String benötigt man um auf static name zuzugreifen da diese nur in
	// der Klasse sichtbar ist
	public static String getName() {
		return name;
	}

	/**
	 * Setzt den String von name, dass er aufgerufen werden kann.
	 * 
	 * @param newName
	 * @author Lukas Erkert
	 */
	public static void setName(String newName) {
		name = newName;
	}

	/**
	 * Array [3] 0-3 wird angelegt das man nicht immer nochmal schreiben muss
	 * (Für Aufgabe 3)
	 * 
	 * @author Lukas Erkert
	 */
	public void testCommands() {
		commands[0] = new Direction();
		commands[1] = new Gear();
		commands[2] = new Repetition();
		commands[3] = new Pause();
	}

	/**
	 * printCommands ruft die Klassen auf und printed von der jeweiligen Klasse
	 * das toString (Für Aufgabe 3)
	 * 
	 * @author Lukas Erkert
	 */
	public void printCommands() {
		for (Command c : commands) {
			System.out.println(c.toString());
		}
	}

}