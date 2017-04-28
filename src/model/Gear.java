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

	private int speed;
	private double duration;
	
	public Gear() {
		// TODO Auto-generated constructor stub
	}
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
