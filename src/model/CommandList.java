package model;

public class CommandList {
	private Element root = null;

	//Angefangen, muss aber noch richtig gemacht werden.
	public boolean add(Command c) {
		Element newElement = new Element(c);
		if (root == null)
			root = newElement;
		else /*if(root.next == null)*/{
			Element hilfsElement = root;
			root = newElement;
			root.setNext(hilfsElement);
		}
		return true;
	}

	public boolean remove(int c) {
		return true;
	}

	public Command get(int pos) {
		Command element = root.getElement();
		return element;
	}

	public boolean moveUp(int x) {
		return true;
	}

	public boolean moveDown(int x) {
		return true;
	}
}
