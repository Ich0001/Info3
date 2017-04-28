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

	private int degree;
	
	public Direction() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDegree(int degree){
		
	}
	public int getDegree(){
		return degree;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
