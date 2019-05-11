package es.unileon.prg1.blablakid;
/**
 * @version 1.0
 * @author Santiago Valbuena Rubio
 *
 */
public class Blablakid {
	private Kids kids;
	private Parents parents;

	public Blablakid(int numMaxKid) {
		this.kids = new Kids(numMaxKid);
		this.parents = new Parents(numMaxKid*2);
	}

	public void addKid(String nameKid) throws BlablakidException{
		Kid kid = new Kid(nameKid);
		this.kids.add(kid);
	}
	
	public void removeKid(String name) throws BlablakidException{
		this.kids.remove(this.kids.searchKid(name));
		this.parents.removeKid(name);
	}
	
	public void addParent(String name, int numSons, int numMaxRides, String[] namesSons) throws BlablakidException{
		if(numSons <= 0) {
			throw new BlablakidException("ERROR -- THE NUMBER OF SONS MUST BE BIGGER THAN 0, NUMBER INTRODUCED : " + numSons);
		}
		else if(numSons > kids.checkKids()) {
			throw new BlablakidException("ERROR -- THE NUMBER OF SONS INTRODUCED IS BIGGER THAN THE KIDS IN THE PROGRAM, NUMBER INTRODUCED : " + numSons);
		}
		else if(numMaxRides <= 0){
			throw new BlablakidException("ERROR -- THE NUMBER OF RIDES PER DAY MUST BE BIGGER THAN 0");
		}
		else if(kidsInTheProgram(namesSons) != numSons){
			throw new BlablakidException("ERROR -- SOME KID INTRODUCED IS NOT IN THE PROGRAM");
		}
		else {
			Kids aux = new Kids(numSons);
			for(int i = 0; i < numSons; i++) {
				aux.add(kids.searchKid(namesSons[i]));
			}
			parents.add(new Parent(name, numSons, aux, numMaxRides));
		}
	}
	
	public void removeParent(String name) throws BlablakidException{
		this.parents.remove( this.parents.searchParent(name) );
	}
	
	public void addActivity(String name, String place, int day, String kid, int hourBegin, int minutesBegin, int hourEnd, int minutesEnd) throws BlablakidException{
		Time begin = new Time(hourBegin, minutesBegin);
		Time end = new Time(hourEnd, minutesEnd);
		String[] checkName = {kid};
		if(kidsInTheProgram(checkName) != 1) {
			throw new BlablakidException("ERROR -- THE KID INTRODUCED IS NOT IN THE PROGRAM: " + kid);
			
		} else if(end.isBefore(begin) == true) {
			throw new BlablakidException("ERROR -- THE END OF THE ACTIVITY IS BEFORE THE START " + begin + " > " + end);
			
		} else if(this.kids.searchKid(kid).checkTimeActivity(begin, end, day) == false){
			throw new BlablakidException("ERROR -- " + kid + " ALREDY HAVE AN ACTIVITY AT THAT TIME : " + begin + " > " + end);
			
		}else {
			Activity activity = new Activity(name, place, day, begin, end);
			kids.searchKid(kid).add(activity);
		}
	}
	
	public void removeActivity(String activity, String kid, int day) throws BlablakidException{
		String[] checkName = {kid};
		if(kidsInTheProgram(checkName) != 1) {
			throw new BlablakidException("ERROR -- THE KID INTRODUCED IS NOT IN THE PROGRAM: "+kid);
		}else {
			kids.searchKid(kid).removeActivity(activity, day);
		}
	}
	
