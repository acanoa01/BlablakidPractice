package es.unileon.prg1.blablakid;
/**
 * @version 1.0
 * @author Guillermo Marcos Garcia
 *
 */
public class Kids {
	private int next;
	private Kid[] list;
	
	/**
	 * @param numMaxKids
	 * @return void
	 */
	public Kids(int numMaxKids) {
		this.next=0;
		this.list=new Kid[numMaxKids];
	}
	
	private void compactSpace(){
		int counter = 0;
		for(int i = 0; i<list.length; i++){
		counter = 0;
			while(counter < list.length-1){
				if((list[counter] == null) && (list[counter+1] != null)){
					list[counter] = list[counter + 1];
					list[counter+1] = null;
				}
			counter++;
			}
		}
		counter = 0;
		while((counter < list.length) && (list[counter] != null)){
			counter++;
		}
		next = counter;
	}

	/**
	 * @param kid
	 * @return boolean
	 */
	public void add(Kid kid) throws BlablakidException {
		if(this.next == list.length){
			throw new BlablakidException("ERROR -- THERE IS NO SPACE FOR MORE KIDS");
		}
		else if(this.searchKid(kid.getName()) != null){
			throw new BlablakidException("ERROR -- THE KID THAT YOU ARE TRYING TO ADD ALREDY EXISTS, " + kid.getName());
		}
		else{
			this.list[next]=kid;
			this.next++;
		}
	}
			
	/**
	 * @param kid
	 * @return boolean
	 */
	public void remove(Kid kid) throws BlablakidException{
		boolean search = false;
		int counter = 0;
		if(kid == null) {
			throw new BlablakidException("ERROR -- THE KID THAT YOU ARE TRYING TO REMOVE IS NOT ADDED");
		}else {
			while((counter < this.next) && (search == false)){
				if(list[counter].isSame(kid.getName()) == true){
					list[counter] = null;
					search=true;
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
	public Kid searchKid(String name) {
		int counter = 0;
		Kid element = null;
		while((counter < this.next) && (element == null)){
			if(this.list[counter].isSame(name) == true){
				element = this.list[counter];
			}
		counter++;
		}
		return element;
	}
	
	public Kid get(int num) {
		return this.list[num-1];
	}
	
	public int checkKids() {
		return this.next;
	}
	
	public int checkActivities() {
		int check = 0, counter = 0;
		while(counter < this.next){
			check = check + list[counter].checkActivities();
			counter++;
		}
		return check;
	}
	
	public boolean remove(Ride ride) {
		int counter = 0;
		boolean searched = false;
		while((counter < this.next) && (searched == false)){
			searched = list[counter].remove(ride);
			counter++;
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
	 * @return void
	 */
	@Override
	public String toString() {
		int counter = 0;
		StringBuffer exit = new StringBuffer();
		exit.append('\n'+"KIDS:"+'\n'+'\n');
		while(counter < this.next) {
			exit.append(list[counter]);
			counter++;
		}
	return exit.toString();
	}
}

