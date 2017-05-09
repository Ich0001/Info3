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
 * Die Klasse Repetition zeigt die Zahl der Steps und die Zahl der Repetitionen.
 * 
 * @see Command (Superklasse)
 * @see IRepetition (Interface): von dem werden die Methoden getNrSteps() und
 *      int getNrRepetitions() in Klasse Repetition übergeschrieben.
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
		nrSteps = 0;
		nrRepetitions = 0;
	}

	/**
	 * 
	 * @param nrSteps
	 *            die Zahl der Steps einsetzen
	 * @param nrRepetitions
	 *            die Zahl der Repetitionen einsetzen
	 */
	public Repetition(int nrSteps, int nrRepetitions) {
		this.nrSteps = nrSteps;
		this.nrRepetitions = nrRepetitions;
	}

	/**
	 * @param nrSteps:Verkapselung
	 *            Methode
	 */
	public void setNrSteps(int nrSteps) {
		this.nrSteps = nrSteps;
	}

	/**
	 * 
	 * @see IRepetition
	 */
	@Override // getNrSteps() von dem Interface IRepetition

	public int getNrSteps() {
		return nrSteps;
	}

	/**
	 * @param nrRepetitions:Verkapselung
	 *            Methode
	 */
	public void setNrRepetitions(int nrRepetitions) {
		this.nrRepetitions = nrRepetitions;
	}

	/**
	 * 
	 * 
	 * @see IRepetition
	 */
	@Override // getNrRepetitions() von dem Interface IRepetition
	public int getNrRepetitions() {
		return nrRepetitions;

	}

	/**
	 * 
	 * @return String ( nrSteps und nrRepetitions)
	 */
	@Override // String toString() von dem abstract Methode in Command

	public String toString() {
		return "Repetition [nrSteps=" + nrSteps + ", nrRepetitions=" + nrRepetitions + "]";
	}

}