	public void addRide(String parent, String activity, String kid, String fromWhere, String toWhere, int hourBegin, int  minutesBegin, int hourEnd, int minutesEnd, int day) throws BlablakidException {
		Time begin = new Time(hourBegin, minutesBegin);
		Time end = new Time(hourEnd, minutesEnd);
		String[] checkName = {kid};
		if(kidsInTheProgram(checkName) != 1) {
			throw new BlablakidException("ERROR -- THE KID INTRODUCED IS NOT IN THE PROGRAM : " + kid);
			
		}else if(parents.searchParent(parent) == null) {
			throw new BlablakidException("ERROR -- THE PARENT INTRODUCED IS NOT IN THE PROGRAM : " + parent);
			
		}else if(kids.searchKid(kid).searchActivity(activity, day) == null) {
			throw new BlablakidException("ERROR -- THE KID " + kid + " HAS NO THE ACTIVITY INTRODUCED: DOES NOT HAVE, " + activity + " AT THE DAY " + day);
			
		}else if(end.isBefore(begin) == true) {
			throw new BlablakidException("ERROR -- THE END OF THE ACTIVITY IS BEFORE THE START " + begin + " > " + end);
			
		}else if( (end.isBefore( kids.searchKid(kid).searchActivity(activity, day).getBegin() ) == true) && ( toWhere.equals(kids.searchKid(kid).searchActivity(activity, day).getPlace() ) == false) ) {
			throw new BlablakidException("ERROR -- THE RIDE THAT YOU WANT TO ADD FOR THE ACTIVITY "+activity+" DOES NOT END AT THE PLACE OF THE ACTIVITY");
			
		}else if( (begin.isBefore( kids.searchKid(kid).searchActivity(activity, day).getEnd() ) == false) && ( fromWhere.equals( kids.searchKid(kid).searchActivity(activity, day).getPlace() ) == false) ) {
			throw new BlablakidException("ERROR -- THE RIDE THAT YOU WANT TO ADD FOR THE ACTIVITY "+activity+" DOES NOT START AT THE PLACE OF THE ACTIVITY");
			
		}else if( (begin.isBefore( kids.searchKid(kid).searchActivity(activity, day ).getEnd() ) == true) && ( fromWhere.equals( kids.searchKid(kid).searchActivity(activity, day).getPlace() ) == true)  ) {
			throw new BlablakidException("ERROR -- THE RIDE THAT YOU WANT TO ADD FOR THE ACTIVITY "+activity+" STARTS BEFORE OF THE ACTIVITY END");
			
		}else if( (end.isBefore( kids.searchKid(kid).searchActivity(activity, day).getBegin() ) == false) && ( toWhere.equals( kids.searchKid(kid).searchActivity(activity, day).getPlace() ) == true)) {
			throw new BlablakidException("ERROR -- THE RIDE THAT YOU WANT TO ADD FOR THE ACTIVITY "+activity+" ENDS AFTER OF THE ACTIVITY START");
			
		}else {
			Ride ride = new Ride(fromWhere, toWhere, begin, end);
			parents.searchParent(parent).add(ride,day);
			Ride ride1 = parents.searchParent(parent).getRide(fromWhere, toWhere, day);
			kids.searchKid(kid).searchActivity(activity, day).add(ride1);
		}
	}
	
	public void removeRide(String parent, int day, String fromWhere, String toWhere) throws BlablakidException {
		Ride ride1 = parents.searchParent(parent).getRide(fromWhere, toWhere, day);
		kids.remove(ride1);
		parents.searchParent(parent).removeRide(fromWhere, toWhere, day);
	}

	/**
	 * @return String
	 */
	public void checkStatus() {
		System.out.println("** There is/are " + kids.checkKids() + " kid/s, added to the program.");
		System.out.println("** There is/are " + parents.checkParents() + " parent/s, added to the program.");
		if(kids.checkActivities()*2 != kids.checkRides()) {
			System.out.println("** There are activities with out rides assigned, press 9 for more info");
		}
		else {
			System.out.println("** All the activities are covered with rides");
		}
	}
	
	private int kidsInTheProgram(String[] names)  {
		int result = 0;
		for(int i = 0;i<names.length;i++) {
				if(kids.searchKid(names[i])!=null) {
					result++;
				}
		}
		return result;
	}
	
	@Override
	public String toString() {
		StringBuffer exit = new StringBuffer();
		exit.append(kids);
		exit.append(parents);
	return exit.toString();
	}

}

