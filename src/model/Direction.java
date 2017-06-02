/**
 * exercise sheet: 1
 * exercise      : 2
 * operating time: 
 * annotations: 
 *  * 
 *
 * @author Jonathan Pfrommer (Aabed Solayman), JavaDoc-Kommentar: Jonathan Pfrommer
 * @version 1.0
 */

package model;

import hsrt.mec.controldeveloper.core.com.command.IDirection;

/**
 * Die Klasse "Direction" ist eine von "Command" abgeleitete Klasse, die
 * "IDirection" implementiert.
 * 
 * @see model.Command
 * @see hsrt.mec.controldeveloper.core.com.command.IDirection
 */
public class Direction extends Command implements IDirection {
	// attribute
	private int degree;

	/**
	 * Standardkontruktor: Erzeugt ein neues Direction-Objekt, initialisiert mit
	 * degree = 0.
	 */
	public Direction() {
		super("Direction");
		degree = 0;
	}

	/**
	 * Konstruktor: Erzeugt ein neues Direction-Objekt, setzt degree auf den
	 * Wert des �bergabeparameters degree.
	 * 
	 * @param degree
	 *            Legt beim Erzeugen des Objektes bereits fest, wie gro� degree
	 *            ist.
	 */
	public Direction(int degree) {
		super("Direction");
		this.degree = degree;
	}

	/**
	 * Set-Methode f�r degree.
	 * 
	 * @param degree
	 *            Der Wert f�r degree wird hier gesetzt bzw. �berschrieben.
	 */
	public void setDegree(int degree) {
		this.degree = degree;
	}

	/**
	 * Get-Methode f�r degree.
	 * 
	 * @return Gibt den int-Wert der Instanzvariable degree zur�ck.
	 */
	public int getDegree() {
		return degree;
	}

	/**
	 * toString-Methode f�r das jeweilige Objekt.
	 * 
	 * @return Gibt String wie folgt zur�ck: Direction degree [degree]
	 */
	@Override
	public String toString() {
		return super.getName() + " degree " + getDegree();
	}
}
