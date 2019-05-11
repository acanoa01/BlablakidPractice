package es.unileon.prg1.blablakid;
/**
 * @version 1.0
 * @author 3D
 *
 */
public class MainBlablakid{
	public static void main(String args[]){
	int num;
	Blablakid blablakid;
	if(args.length!=1){
	System.out.println("sintaxis");
	}
	else{
		try{
		num = Integer.parseInt(args[0]);
		blablakid = new Blablakid(num);
		TextUI textUI = new TextUI(blablakid);
		textUI.start();
		}
		catch(BlablakidException e){
		System.out.println(e.getMessage());
		}
	}
   }
}
