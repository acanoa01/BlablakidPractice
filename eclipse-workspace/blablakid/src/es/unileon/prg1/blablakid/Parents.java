package es.unileon.prg1.blablakid;
/**
 * @version 1.0
 * @author Santiago Valbuena Rubio
 */
public class Parents {
	public int next;
	public Parent[] list;
	
	/**
	 * @param numMaxParents
	 * @return void
	 */
	public Parents(int numMaxParents){
		this.next = 0;
		this.list = new Parent[numMaxParents];
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
		while((counter < list.length)&&(list[counter]!=null)){
		counter++;
		}
		this.next = counter;
	}

	/**
	 * @param parent
	 * @return boolean
	 */
	public void add(Parent parent) throws BlablakidException{
		if(this.next == list.length){
			throw new BlablakidException("ERROR -- THERE IS NO SPACE FOR MORE PARENTS");
		}
		else if(searchParent(parent.getName()) != null){
			throw new BlablakidException("ERROR -- THE KID THAT YOU ARE TRYING TO ADD ALREDY EXISTS, " + parent.getName());
		}
		else{
			this.list[next] = parent;
			this.next++;
		}
	}

	/**
	 * @param parent
	 * @return boolean
	 */
	public void remove(Parent parent) throws BlablakidException{
		boolean searched = false;
		int counter = 0;
		if(parent == null) {
			throw new BlablakidException("ERROR -- THE PARENT THAT YOU ARE TRYING TO REMOVE IS NOT ADDED");
		}
		else {
		String name = parent.getName();
		Parent element = searchParent(name);
			while((counter < this.next)&&(searched == false)){
				if(list[counter] == element){
					list[counter] = null;
					searched = true;
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
	public Parent searchParent(String name) {
		int counter = 0;
		Parent element = null;
			while((counter < this.next)&&(element == null)){
				if(this.list[counter].isSame(name) == true){
					element = this.list[counter];
				}
			counter++;
			}
	return element;
	}

	public void removeKid(String name) throws BlablakidException{
		int counter = 0;
		while(counter < this.next) {
			list[counter].removeKid(name);
			counter++;
		}
	}
	
	public int checkParents() {
		return this.next;
	}
	
	/**
	 * @return void
	 */
	@Override
	public String toString() {
		int counter = 0;
		StringBuffer exit = new StringBuffer();
		exit.append('\n'+"PARENTS:"+'\n');
		while(counter < this.next) {
			exit.append(list[counter]+"\n");
			counter++;
		}
	return exit.toString();
	}

}

