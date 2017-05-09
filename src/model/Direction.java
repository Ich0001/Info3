/**
* exercise sheet: 1
* exercise      : 2
* operating time: 12.00 - 
* annotations: 
*  * 
*
* @author Jonathan Pfrommer (Aabed Solayman)
* @version 1.0
*/

package model;

import hsrt.mec.controldeveloper.core.com.command.IDirection;

public class Direction extends Command implements IDirection {
	//attribute
	private int degree;
	
	//constructors
	public Direction() {
		degree = 0;
	}
	public Direction(int degree) {
		this.degree = degree;
	}
	
	//other methods
	public void setDegree(int degree){
		this.degree = degree;
	}
	public int getDegree(){
		return degree;
	}
	public String toString() {
		String s = "degree: " + String.valueOf(degree);
		return s;
	}
	
	
}
