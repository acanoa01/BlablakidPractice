package es.unileon.prg1.blablakid;
/**
 * @version 1.0
 * @author Santiago Valbuena Rubio
 * Class that represents an hour and a minute
 */
public class Time {
	
	/**
	 * Attribute that represents an hour
	 */
	private int hour;
	
	/**
	 * Attribute that represents a minute
	 */
	private int minutes;
	
	/**
	 * Constructor of the class that create a object of type Time 
	 * @param hour
	 * 	Parameter of type int that represents the hour
	 * @param minutes
	 * 	Parameter of type int that represents the minutes
	 * @throws TimeException
	 * @exception
	 * 	If the time introduced is wrong throws a TimeException
	 */
	public Time(int hour, int minutes) throws BlablakidException{
		if(checkTime(hour,minutes)==false) {
			throw new BlablakidException("The hour or the minutes introduced are wrong , "+hour+":"+minutes);
		}
		else {
			this.hour = hour;
			this.minutes = minutes;
		}
	}
	
	/**
	 * Private method which check if the time introduced is right
	 * @param hour
	 * 	Parameter of type int that represents the hour
	 * @param minutes
	 * 	Parameter of type int that represents the minutes
	 * @return
	 * 	the method return a boolean which is true if the time is right or false if it isn't
	 */
	private boolean checkTime(int hour, int minutes) {
	boolean check = true;
		if((hour < 0) || (hour > 23) || (minutes < 0) || (minutes > 59)) {
			check = false;
		}
		else {
			check = true;
		}
	return check;
	}
	
	/**
	 * Method that returns the hour attribute
	 * @return
	 * 	Returns the hour of the object of type Time
	 */
	public int getHour() {
		return hour;
	}
	
	/**
	 * Method that set the hour of the attribute hour
	 * @param hour
	 * 	parameter with the hour to set
	 * @throws TimeException
	 * @exception
	 * 	If the hour introduced is wrong throws a TimeException
	 */
	public void setHour(int hour) throws BlablakidException {
		if(checkTime(hour,this.minutes)==false) {
			throw new BlablakidException("The hour introduced is wrong : "+hour);
		}
		else {
		this.hour = hour;
		}
	}
	
	/**
	 * Method that returns the minutes attribute
	 * @return
	 * 	Returns the minutes of the object of type Time
	 */
	public int getMinutes() {
		return minutes;
	}
	
	/**
	 * Method that set the minutes of the attribute minutes
	 * @param hour
	 * 	parameter with the minutes to set
	 * @throws TimeException
	 * @exception
	 * 	If the minutes introduced are wrong throws a TimeException
	 */
	public void setMinutes(int minutes) throws BlablakidException {
		if(checkTime(this.hour, minutes)==false) {
			throw new BlablakidException("The minute introduced is wrong : "+minutes);
		}
		else {
			this.minutes = minutes;
		}
	}
	
	//Si el time en el que se invoca es antes que el que se le pasa devuelve true
	public boolean isBefore(Time time) {
	boolean check = true;
		if(this.getHour() > time.getHour()) {
			check = false;
		} else if((this.getHour() == time.getHour()) && (this.getMinutes() > time.getMinutes())){
			check = false;
		}
		return check;
	}
	
	@Override
	public String toString() {
		StringBuffer exit = new StringBuffer();
		if(this.hour < 10) {
			exit.append("0" + this.hour);
		}
		else {
			exit.append(this.hour);
		}
		exit.append(":");
		if(this.minutes < 10) {
			exit.append("0" + this.minutes);
		}
		else {
			exit.append(this.minutes);
		}
		return exit.toString();
	}
}
