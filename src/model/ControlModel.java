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
 * @author Jonathan
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
	 * TODO
	 * 
	 * @param file
	 * @return
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
		return true;
	}

	/**
	 * TODO
	 * 
	 * @param file
	 * @return
	 */
	public boolean save(File file) {
		// Vektor erstellen und verkettete Liste als Strings in Vektor
		// schreiben.
		Vector<String> vektor = new Vector<String>();
		if (getControlProcess().get(0) == null)
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
}
