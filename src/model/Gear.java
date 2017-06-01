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

import hsrt.mec.controldeveloper.core.com.command.IGear;

/**
 * Die Klasse "Gear" ist eine von "Command" abgeleitete Klasse, die "IGear"
 * implementiert.
 * 
 * @see Command
 * @see IGear
 */
public class Gear extends Command implements IGear {
	// attribute
	private int speed;
	private double duration;

	/**
	 * Standardkontruktor: Erzeugt ein neues Gear-Objekt, initialisiert mit
	 * speed = 0 und duration = 0.
	 */
	public Gear() {
		speed = 0;
		duration = 0;
	}

	/**
	 * Konstruktor: Erzeugt ein neues Gear-Objekt, setzt speed und duration auf
	 * den Wert des jeweiligen �bergabeparameters.
	 * 
	 * @param speed
	 *            Legt beim Erzeugen des Objektes bereits fest, wie gro� speed
	 *            ist.
	 * @param duration
	 *            Legt beim Erzeugen des Objektes bereits fest, wie gro�
	 *            duration ist.
	 */
	public Gear(int speed, double duration) {
		this.speed = speed;
		this.duration = duration;
	}

	/**
	 * Set-Methode f�r speed.
	 * 
	 * @param speed
	 *            Der Wert f�r speed wird hier gesetzt bzw. �berschrieben.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Get-Methode f�r speed.
	 * 
	 * @return Gibt den int-Wert der Instanzvariable speed zur�ck.
	 */
	public int getSpeed() {
		return speed;
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
	 * @return Gibt String wie folgt zur�ck: Gear speed [speed] duration
	 *         [duration]
	 */
	@Override
	public String toString() {
		return "Gear speed " + speed + " duration " + duration;
	}
}
