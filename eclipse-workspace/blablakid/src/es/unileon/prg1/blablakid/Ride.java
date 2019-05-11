package es.unileon.prg1.blablakid;
/**
 * @version
 * @author Alberto Caño Álvarez
 *
 */
public class Ride {
	private String fromWhere;
	private String toWhere;
	private Time begin;
	private Time end;

	/**
	 * constructor that generate a ride with the parameters received
	 * 
	 * @param fromWhere
	 * 				place from the ride start
	 * @param hourBegin
	 * 				start time of the ride
	 * @return void
	 */
	public  Ride(String fromWhere, String toWhere, Time begin, Time end) {
		this.fromWhere = fromWhere;
		this.toWhere = toWhere;
		this.begin = begin;
		this.end = end;
	}

	/**
	 * @param another
	 * @return void
	 */
	public  Ride(Ride another) {
		this.fromWhere = another.getFromWhere();
		this.toWhere = another.getToWhere();
		this.begin = another.getBegin();
		this.end = another.getEnd();
	}
	
	/**
	 * method that comparestwo objects and return true if both are equals
	 * @param fromWhere
	 * 				place where the ride start
	 * @param toWhere
	 * 				place where the ride ends
	 * @return isSame
	 */
	public boolean isSame(String fromWhere, String toWhere){
		boolean Same = false;
			if((fromWhere.equals(this.fromWhere)==true)&&(toWhere.equals(this.toWhere)==true)) {
				Same = true;
			}
		return Same;
	}

	/**
	 * method to obtain the place where the ride start
	 * @return fromWhere
	 */
	public String getFromWhere() {
		return this.fromWhere;
	}

	/**
	 * method to get the place where the ride ends
	 * @return toWhere
	 */
	public String getToWhere() {
		return this.toWhere;
	}

	/**
	 * method to get the hour that the ride start
	 * @return begin
	 */
	public Time getBegin() {
		return begin;
	}

	/**
	 * method to get the arrive of a ride
	 * @return  arrive
	 */
	public Time getEnd() {
		return this.end;
	}
	
	@Override
	public String toString() {
		StringBuffer exit = new StringBuffer();
		exit.append(this.fromWhere + " > " + this.toWhere + " "+this.begin + "/" + this.end );
		return exit.toString();
	}
	

}

