package model;

public class CommandList {
	private Element root = null;
	
/**
 * @exception 	add einen neuen Command der in einer verketteten Liste gespeichert wird
 * 				wenn erster add dann auf den Anker neues Objekt legen
 * 				Anschließend geht man die Liste solange durch bis man zu "NULL" angekommen ist und überschreibt diese mit dem Wert/String
 * @param 		c Befehl was man für die add Funktion benötigt
 * @return 		true für Bool--> das erfolgreich
 * @author 		Lukas Erkert 
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
 * @exception 	remove einen Command der aus einer verketteten Liste gelöscht wird
 * 				verschiedene Bedinungen werden abgearbeitet:
 * 				- man keine Stelle die negativ ist löschen
 * 				- wenn das erste Element gelöscht wird müssen die Zeiger so gelegt werden das der Anker auf dieses Objekt zeigt
 * 				- sonst wird die Stelle an dem gelöscht werden soll aufgerufen und die zeiger neu verlegt
 * 					--> Das voherige Element wird auf das nachfolgende Element gelegt des gelöschten Element gelegt  	
 * @param 		c an Stelle int c
 * @return 		true für Bool--> das erfolgreich
 * @author 		Lukas Erkert 
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
 * @exception 	get die Position für das Command
 * 				geht die verkettete Liste solange durch, bis Parameter pos erreicht wird
 * @param 		pos int Zahl für Position
 * @return 		element 
 * @author 		Lukas Erkert 
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
 * @exception 	moveUp die verkettete List an der Stelle x um eins nach oben verchieben
 * 				Idee dahinter das es die gleiche Mehtode aufruft wie in MoveDown nur das es das nächste Element nimmt
 * 				--> hat den Effekt das es statt das Element MoveDown, MoveUp macht
 * @param 		x	Position des Commands
 * @return 		true für Bool--> das erfolgreich
 * @author 		Lukas Erkert 
 */
	
	public boolean moveUp(int x) {

		// if(hilfsElement.getNext() == null)
		// return false;

		moveDown(x + 1);
		return true;
	}
/**
 * @exception 	moveDown: die verkettete List an der Stelle x um eins nach unten verschieben
 * 				- wenn die Position des Commands kleiner als oder gleich  null dann funktioniert das nicht weil man nicht unter der Anker verschiben kann
 * 					- das voherige voherige  Element des zu verschiebene Element zeigt auf das eigentliche Element
 * 					- das eigentliche Element zeigt auf das voherige Element
 * 					- das voherige Element zeigt auf das nächste Element
 * 				--> und anderstrum für doppelt verkette Liste
 * @param 		x Position des Commands
 * @return 		true für Bool--> das erfolgreich
 * @author 		Lukas Erkert
 */
	public boolean moveDown(int x) {
		if (root == null || x <= 0)
			return false;
		Element hilfsElement = root;
		for (int i = 0; i < x; i++) {
			hilfsElement = hilfsElement.getNext();
			if (hilfsElement == null)
				return false;
		}
		Element next = hilfsElement.getNext();
		Element prev = hilfsElement.getPrev();
		if (prev.getPrev() != null)
			prev.getPrev().setNext(hilfsElement);   // 1
		else 
			root=hilfsElement;
		hilfsElement.setNext(prev);                 // 2
		prev.setNext(next);                         // 3
		if (next != null)
			next.setPrev(prev);                     // 4
		hilfsElement.setPrev(prev.getPrev());       // 6  sonst überschreiben von prev und man kann nicht auf das Element zugreifen
		prev.setPrev(hilfsElement);                 // 5

		
		return true;
	}
}
