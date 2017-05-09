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
	//attributes
	private int nrSteps;
	private int nrRepetitions;
	
	//constructors
	public Repetition() {
		nrSteps = 0;
		nrRepetitions = 0;
	}
	public Repetition(int nrSteps, int nrRepetitions) {
		this.nrSteps = nrSteps;
		this.nrRepetitions = nrRepetitions;
	}
	
	//other methods
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
		String s = String.valueOf(nrSteps);
		String p = String.valueOf(nrRepetitions);
		return ("nrSteps: "+s+"   nrRepetitions: "+p);
	}

}
