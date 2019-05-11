package es.unileon.prg1.blablakid;
/**
 * @version 1.0
 * @author Hugo Iglesias
 */
public class Day {
	private int num;
	private String day;
	private Rides rides;

	public Day(int day) throws BlablakidException{
		this.num = day;
		if((day != 1)&&(day != 2)&&(day != 3)&&(day != 4)&&(day != 5)) {
			throw new BlablakidException("The day introduced is wrong, must be from 0-4");
		}
		if(day == 1) {
			this.day = "MONDAY";
		}
		if(day == 2) {
			this.day = "TUESDAY";
		}
		if(day == 3) {
			this.day = "WEDNESDAY";
		}
		if(day == 4) {
			this.day = "THURSDAY";
		}
		if(day == 5) {
			this.day = "FRIDAY";
		}
		this.rides = null;
	}
	
	/**
	 * @param name
	 * @param disponibility
	 * @return void
	 */
	public Day(int day, int numMaxRides)throws BlablakidException{
		this.num = day;
		if((day != 1)&&(day != 2)&&(day != 3)&&(day != 4)&&(day != 5)) {
			throw new BlablakidException("The day introduced is wrong, must be from 0-4");
		}
		if(day == 1) {
			this.day = "MONDAY";
		}
		if(day == 2) {
			this.day = "TUESDAY";
		}
		if(day == 3) {
			this.day = "WEDNESDAY";
		}
		if(day == 4) {
			this.day = "THURSDAY";
		}
		if(day == 5) {
			this.day = "FRIDAY";
		}
		this.rides = new Rides(numMaxRides);
	}

	/**
	 * @param another
	 * @return void
	 */
	public Day(Day another) {
		this.day = another.day;
		this.rides = another.rides;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return this.day;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public Rides getRides() {
		return this.rides;
	}
	
	public void add(Ride ride) throws BlablakidException {
		this.rides.add(ride);
	}
	
	public Ride searchRide(String fromWhere, String toWhere) {
		return this.rides.searchRide(fromWhere, toWhere);
	}
	
	public void remove(Ride ride) throws BlablakidException {
		rides.remove(ride);
	}
	
	public Ride getRide(int num) {
		return this.rides.get(num);
	}
	
	public int whereIsRide(String fromWhere, String toWhere) {
		return this.rides.whereIsRide(fromWhere, toWhere);
	}
	
	public String toString() {
		StringBuffer exit = new StringBuffer();
		exit.append(this.day);
		return exit.toString();
	}
}

