package es.unileon.prg1.blablakid;
/**
 * @version 1.0
 * @author Guillermo Marcos Garcia 
 */
public class Activities {
	private int next;
	private Activity[] list;

	/**
	 * @param numMaxActivities
	 * @return void
	 */
	public Activities(int numMaxActivities){
		this.next = 0;
		this.list = new Activity[numMaxActivities];
	}
	
	private void compactSpace(){
	    int counter = 0;
		for(int i = 0; i < this.list.length; i++){
		counter = 0;
			while(counter < this.list.length-1){
				if((this.list[counter] == null) && (this.list[counter+1] != null)){
					this.list[counter] = this.list[counter + 1];
					this.list[counter+1] = null;
				}
			counter++;
			}
		}
		counter = 0;
		while((counter < list.length) && (list[counter] != null)){
			counter++;
		}
		this.next = counter;
	}

	/**
	 * @param activity
	 * @return boolean
	 */
	public void add(Activity activity) throws BlablakidException{
		if(this.next==list.length){
			throw new BlablakidException("ERROR -- THAT KID HAS NOT SPACE FOR MORE ACTIVITIES");
			
		}else if(searchActivity(activity.getName(), activity.getDay().getNum()) != null){
			throw new BlablakidException("ERROR -- THE ACTIVITY THAT YOU ARE TRYING TO ADD ALREDY EXISTS");
			
		}else{
			this.list[next]=activity;
			this.next++;
		}
	}

	/**
	 * @param activity
	 * @return boolean
	 */
	public void remove(Activity activity) throws BlablakidException{
		boolean search =false;
		int counter = 0;
		if(activity == null) {
			throw new BlablakidException("ERROR -- THE ACTIVITY INTRODUCED DOES NO EXIST");
		}
		String name = activity.getName();
		Activity element = searchActivity(name, activity.getDay().getNum()-1);
		if(element==null){
			throw new BlablakidException("ERROR -- THAT ACTIVITY IS NOT IN THE PROGRAM, ACTIVITY: " + activity.getName());
		}else{
			while((counter < this.next)&&(search == false)){
				if(list[counter] == element){
					list[counter] = null;
					search = true;
				}
			counter++;
			}
		}
		compactSpace();
	}

	/**
	 * @param name
	 * @return boolean
	 */
	public Activity searchActivity(String name, int day) {
		int counter = 0;
		Activity element = null;
		while((counter < this.next) && (element == null)){
			if(this.list[counter].isSame(name, day) == true){
				element = this.list[counter];
			}
		counter++;
		}
	return element;
	}
	
	public Activity get(int num) {
		Activity element;
		if(this.list[num-1] == null) {
			element = null;
		}else {
			element = new Activity(this.list[num-1]);
		}
		return element;
	}
	
	public int checkActivities() {
		return this.next;
	}
	
	public boolean remove(Ride ride) {
		int contador = 0;
		boolean searched = false;
		while((contador < this.next) && (searched == false)){
			searched = list[contador].remove(ride);
			contador++;
		}
	return searched;
	}
	
	public int checkRides() {
		int check = 0, counter = 0;
		while(counter < this.next){
			check = check + list[counter].checkRides();
			counter++;
		}
		return check;
	}
	
	/**
	 * @param 
	 * @return void
	 */
	@Override
	public String toString() {
		int counter = 0;
		StringBuffer exit = new StringBuffer();
		while((counter < this.next) && (list[counter] != null)) {
			exit.append(list[counter]+"\n");
			counter++;
		}
		return exit.toString();
	}
}
