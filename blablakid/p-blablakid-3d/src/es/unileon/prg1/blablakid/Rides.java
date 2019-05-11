package es.unileon.prg1.blablakid;

/**
 * @version 1.0
 * @author	Alberto Canyo Alvarez
 *
 */
public class Rides {
	private int next;
	private Ride[] list;
	
	/**
	 * @param numMaxRides
	 * @return void
	 */
	public Rides(int numMaxRides) {
		this.next = 0;
		this.list = new Ride[numMaxRides];
	}

	/**
	 * @param ride
	 * @return boolean
	 */
	private void compactSpace() {
		int counter = 0;
		for(int i =0; i < list.length; i++) {
		counter = 0;
			while(counter < list.length-1) {
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
		this.next = counter; 	
		}
	
	/**
	 * method that add new ride to the array
	 * @param ride
	 * @return add
	 * @throws RideException
	 */
	public void add(Ride ride) throws BlablakidException {
		if(this.next == list.length) {
			throw new BlablakidException("ERROR -- THERE IS NO SPACE FOR MORE RIDES THAT DAY");
			
		}
		else if( (searchRide (ride.getFromWhere(),ride.getToWhere())!=null) ) {
			throw new BlablakidException("ERROR -- THE RIDE THAT YOU ARE TRYING TO ADD ALREDY EXISTS");
			
		}
		else {
			this.list[next] = ride;
			this.next++;
		}
	}

	/**
	 * method that remove a ride of the array and compact the spaces
	 * @param ride
	 * @return boolean
	 */
	public void remove(Ride ride) throws BlablakidException {
		boolean searched = false;
		int counter = 0;
		if(ride == null) {
			throw new BlablakidException("ERROR -- THE RIDE YOU HAVE INTRODUCED IS NOT ADDED");
			
		}
		Ride element = searchRide(ride.getFromWhere(), ride.getToWhere());
		if(element==null) {
			throw new BlablakidException("ERROR -- THE RIDE YOU HAVE INTRODUCED IS NOT ADDED");
		}
		else {
			while( (counter<this.next) && (searched==false) ) {
				if(list[counter]==element) {
					list[counter]=null;
					searched=true;
				}
				counter++;
			}
		}
		compactSpace();
	}
	
	/**
	 * method thar look for a ride requested
	 * @param fromWhere
	 * @param toWhere
	 * @return
	 */
	public Ride searchRide(String fromWhere, String toWhere) {
		int counter = 0;
		Ride element = null;
		while( (counter < this.next) && (element == null) ) {
			if(this.list[counter].isSame(fromWhere,toWhere)==true) {
				element=this.list[counter];
			}
			counter++;
		}
		return element;
	}
	
	public Ride get(int num) {
		Ride ride = this.list[num-1];
		return ride;
	}
	
	public int checkRides() {
		return this.next;
	}
	
	public int whereIsRide(String fromWhere, String toWhere) {
		int counter= 0, result = 0;
		while(counter < this.next) {
			if(list[counter].isSame(fromWhere, toWhere) == true) {
				result = counter+1;
			}
		counter++;
		}
	return result;
	}
	
	public boolean removeRideDirection(Ride ride) {
		int contador = 0;
		boolean searched = false;
		while((contador < this.next) && (searched == false)){
			if(list[contador] == ride) {
				list[contador] = null;
				searched = true;
				compactSpace();
			}
		contador ++;
		}
	return searched;
	}
	
	/**
	 * @return void
	 */
	@Override
	public String toString() {
		int counter = 0;
		StringBuffer exit = new StringBuffer();
		while(counter < this.next){
			exit.append(list[counter]);
			counter++;
		}
	return exit.toString();
	}

}

