package es.unileon.prg1.blablakid;
/**
 * @version
 * @author
 *
 */
public class Week {
	private int next;
	private Day[] list;

	public Week() {
		this.next = 0;
		this.list = new Day[5];
	}

	/**
	 * @param day
	 * @return boolean
	 */
	public boolean addDay(Day day) throws BlablakidException {
		boolean add = false;
		int pos = 0;
		if(this.next == list.length) {
			throw new BlablakidException ("ERROR -- THERE IS NO SPACE FOR MORE DAYS");
		}
		else if(searchDay(day.getNum() -1) != false){
			throw new BlablakidException ("ERROR -- THAT DAY ALREDY EXISTS"+day.getDay());
		}
		else{
			pos = day.getNum()-1;
			add = true;
			list[pos] = day;
		}
		return add;
	}

	/**
	 * @param day
	 * @return boolean
	 */
	public boolean removeDay(Day day) throws BlablakidException{
		boolean remove = false;
		int pos;
		pos = day.getNum()-1;
		if(searchDay(day.getNum()-1) == false){
			throw new BlablakidException ("ERROR -- THAT DAY DOES NOT EXISTS"+day.getDay());
		}
		else{
			list[pos] = null;
			remove = true;
		}
		return remove;
	}

	/**
	 * @param name
	 * @return boolean
	 */
	public boolean searchDay(int day) {
		boolean search = false;
		int pos = day;
		if (list[pos] != null) {
			search = true;
		}
		return search;
	}
	
	public void addRide(Ride ride, int day) throws BlablakidException{
		int counter = 0;
		boolean added = false;
		while((counter < list.length) && (added == false)){
			if((list[counter].getNum() - 1) == day) {
				list[counter].add(ride);
				added = true;
			}
		counter++;
		}
	}
	
	public void removeRide(Ride ride, int day) throws BlablakidException{
		int counter = 0;
		boolean removed = false;
		while((counter < list.length) && (removed == false)){
			if(list[counter].getNum()-1 == day) {
				list[counter].remove(ride);
				removed =true;
			}
		counter++;
		}
	}
	
	public Ride searchRide(String fromWhere, String toWhere, int day) {
		int counter = 0;
		Ride element = null;
		boolean searched = false;
		while((counter < list.length)&&(searched == false)){
			if(list[counter].getNum()-1 == day) {
				element = list[counter].searchRide(fromWhere, toWhere);
				searched =true;
			}
		counter++;
		}
		return element;
	}

	public Ride getRide(String fromWhere,String toWhere,int day) {
		int counter = 0, where = 0;
		boolean searched = false;
		while((counter < list.length) && (searched != true)){
			if((list[counter].getNum()-1) == day) {
				where = list[counter].whereIsRide(fromWhere, toWhere);
				searched = true;
			}
		counter++;
		}
		return list[counter-1].getRide(where);
	}
	
	/**
	 * @return void
	 */
	@Override
	public String toString() {
		StringBuffer exit = new StringBuffer();
		for(int i = 0; i < 5; i++) {
			if(this.list[i].getRides().checkRides() > 0) {
				exit.append(this.list[i]+"\n");
			}
			exit.append(this.list[i].getRides());
		}
		return exit.toString();
	}

}
	
