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

import hsrt.mec.controldeveloper.core.com.command.IGear;

public class Gear extends Command implements IGear {
	//attribute
	private int speed;
	private double duration;
	
	//constructors
	public Gear() {
		speed = 0;
		duration = 0;
	}
	public Gear(int speed, double duration) {
		this.speed = speed;
		this.duration = duration;
	}
	
	//other methods
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public int getSpeed(){
		return speed;
	}
	public void setDuration(double duration){
		this.duration = duration;
	}
	public double getDuration(){
		return duration;
	}
	public String toString() {
		String s = String.valueOf(speed);
		String p = String.valueOf(duration);
		return ("speed: "+s+"   duration: "+p);
	}
	
}
