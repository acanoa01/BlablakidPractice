package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	
	Time now;
	
	@Before
	public void setUp() throws BlablakidException {
		now = new Time(17,4);
	}
	
	@Test
	public void testTime() throws BlablakidException{
	assertEquals(17, now.getHour());
	assertEquals(4, now.getMinutes());
	}
	
	@Test(expected = BlablakidException.class)
	public void testTimeNegativeHour() throws BlablakidException{
	now = new Time(-1, 13);
	}
	
	@Test(expected = BlablakidException.class)
	public void testTimeNegativeMinutes() throws BlablakidException{
	now = new Time(1, -13);
	}
	
	@Test(expected = BlablakidException.class)
	public void testTimeMinutesOutOfRange() throws BlablakidException{
	now = new Time(1, 93);
	}
	
	@Test(expected = BlablakidException.class)
	public void testTimeHourOutOfRange() throws BlablakidException{
	now = new Time(121, 13);
	}
	
	@Test(expected = BlablakidException.class)
	public void testSetHourOutOfRange() throws BlablakidException{
	now.setHour(34);
	}
	
	@Test(expected = BlablakidException.class)
	public void testSetMinutesOutOfRange() throws BlablakidException{
	now.setMinutes(84);
	}
	
	@Test(expected = BlablakidException.class)
	public void testSetHourNegative() throws BlablakidException{
	now.setHour(-4);
	}
	
	@Test(expected = BlablakidException.class)
	public void testSetMinutesNegative() throws BlablakidException{
	now.setMinutes(-12);
	}
	
	@Test
	public void testSetHour() throws BlablakidException{
	now.setHour(20);
	assertEquals(20, now.getHour());
	}
	
	@Test
	public void testSetMinutes() throws BlablakidException{
	now.setMinutes(40);
	assertEquals(40, now.getMinutes());
	}
	
	@Test
	public void testToStringMinutesLessThanTen() {
		assertEquals("17:04", now.toString());
	}
	
	@Test
	public void testToStringHourLessThanTen() throws BlablakidException{
		now = new Time(3,16);
		assertEquals("03:16", now.toString());
	}
	
	@Test
	public void testToStringHourMinutesLessThanTen() throws BlablakidException{
		now = new Time(3,6);
		assertEquals("03:06", now.toString());
	}
	
	@Test
	public void testToStringNormal() throws BlablakidException{
		now = new Time(17,34);
		assertEquals("17:34", now.toString());
	}
}
