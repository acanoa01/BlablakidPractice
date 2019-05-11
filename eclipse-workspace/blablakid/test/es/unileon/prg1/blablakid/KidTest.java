package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidTest {
	
	Kid kid;
	
	@Before
	public void setUp() {
		
		kid=new Kid("Daniel");
	}
	
	@Test
	public void testKid() throws BlablakidException{
	assertEquals("Daniel", kid.getName());
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}