package com.ganzux.test;

public class Angle {

	public static float calcAngle(int hours, int minutes) throws Exception{

	    if (hours < 1 || hours > 12){
	        throw new Exception("Hours invalid!");
	    }
	    
	    if (minutes < 0 || hours > 59){
	        throw new Exception("Minutes invalid!");
	    }

	    int hoursDegrees = 30 * hours;
	    float movementByMinutes = (minutes > 0 ? 30 / minutes: 0);
	    
	    float realHoursDegrees = hoursDegrees + movementByMinutes ;

	    // every minute are 6 degrees
	    int minutesDegrees = 6 * minutes;
	    
	    return (minutesDegrees > realHoursDegrees ? minutesDegrees - realHoursDegrees : realHoursDegrees - minutesDegrees);

	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(calcAngle(12, 00));
		
		System.out.println(calcAngle(3, 00));
		
		System.out.println(calcAngle(6, 00));
	}
}
