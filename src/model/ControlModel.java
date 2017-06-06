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

//import hsrt.mec.controldeveloper.io.TextFile;

import java.io.File;
import java.util.Vector;

import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.Console;
//import hsrt.mec.controldeveloper.io.ObjectFile;
import hsrt.mec.controldeveloper.io.TextFile;

/**
 * Zentralverwaltung
 * 
 * @author Jonathan, Aabed
 *
 */
public class ControlModel {

	private CommandList controlProcess = new CommandList();
	private CommandType commandTypes[] = new CommandType[4];
	private static final ControlModel INSTANCE = new ControlModel();

	/**
	 * Standardkonstruktor (private): Zur Realisierung des Singleton-Patterns
	 * private.
	 */
	private ControlModel() {
		createCommandTypes();
	}

	/**
	 * KlassenMethode (static), um das einzige Objekt dieser Klasse (Singleton)
	 * zu bekommen.
	 * 
	 * @return Einziges Objekt / einzige Instanz dieser Klasse
	 */
	public static ControlModel getInstance() {
		return INSTANCE;
	}

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
	 * Die Methode load Laedt aus einem Dokument (Textfile) Anweisungen, die es
	 * in der verketteten Liste abspeichert.
	 * 
	 * @param file
	 *            Hier muss ein Objekt vom Typ File übergeben werden. Zum
	 *            Beispiel: new File(System.getProperty("user.dir") +
	 *            "\\CommandList.txt"). Aus dieser Datei wird geladen.
	 * @see File
	 * @return Boole'scher Wert der angibt, ob die Datei, aus der gelesen wird,
	 *         leer ist (false) oder ob das lesen geklappt hat (true).
	 */
	public boolean load(File file) {
		Vector<String> vektor = new Vector<String>();
		// Einlesen aus Textfile
		IOType ioType = new TextFile(file, true);
		ioType.read(vektor);
		ioType.close();
		if (vektor.isEmpty())
			return false;
		// Ausgeben des eingelesenen Textfiles in der Konsole
		System.out.println(vektor);

		// Speichern des eingelesenen Textfiles in der verketteten Liste
		CommandType newInstance = new CommandType("");
		for (String s : vektor) {
			// System.out.println(s); //Probeausgabe (auskommentiert)
			String[] zeile = s.split(" ");
			newInstance.setName(zeile[0]);
			Command command = newInstance.createInctance();
			if (command instanceof Direction)
				((Direction) command).setDegree(Integer.parseInt(zeile[2]));
			else if (command instanceof Gear) {
				((Gear) command).setSpeed(Integer.parseInt(zeile[2]));
				((Gear) command).setDuration(Double.parseDouble(zeile[4]));
			} else if (command instanceof Repetition) {
				((Repetition) command).setNrSteps(Integer.parseInt(zeile[2]));
				((Repetition) command).setNrRepetitions(Integer
						.parseInt(zeile[4]));
			} else if (command instanceof Pause)
				((Pause) command).setDuration(Double.parseDouble(zeile[2]));
			else
				System.out.println("Hat nicht geklappt!");

			if (command != null)
				controlProcess.add(command);
			else
				return false;
		}
		return true;
	}

	/**
	 * Die Methode save speichert Anweisungen aus der verketteten Liste in einer
	 * Textdatei ab und gibt sie ueber die Konsole aus.
	 * 
	 * @param file
	 *            Hier muss ein Objekt vom Typ File übergeben werden. Zum
	 *            Beispiel: new File(System.getProperty("user.dir") +
	 *            "\\CommandList.txt") In diese Datei wird gespeichert.
	 * @return Boole'scher Wert der angibt, ob etwas abgespeichert wurde. True
	 *         wenn etwas abgespeichert werden konnte und false wenn die
	 *         verkettete Liste leer ist.
	 */
	public boolean save(File file) {
		// Vektor erstellen und verkettete Liste als Strings in Vektor
		// schreiben.
		Vector<String> vektor = new Vector<String>();
		if (getControlProcess().get(0) == null) // Wenn verkettete Liste leer
												// ist.
			return false;
		int i = 0;
		while (getControlProcess().get(i) != null) {
			vektor.add(getControlProcess().get(i).toString());
			i++;
		}
		// Ausgabe in Textfile
		IOType ioType = new TextFile(file, false);
		ioType.write(vektor);
		ioType.close();
		// Ausgabe auf Konsole
		IOType ioType2 = new Console();
		ioType2.write(vektor);
		ioType2.close();

		System.out.println("gespeichert...");
		return true;
	}

	/**
	 * Diese Methode gibt die verkettete Liste zurück
	 * 
	 * @return Gibt die verkettete Liste zurück
	 */
	public CommandList getControlProcess() {
		return controlProcess;
	}

	public CommandType[] getCommandTypes() {
		return commandTypes;
	}
}
