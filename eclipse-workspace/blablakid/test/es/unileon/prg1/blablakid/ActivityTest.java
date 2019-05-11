package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ActivityTest {
	
	 
	private Activity activity1;
	private Activity another;
	private Time begin;
	private Time end;
	
	@Before
	public void setUp() throws BlablakidException{
		begin=new Time(18,00);
		end=new Time(20,00);
		activity1= new Activity("Daniel","casa",1, begin, end);
			
	}
	
	@Test
	public void testActivity() throws BlablakidException {
		
		assertEquals("daniel", activity1.getName());
		assertEquals("casa", activity1.getPlace());
		assertEquals(1, activity1.getDay());
		assertEquals(begin, activity1.getBegin());
		assertEquals(end, activity1.getEnd());
	}
	
	@Test
	public void testAnotherActivity() throws BlablakidException {
		
		another= new Activity("Beatriz","conservatorio",1, begin, end);
		assertEquals("Beatriz", another.getName());
		assertEquals("conservatorio", another.getPlace());
		assertEquals(1, another.getDay());
		assertEquals(begin, another.getBegin());
		assertEquals(end, another.getEnd());
	}
	
	@Test
	public void testIsSame() throws BlablakidException {
		
	}
	
	@Test
	public void testGetName() throws BlablakidException{
	activity1=new Activity("Manuel","casa",1, begin, end);
	assertEquals("Manuel", activity1.getName());
	}
	
	@Test
	public void testGetPlace() throws BlablakidException {
		
		activity1=new Activity("Manuel","casa",1, begin, end);
		assertEquals("casa", activity1.getPlace());	
	}
	
	@Test
	public void testGetDay() throws BlablakidException {
		
		activity1=new Activity("Manuel","casa",1, begin, end);
		assertEquals(1, activity1.getDay());	
	}
	
	@Test
	public void testGetBegin() throws BlablakidException {
		
		activity1=new Activity("Manuel","casa",1, begin, end);
		assertEquals(begin, activity1.getBegin());	
	}
	
	@Test
	public void testSetEnd() throws BlablakidException {
		
		activity1=new Activity("Manuel","casa",1, begin, end);
		assertEquals(end, activity1.getEnd());		
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	