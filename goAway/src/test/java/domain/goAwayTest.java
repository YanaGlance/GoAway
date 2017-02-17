package domain;

import org.junit.Test;

import domain.model.Country;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
//import static org.junit.Assert.assertNotEquals;

public class goAwayTest {

    @Test
    public void testMultiplication() {
	    Destination dest = Destination.Italy(125);
	    assertEquals(Destination.Italy(375), dest.times(3));
		Destination dest2 = Destination.Spain(150);
		assertEquals(Destination.Spain(450), dest2.times(3));
		Destination dest3 = Destination.Egypt(100);
		assertEquals(Destination.Egypt(300), dest3.times(3));
    }
    
    @Test
    public void TestEquality(){
        assertNotSame(Destination.Italy(2), Destination.Italy(3));
        assertNotSame(Destination.Spain(2), Destination.Spain(3));
	    assertNotSame(Destination.Egypt(2), Destination.Egypt(3));
	    assertNotSame(Destination.Italy(2), Destination.Spain(2));
	    assertNotSame(Destination.Spain(2), Destination.Egypt(2));
	}
    
    @Test
    public void testCountry(){
    	assertEquals(Country.ITA, Destination.Italy(1).country());
    	assertEquals(Country.ESP, Destination.Spain(1).country());
    	assertEquals(Country.EGY, Destination.Egypt(1).country());
    }
    
    @Test
    public void TestSaleCountry(){
    	Destination two = Destination.Italy(2);
    	Company company = new Company();
    	Destination result = company.sale(two, Country.ITA);
    	assertEquals(two, result);
    }
}

