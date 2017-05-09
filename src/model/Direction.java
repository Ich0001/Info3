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
 * Die Klasse "Direction" ist eine von "Command" abgeleitete Klasse, die "IDirection" implementiert.
 * @see Command, IDirection
 */
public class Direction extends Command implements IDirection {
	//attribute
	private int degree;
	
	/**
	 * Standardkontruktor: Erzeugt ein neues Direction-Objekt, initialisiert mit degree = 0.
	 */
	public Direction() {
		degree = 0;
	}
	/**
	 * Konstruktor: Erzeugt ein neues Direction-Objekt, setzt degree auf den Wert des Übergabeparameters degree.
	 * @param degree Legt beim Erzeugen des Objektes bereits fest, wie groß degree ist.
	 */
	public Direction(int degree) {
		this.degree = degree;
	}
	
	/**
	 * Set-Methode für degree.
	 * @param degree Der Wert für degree wird hier gesetzt bzw. überschrieben.
	 */
	public void setDegree(int degree){
		this.degree = degree;
	}

	/**
	 * Get-Methode für degree.
	 * @return Gibt den int-Wert der Instanzvariable degree zurück.
	 */
	public int getDegree(){
		return degree;
	}
	
	/**
	 * toString-Methode für das jeweilige Objekt.
	 * @return Gibt String wie folgt zurück: Direction [degree=<degree>]
	 */
	@Override
	public String toString() {
		return "Direction [degree=" + degree + "]";
	}
}
