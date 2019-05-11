package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentsTest {
/**
	Parents parents;
	Parent parent1;
	Parent parent2;
	Parent parent3;
	Parent parent4;
	Parent parent5;

	@Before
	public void setUp() {
		parents = new Parents(4);
		parent1 = new Parent("Juan", 2, 3);
		parent2 = new Parent("Pedro", 1, 1);
		parent3 = new Parent("Maria", 1, 3);
		parent4 = new Parent("Sandra", 2, 2);
		parent5 = new Parent("Franciasco",2 ,3);
	}
	
	@Test(expected = ParentException.class)
	public void TestAddArrayFull() throws ParentException{
		parents.add(parent1);
		parents.add(parent2);
		parents.add(parent3);
		parents.add(parent4);
		parents.add(parent5);
	}
	
	@Test(expected = ParentException.class)
	public void TestAddExistingParent() throws ParentException{
		parent1 = new Parent("Santi", 2, 2);
		parent2 = new Parent("Santi", 3, 2);
		parents.add(parent1);
		parents.add(parent2);
	}
	
	@Test(expected = ParentException.class)
	public void TestRemoveParentNonExsisting() throws ParentException{
		parents.remove(parent1);
	}
	
	@Test
	public void TestRemoveSpaceBettwen() throws ParentException{
		parents.add(parent1);
		parents.add(parent2);
		parents.add(parent3);
		parents.remove(parent2);
		assertEquals(parent3.getName(), parents.get(2).getName());
		assertNotNull(parents.get(2));
	}
	
	@Test
	public void TestGet() throws ParentException{
		parents.add(parent1);
		assertEquals(parent1.getName(),parents.get(1).getName());
	}
	
	@Test
	public void SearchElementExists() throws ParentException{
		parents.add(parent1);
		assertEquals(parent1.getName(),parents.searchParent(parent1.getName()).getName());
	}
	
	@Test
	public void SearchElementNotExists() throws ParentException{
		assertNull(parents.searchParent(parent1.getName()));
	}
	
	
	
	*/
	
}
