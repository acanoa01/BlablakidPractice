package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidsTest {
	
	private Kids kids;
	private Kid kid1;
	private Kid kid2;
	private Kid kid3;
	private Kid kid4;
	
	
	@Before
	public void setUp() {
		
		kids=new Kids(3);
		kid1=new Kid("Daniel");
		kid2= new Kid("Manuel");
		kid3=new Kid("Beatriz");
		
	}
	
	@Test(expected=BlablakidException.class)
	public void testAddExistingKid() throws BlablakidException {
		
		kids.add(kid1);
		kids.add(kid2);
		kids.add(kid1);
	}
	@Test(expected=BlablakidException.class)
	public void testAddFull() throws BlablakidException {
		
		kid4=new Kid("Jose");
		kids.add(kid1);
		kids.add(kid2);
		kids.add(kid3);
		kids.add(kid4);	
	}
	
	@Test
	public void testAddKidNotExisting() throws BlablakidException{
		kid4=null;
		kids.add(kid4);
	}
	@Test
	public void testAddOkay() throws BlablakidException {
		
		Kid kid=new Kid("Pablo");
		
		assertNull(kids.searchKid("Jose"));
		kids.add(kid);
		assertEquals(kid,kids.searchKid("Jose"));
			
	}
	@Test(expected = BlablakidException.class)
	public void TestRemoveKidNonExisting() throws BlablakidException{
		
		kids.remove(kid4);
	}
	
	@Test
	public void TestRemoveSpaceBetween() throws BlablakidException{
		kids.add(kid1);
		kids.add(kid2);
		kids.add(kid3);
		kids.remove(kid2);
		assertEquals(kid1.getName(), kids.get(2).getName());
		assertNotNull(kids.get(1).getName());
	}
	
	
	@Test
	public void TestGet() throws BlablakidException{
		kids.add(kid1);
		assertEquals(kid1.getName(),kids.get(1).getName());
	}
	
	
	@Test
	public void SearchElementExists() throws BlablakidException{
		kids.add(kid1);
		assertEquals(kid1.getName(),kids.searchKid(kid1.getName()).getName());
	}
	
	
	@Test
	public void SearchElementNotExists(){
		assertNull(kids.searchKid(kid1.getName()));
	}
	
	@Test
	public void testCheckKids() throws BlablakidException { 
		
		kids.add(kid1);
		assertEquals(kid1,kids.checkKids());
	}
	
	@Test
	public void testCheckActivities() {
		
	}
	
	@Test
	public void testRemoveRideAdded()  {
		
	}
	
	@Test
	public void testRidesChecked() {
		
	}
	
	
	@Test
	public void testToString() throws BlablakidException{
		
		
		
	}
}