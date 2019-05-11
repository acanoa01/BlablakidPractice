package es.unileon.prg1.blablakid;
/**
 * @version
 * @author
 *
 */
public class Activity {
	private String name;
	private String place;
	private Day day;
	private Rides rides;
	private Time begin;
	private Time end; 

	/**
	 * @param name
	 * @return void
	 */
	public Activity(String name, String place, int day, Time begin, Time end) throws BlablakidException{
		this.name = name;
		this.place = place;
		this.day = new Day(day+1);
		this.begin = begin;
		this.end = end;
		this.rides = new Rides(2);
	}

	/**
	 * @param another
	 * @return void
	 */
	public Activity(Activity another) {
		this.name = another.getName();
		this.place = another.getPlace();
		this.day = another.getDay();
		this.begin = another.getBegin();
		this.end = another.getEnd();
	}

	public boolean isSame(String name1, int day){
		boolean isEqual = false;
		StringBuffer name2 = new StringBuffer(this.name);
		if((name2.toString().equals(name1) == true) && ((this.getDay().getNum()-1) == day)) {
			isEqual = true;
		}
		return isEqual;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return this.place;
	}
	
	/**
	 * @return the begin
	 */
	public Time getBegin() {
		return this.begin;
	}

	/**
	 * @return the end
	 */
	public Time getEnd() {
		return this.end;
	}

	public void add(Ride ride) throws BlablakidException {
		this.rides.add(ride);
	}
	
	public Day getDay() {
		return this.day;
	}
	
	public boolean remove(Ride ride) {
		return rides.removeRideDirection(ride);
	}
	
	public int checkRides() {
		return rides.checkRides();
	}
	
	@Override
	public String toString() {
		StringBuffer exit = new StringBuffer();
		exit.append(this.name+" ("+this.place+" - "+this.day+"): "+this.begin+" > "+this.end+"\n");
			if(rides.checkRides() == 0) {
				exit.append("No ride before "+this.name+" assigned\n");
				exit.append("No ride after "+this.name+" assigned\n");
			}else if((rides.checkRides() == 1) && (rides.get(1).getEnd().isBefore(this.begin) == true)) {
				exit.append(rides.get(1)+"\n");
				exit.append("No ride after "+this.name+" assigned\n");
			}else if((rides.checkRides() == 1) && (rides.get(1).getBegin().isBefore(this.end) == false)) {
				exit.append("No ride before "+this.name+" assigned\n");
				exit.append(rides.get(1)+"\n");
			}else {
				exit.append(rides.get(1)+"\n");
				exit.append(rides.get(2)+"\n");
			}
		return exit.toString();
	}
}

