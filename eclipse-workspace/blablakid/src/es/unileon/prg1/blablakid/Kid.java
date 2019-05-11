package es.unileon.prg1.blablakid;
/**
 * @version
 * @author
 *
 */
public class Kid {
	private String name;
	private Activities activities;

	/**
	 * @param name 
	 * @return void
	 */
	public Kid(String name) {
		this.name = name;
		this.activities = new Activities(3);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	public boolean isSame(String name1){
		StringBuffer name2 = new StringBuffer(this.name);
		return name2.toString().equals(name1);
	}
	
	public void add(Activity activity) throws BlablakidException {
		this.activities.add(activity);
	}
	
	
	public void removeActivity(String name, int day) throws BlablakidException {
		this.activities.remove(this.activities.searchActivity(name, day));
	}
	
	public Activity searchActivity(String name, int day) {
		Activity element = this.activities.searchActivity(name, day);
		return element;
	}
	
	public boolean checkTimeActivity(Time begin, Time end, int day) {
		boolean check = true;
		int counter = 0;
			while(activities.get(counter+1) != null) {
				if((day == (activities.get(counter+1).getDay().getNum() - 1)) && (begin.isBefore(activities.get(counter+1).getBegin()) == false) && (begin.isBefore(activities.get(counter+1).getEnd()) == true)){ 
					check = false;
				}else if((day == activities.get(counter+1).getDay().getNum() - 1) && (begin.isBefore(activities.get(counter+1).getBegin()) == true) && (end.isBefore(activities.get(counter+1).getBegin()) == false)) {
					check = false;
				}
			counter++;
			}
		return check;
	}
	
	public int checkActivities() {
		return activities.checkActivities();
	}
	
	public boolean remove(Ride ride) {
		return activities.remove(ride);
	}
	
	public int checkRides() {
		return activities.checkRides();
	}

	@Override
	public String toString() {
		StringBuffer exit = new StringBuffer();
		exit.append("******** "+this.getName()+" ********"+"\n");
		exit.append(activities);
		return exit.toString();
	}

}

