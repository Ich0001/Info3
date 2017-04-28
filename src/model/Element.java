package model;

public class Element {
	private Element next = null;
	private Element prev = null;
	private Command element = null;

	public Element(Command element) {
		this.element = element;
	}
	
	public Command getElement() {
		return element;
	}
	
	public void setNext(Element next){
		this.next = next;
	}

}
