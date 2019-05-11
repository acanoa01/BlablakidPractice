package es.unileon.prg1.blablakid;
/**
 * @version 1.0
 * @author Santiago Valbuena Rubio
 */
public class TextUI {

	private Blablakid blablakid;
	
	public TextUI(Blablakid blablakid) {
		this.blablakid = blablakid;
	}
	
	public void start() throws BlablakidException{
		int option;
		boolean exit = false;
		do {
			do {
				option = -1;
				System.out.println("-----------------------------");
				System.out.println("----------Blablakid----------");
				System.out.println("-----------------------------");
				System.out.println("Select an option:"); 
				System.out.println("1 - Add kid");
				System.out.println("2 - Remove kid");
				System.out.println("3 - Add parent");
				System.out.println("4 - Remove parent");
				System.out.println("5 - Add activity");
				System.out.println("6 - Remove activity");
				System.out.println("7 - Add ride");
				System.out.println("8 - Remove ride");
				System.out.println("9 - Show summary");
				System.out.println("10 - Check Status");
				System.out.println("0 - Exit");
				option = Teclado.readInteger();
			}while((option!=0)&&(option!=1)&&(option!=2)&&(option!=3)&&(option!=4)&&(option!=5)&&(option!=6)&&(option!=7)&&(option!=8)&&(option!=9)&&(option!=10));
			
			try {
				switch(option) {
				case 1:
					option1();
					System.out.println(blablakid);
				break;
				case 2:
					option2();
					System.out.println(blablakid);
				break;
				case 3:
					option3();
					System.out.println(blablakid);
				break;
				case 4:
					option4();
					System.out.println(blablakid);
				break;
				case 5:
						option5();
						System.out.println(blablakid);
				break;
				case 6:
					option6();
					System.out.println(blablakid);
				break;
				case 7:
					option7();
					System.out.println(blablakid);
				break;
				case 8:
					option8();
					System.out.println(blablakid);
				break;
				case 9:
					System.out.println(blablakid);
				break;
				case 10:
					option10();
				break;
				case 0:
					exit = true;
					System.out.println("-----------BYE BYE-----------");
				break;
				}
			}catch(BlablakidException e) {System.out.println(e.getMessage());}
		}while(exit != true);
	}
	
	public void option1() throws BlablakidException{
		System.out.println("Name of the kid to add:");
		blablakid.addKid(Teclado.readString());
	}
	
	public void option2()throws BlablakidException {
		System.out.println("Name of the kid to remove:");
		blablakid.removeKid(Teclado.readString());
	}
	
	public void option3() throws BlablakidException{
		int numSons, numMaxRides;
		System.out.println("Name of the parent to add:");
		String name = Teclado.readString();
		System.out.println("How many kids does "+name+" have? :");
		numSons = Teclado.readInteger();
		System.out.println("How many rides can "+name+" make per day?");
		numMaxRides = Teclado.readInteger();
		String[] namesSons = new String[numSons];
		for(int i = 0;i<numSons;i++) {
			if(i<9) {
				System.out.println("Who is the kid of "+name+" number 0"+(i+1)+"?");
			}else {
				System.out.println("Who is the kid of "+name+" number "+(i+1)+"?");
			}
			namesSons[i] = Teclado.readString();
		}
		blablakid.addParent(name, numSons, numMaxRides, namesSons);
	}
	
	public void option4() throws BlablakidException{
		System.out.println("Name of the parent to remove:");
		String name = Teclado.readString();
		blablakid.removeParent(name);
	}
	
	public void option5() throws BlablakidException{
		String name, place, kid;
		int day, hourBegin, minutesBegin, hourEnd, minutesEnd;
		System.out.println("Name of the activity:");
		name = Teclado.readString();
		System.out.println("Where does the activity "+name+" take place?");
		place = Teclado.readString();
		System.out.println("Day of the week for the activity:");
		System.out.println("Insert the number of the day of the week:");
		System.out.println("0 - Monday / 1 - Tuesday / 2 - Wednesday / 3 - Thrusday / 4 - Friday");
		day = Teclado.readInteger();
		System.out.println("Name of the kid taking the activity:");
		kid = Teclado.readString();
		System.out.println("When does the activity start?");
		System.out.println("Insert hour:");
		hourBegin = Teclado.readInteger();
		System.out.println("Insert minutes:");
		minutesBegin = Teclado.readInteger();
		System.out.println("When does the activity end?");
		System.out.println("Insert hour:");
		hourEnd = Teclado.readInteger();
		System.out.println("Insert minutes:");
		minutesEnd = Teclado.readInteger();
		blablakid.addActivity(name,place, day, kid, hourBegin, minutesBegin, hourEnd, minutesEnd);
	}
	
	public void option6() throws BlablakidException{
		String kid, name;
		int day;
		System.out.println("Name of the kid taking the activity:");
		kid = Teclado.readString();
		System.out.println("Name of the activity to remove:");
		name = Teclado.readString();
		System.out.println("Insert the number of the day of the week:");
		System.out.println("\"0 - Monday / 1 - Tuesday / 2 - Wednesday / 3 - Thrusday / 4 - Friday");
		day = Teclado.readInteger();
		blablakid.removeActivity(name, kid, day);
	}
	
	public void option7() throws BlablakidException{
		String activity, kid, parent, fromWhere, toWhere;
		int day, hourBegin, minutesBegin, hourEnd, minutesEnd;
		System.out.println("Name of the parent in charge of the ride:");
		parent = Teclado.readString();
		System.out.println("Name of the activity of the ride:");
		activity = Teclado.readString();
		System.out.println("Name of the kid taking the activity:");
		kid = Teclado.readString();
		System.out.println("Where does the ride start?");
		fromWhere = Teclado.readString();
		System.out.println("Where does the ride end?");
		toWhere = Teclado.readString();
		System.out.println("When does the ride start?");
		System.out.println("Insert hour:");
		hourBegin = Teclado.readInteger();
		System.out.println("Insert minutes:");
		minutesBegin = Teclado.readInteger();
		System.out.println("When does the ride end?");
		System.out.println("Insert hour:");
		hourEnd = Teclado.readInteger();
		System.out.println("Insert minutes:");
		minutesEnd = Teclado.readInteger();
		System.out.println("Day of the week for the activity:");
		System.out.println("Insert the number of the day of the week:");
		System.out.println("0 - Monday / 1 - Tuesday / 2 - Wednesday / 3 - Thrusday / 4 - Friday");
		day = Teclado.readInteger();
		blablakid.addRide(parent, activity, kid, fromWhere, toWhere, hourBegin, minutesBegin, hourEnd, minutesEnd, day);
	}
	
	public void option8() throws BlablakidException {
		int day;
		String parent, fromWhere, toWhere;
		System.out.println("Name of the parent in charge of the ride:");
		parent = Teclado.readString();
		System.out.println("Day of the week for the ride:");
		System.out.println("Insert the number of the day of the week:");
		System.out.println("0 - Monday / 1 - Tuesday / 2 - Wednesday / 3 - Thrusday / 4 - Friday");
		day = Teclado.readInteger();
		System.out.println("Where does the ride start?");
		fromWhere = Teclado.readString();
		System.out.println("Where does the ride end?");
		toWhere = Teclado.readString();
		blablakid.removeRide(parent, day, fromWhere, toWhere);
	}
	
	public void option10() {
		blablakid.checkStatus();
	}
}
