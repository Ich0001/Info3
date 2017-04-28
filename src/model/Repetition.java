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

import hsrt.mec.controldeveloper.core.com.command.IRepetition;

public class Repetition extends Command implements IRepetition {

	private int nrSteps;
	private int nrRepetitions;
	
	public Repetition() {
		// TODO Auto-generated constructor stub
	}
	public void setNrSteps(int nrSteps){
		this.nrSteps = nrSteps;
	}
	public int getNrSteps(){
		return nrSteps;
	}
	public void setNrRepetitions(int nrRepetitions){
		this.nrRepetitions = nrRepetitions;
	}
	public int getNrRepetitions(){
		return nrRepetitions;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
