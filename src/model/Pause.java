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

import hsrt.mec.controldeveloper.core.com.command.IPause;

public class Pause extends Command implements IPause {

	private double duration;
	
	public Pause() {
		// TODO Auto-generated constructor stub
	}
	public void setDuration(double duration){
		this.duration = duration;
	}
	public double getDuration(){
		return duration;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
