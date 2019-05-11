package es.unileon.prg1.blablakid;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TimeTest.class,
	ParentsTest.class,
	KidsTest.class,
	ActivityTest.class,
	})//aqui dentro se anyaden las clases de tests.class

public class AllTests {

}
