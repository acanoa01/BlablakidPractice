package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidsTest {
	
	private Kids kids;
	private Kid kid1;
	private Kid kid2;
	private Kid kid3;
	
	@Before
	public void setUp() {
		
		kids=new Kids(3);
		kid1=new Kid("Daniel");
		kid2= new Kid("Manuel");
		kid3=new Kid("Beatriz");
		
	}
	
	@Test(expected=BlablakidException.class)
	public void testAddExistingKid() throws BlablakidException {
		
		kid1=new Kid("Daniel");
		kid2=new Kid("Manuel");
		kids.add(kid1);
		kids.add(kid2);
	}
	@Test(expected=BlablakidException.class)
	public void testAddFull() throws BlablakidException {
		
		Kid kid4=new Kid("Jose");
		kids.add(kid1);
		kids.add(kid2);
		kids.add(kid3);
		kids.add(kid4);	
	}
	@Test
	public void testOkay() throws BlablakidException {
		
		Kid kid=new Kid("Pablo");
		//assertEquals(2, kids.list);
		assertNull(kids.searchKid("Jose"));
		kids.add(kid);
		assertNotNull(kids.searchKid("Jose"));
			
	}
	@Test(expected = BlablakidException.class)
	public void TestRemoveKidNonExisting() throws BlablakidException{
		kids.remove(kid1);
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
	public void SearchElementNotExists() throws BlablakidException{
		assertNull(kids.searchKid(kid1.getName()));
	}
	
	
	@Test
	public void testToStringNormal() throws BlablakidException{
		
		kid1=new Kid ("Daniel");
		assertEquals("Daniel", kid1.toString());
	}
}