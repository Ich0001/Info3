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

import hsrt.mec.controldeveloper.core.com.command.IPause;

/**
 * Die Klasse "Pause" ist eine von "Command" abgeleitete Klasse, die "IPause" implementiert.
 * @see Command, IPause
 */
public class Pause extends Command implements IPause {
	//attributes
	private double duration;
	
	/**
	 * Standardkontruktor: Erzeugt ein neues Pause-Objekt, initialisiert mit duration = 0.
	 */
	public Pause() {
		duration = 0;
	}
	
	/**
	 * Konstruktor: Erzeugt ein neues Pause-Objekt, setzt duration auf den Wert des Übergabeparameters duration.
	 * @param duration Legt beim Erzeugen des Objektes bereits fest, wie groß duration ist.
	 */
	public Pause(double duration) {
		this.duration = duration;
	}
	
	/**
	 * Set-Methode für duration.
	 * @param duration Der Wert für duration wird hier gesetzt bzw. überschrieben.
	 */
	public void setDuration(double duration){
		this.duration = duration;
	}
	
	/**
	 * Get-Methode für duration.
	 * @return Gibt den double-Wert der Instanzvariable duration zurück.
	 */
	public double getDuration(){
		return duration;
	}
	
	/**
	 * toString-Methode für das jeweilige Objekt.
	 * @return Gibt String wie folgt zurück: Pause [duration=<duration>]
	 */
	@Override
	public String toString() {
		return "Pause [duration=" + duration + "]";
	}
}
