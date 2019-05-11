package es.unileon.prg1.blablakid;
/**
 * @version 1.0
 * @author Santiago Valbuena Rubio
 *
 */
public class Parent {
	private String name;
	private Kids sons;
	private Week week;
	private int numSons;

	public Parent(String name, int numSons, Kids aux, int numMaxRides) throws BlablakidException{
		this.name = name;
		this.sons = new Kids(numSons);
		this.numSons = numSons;
		for(int i = 0; i < numSons; i++) {
			sons.add(aux.get(i+1));
		}
		week = new Week();
		
		Day mon = new Day(1, numMaxRides);
		week.addDay(mon);
		Day tue = new Day(2, numMaxRides);
		week.addDay(tue);
		Day wed = new Day(3, numMaxRides);
		week.addDay(wed);
		Day thr = new Day(4, numMaxRides);
		week.addDay(thr);
		Day fri = new Day(5, numMaxRides);
		week.addDay(fri);
	}

	public boolean isSame(String name1){
		StringBuffer name2 = new StringBuffer(this.name);
		return name2.toString().equals(name1);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	public void removeKid(String name) throws BlablakidException {
		if(sons.searchKid(name) != null) {
			sons.remove(sons.searchKid(name));
		}
	}
	
	public void add(Ride ride, int day)throws BlablakidException {
		week.addRide(ride,day);
	}
	
	public void removeRide(String fromWhere, String toWhere, int day)throws BlablakidException {
		week.removeRide(searchRide(fromWhere, toWhere, day), day);
	}
	
	public Ride searchRide(String fromWhere, String toWhere, int day) {
		Ride element = this.week.searchRide(fromWhere, toWhere, day);
		return element;
	}
	
	public Ride getRide(String fromWhere,String toWhere,int day) {
		return week.getRide(fromWhere, toWhere, day);
	}

	@Override
	public String toString() {
		int counter = 0;
		StringBuffer exit = new StringBuffer();
		exit.append("\n######## " + this.getName() + " ########\n\n");
		exit.append("Kids:\n");
		while((counter < numSons) && (sons.get(counter+1) != null)){
			exit.append(" - " + sons.get(counter+1).getName()+'\n');
			counter++;
		}
		exit.append("Rides:\n");
		exit.append(week);
		return exit.toString();
	}
	
}

