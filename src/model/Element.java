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

	public Element getNext() {
		return next;
	}

	public void setNext(Element next){
		this.next = next;
	}
	public Element getPrev() {
		return prev;
	}

	public void setPrev(Element prev) {
		this.prev = prev;
	}



}
