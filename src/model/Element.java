package model;

/**
 * exercise sheet: 1
 * exercise      : 4
 * @author Jonathan Pfrommer, Lukas Erkert, Aabed Solayman
 * @author Aabed Solayman: JavaDoc
 * @version 1.0
 */
/**
 * Klasse Element ist der Kern der Verketette Liste. Mit Klasse Element werden
 * die Elemente bearbeitet. Jedes Element der Verketette Liste zeigt auf das
 * n�chste Element und auf das vorherige Element.
 * 
 * @see CommandList
 */
public class Element {

	private Element next = null;
	private Element prev = null;
	private Command element = null;

	/**
	 * Konstruktor Element
	 * 
	 * @param element
	 *            hat der Wert des Commands und wird in der Attribute element
	 *            gespeichert
	 */
	public Element(Command element) {
		this.element = element;
	}

	/**
	 * get-Methode von Element
	 * 
	 * @return element Verkapselung Methode
	 */
	public Command getElement() {
		return element;
	}

	/**
	 * Gibt das n�chste Element zur�ck
	 * 
	 * @return next das n�chste element :Verkapselung Methode
	 */

	public Element getNext() {
		return next;
	}

	/**
	 * set-Methode setzt das n�chste Element
	 * 
	 * @param next
	 *            das n�chste element einsetzen :Verkapselung Methode
	 */
	public void setNext(Element next) {
		this.next = next;
	}

	/**
	 * Gibt das vorherige Element zur�ck
	 * 
	 * @return prev das vorheriges Element :Verkapselung Methode
	 */
	public Element getPrev() {
		return prev;
	}

	/**
	 * set-Methode setzt das vorherige Element
	 * 
	 * @param prev
	 *            das vorheriges Element einsetzen :Verkapselung Methode
	 */
	public void setPrev(Element prev) {
		this.prev = prev;
	}

}
