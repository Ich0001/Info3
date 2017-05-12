package model;

/**
 * Ein Objekt der Klasse CommandList beschreibt eine verkettete Liste. Mit ihren
 * Methoden kann die verkettete Liste bearbeitet werden (hinzufügen, löschen,
 * verschieben hoch/hinunter, holen). In ihr wird der Anker der verketteten
 * Liste gespeichert.
 * 
 * @author Jonathan
 */
public class CommandList {
	private Element root = null;

	/**
	 * add: Fügt einen neuen Command ein, der in einer verketteten Liste
	 * gespeichert wird, wenn der erste add erfolgt, dann wird auf den Anker
	 * neues Objekt gelegt und anschließend geht man die Liste solange durch bis
	 * man bei "NULL" angekommen ist und überschreibt diese mit dem Command.
	 * 
	 * @see Command
	 * 
	 * @param c
	 *            Befehl was man für die add Funktion benötigt
	 * @return true für Bool--> das erfolgreich
	 * @author Lukas Erkert
	 */
	public boolean add(Command c) {
		Element newElement = new Element(c);
		if (root == null)
			root = newElement;
		else {
			Element hilfsElement = root;
			while (hilfsElement.getNext() != null) {
				hilfsElement = hilfsElement.getNext();
			}
			hilfsElement.setNext(newElement);
			hilfsElement.getNext().setPrev(hilfsElement);
		}

		return true;
	}

	/**
	 * remove: Löscht einen Command aus der verketteten Liste.
	 * 
	 * @param c
	 *            an Stelle int c
	 * @return true für Bool--> das erfolgreich
	 * @author Lukas Erkert
	 */
	public boolean remove(int c) {
		if (root == null || c < 0)
			return false;
		if (c == 0) {
			root = root.getNext();
			if (root != null)
				root.setPrev(null);
		} else {
			Element hilfsElement = root;
			for (int i = 0; i < c; i++) {
				hilfsElement = hilfsElement.getNext();
				if (hilfsElement == null)
					return false;
			}
			if (hilfsElement.getPrev() != null)
				hilfsElement.getPrev().setNext(hilfsElement.getNext());
			if (hilfsElement.getNext() != null)
				hilfsElement.getNext().setPrev(hilfsElement.getPrev());
		}
		return true;
	}

	/**
	 * get: Die Methode gibt das Command zurück, das in der vertetteten Liste an
	 * der übergebenen Stelle steht.
	 * 
	 * @param pos
	 *            int Zahl für Position
	 * @return Element
	 * @author Lukas Erkert
	 */
	public Command get(int pos) {
		if (root == null || pos < 0)
			return null;
		Element hilfsElement = root;
		for (int i = 0; i < pos; i++) {
			hilfsElement = hilfsElement.getNext();
			if (hilfsElement == null)
				return null;
		}
		Command element = hilfsElement.getElement();
		return element;
	}

	/**
	 * moveDown: Verschiebt das Element an der Stelle x aus der verketteten
	 * Liste um eins nach unten.
	 * 
	 * @param x
	 *            Position des Commands
	 * @return true wenn Tauschen erfolgreich war
	 * @return false wenn Tauschen nicht erfolgreich war
	 * @author Lukas Erkert
	 */
	public boolean moveDown(int x) {

		// if(hilfsElement.getNext() == null)
		// return false;

		if (moveUp(x + 1))
			return true;
		else
			return false;
	}

	/**
	 * moveDown: Verschiebt das Element an der Stelle x aus der verketteten
	 * Liste um eins nach oben.
	 * 
	 * @param x
	 *            Position des Commands
	 * @return true wenn Tauschen erfolgreich war
	 * @return false wenn Tauschen nicht erfolgreich war
	 * @author Lukas Erkert
	 */
	public boolean moveUp(int x) {
		if (root == null || x <= 0)
			return false; // Wenn Zahl negativ ist
		Element hilfsElement = root;
		for (int i = 0; i < x; i++) {
			hilfsElement = hilfsElement.getNext();
			if (hilfsElement == null) // letze Position
				return false;
		}
		Element next = hilfsElement.getNext();
		Element prev = hilfsElement.getPrev();
		if (prev.getPrev() != null)
			prev.getPrev().setNext(hilfsElement); // 1
		else
			root = hilfsElement;
		hilfsElement.setNext(prev); // 2
		prev.setNext(next); // 3
		if (next != null)
			next.setPrev(prev); // 4
		hilfsElement.setPrev(prev.getPrev()); // 6 sonst überschreiben von prev
												// und man kann nicht auf das
												// Element zugreifen
		prev.setPrev(hilfsElement); // 5

		return true;
	}
}
