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
	//attributes
	private double duration;
	
	//constructors
	public Pause() {
		duration = 0;
	}
	public Pause(double duration) {
		this.duration = duration;
	}
	
	//other methods
	public void setDuration(double duration){
		this.duration = duration;
	}
	public double getDuration(){
		return duration;
	}
	@Override
	public String toString() {
		String s = "duration: " + String.valueOf(duration);
		return s;
	}

}
