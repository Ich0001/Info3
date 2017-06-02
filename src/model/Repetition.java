/**
 * exercise sheet: 1
 * exercise      : 2
 * operating time: 12.00 - 
 * annotations: 
 *  * 
 *
 * @author Jonathan Pfrommer (Aabed Solayman)
 * @author Aabed Solayman: JavaDoc
 * @version 1.0
 */

package model;

import hsrt.mec.controldeveloper.core.com.command.IRepetition;

/**
 * Die Klasse "Repetition" ist eine von "Command" abgeleitete Klasse, die
 * "IRepetition" implementiert. Die Klasse Repetition zeigt die Zahl der Steps
 * und die Zahl der Repetitionen.
 * 
 * @see Command
 * @see IRepetition
 */
public class Repetition extends Command implements IRepetition {
	// attributes
	private int nrSteps;
	private int nrRepetitions;

	/**
	 * Repetition Standardkonstruktor: Die Attribute werden am Anfang gleich
	 * NULL eingesetzet
	 */
	public Repetition() {
		super("Repetition");
		nrSteps = 0;
		nrRepetitions = 0;
	}

	/**
	 * Konstruktor setzt nrSteps und nrRepetitions auf die übergebenen Parameter
	 * 
	 * @param nrSteps
	 *            die Zahl der Steps einsetzen
	 * @param nrRepetitions
	 *            die Zahl der Repetitionen einsetzen
	 */
	public Repetition(int nrSteps, int nrRepetitions) {
		super("Repetition");
		this.nrSteps = nrSteps;
		this.nrRepetitions = nrRepetitions;
	}

	/**
	 * set-Methode setzt nrSteps
	 * 
	 * @param nrSteps
	 *            :Verkapselung Methode
	 */
	public void setNrSteps(int nrSteps) {
		this.nrSteps = nrSteps;
	}

	/**
	 * get-Methode gibt nrSteps zurück
	 * 
	 * @see IRepetition
	 */
	@Override
	// getNrSteps() von dem Interface IRepetition
	public int getNrSteps() {
		return nrSteps;
	}

	/**
	 * set-Methode setzt nrRepetitions
	 * 
	 * @param nrRepetitions
	 *            :Verkapselung Methode
	 */
	public void setNrRepetitions(int nrRepetitions) {
		this.nrRepetitions = nrRepetitions;
	}

	/**
	 * get-Methode gibt nrRepetitions zurück
	 * 
	 * @see IRepetition
	 */
	@Override
	// getNrRepetitions() von dem Interface IRepetition
	public int getNrRepetitions() {
		return nrRepetitions;

	}

	/**
	 * toString-Methode für das jeweilige Objekt.
	 * 
	 * @return Gibt String wie folgt zurück: Repetitions nrSteps [nrSteps]
	 *         nrRepetitions [nrRepetitions]
	 */
	@Override
	// String toString() von dem abstract Methode in Command
	public String toString() {
		return super.getName() + " nrSteps " + getNrSteps() + " nrRepetitions "
				+ getNrRepetitions();
	}

}
