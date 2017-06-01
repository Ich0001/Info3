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
 * Die Klasse "Pause" ist eine von "Command" abgeleitete Klasse, die "IPause"
 * implementiert.
 * 
 * @see model.Command
 * @see hsrt.mec.controldeveloper.core.com.command.IPause
 */
public class Pause extends Command implements IPause {
	// attributes
	private double duration;

	/**
	 * Standardkontruktor: Erzeugt ein neues Pause-Objekt, initialisiert mit
	 * duration = 0.
	 */
	public Pause() {
		duration = 0;
	}

	/**
	 * Konstruktor: Erzeugt ein neues Pause-Objekt, setzt duration auf den Wert
	 * des �bergabeparameters duration.
	 * 
	 * @param duration
	 *            Legt beim Erzeugen des Objektes bereits fest, wie gro�
	 *            duration ist.
	 */
	public Pause(double duration) {
		this.duration = duration;
	}

	/**
	 * Set-Methode f�r duration.
	 * 
	 * @param duration
	 *            Der Wert f�r duration wird hier gesetzt bzw. �berschrieben.
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * Get-Methode f�r duration.
	 * 
	 * @return Gibt den double-Wert der Instanzvariable duration zur�ck.
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * toString-Methode f�r das jeweilige Objekt.
	 * 
	 * @return Gibt String wie folgt zur�ck: Pause duration [duration]
	 */
	@Override
	public String toString() {
		return "Pause duration " + duration;
	}
}
