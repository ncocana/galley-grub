package edu.craptocraft.galleygrub.items;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetailPriceTest {
    
    @Before
    public void setup_initPrices() {

        RetailPrice.init_prices();
        
    }

    @Test
    public void testGetPriceExtra() {

        assertEquals(Double.valueOf(0.25), RetailPrice.getPrice("cheese"));
        assertEquals(Double.valueOf(0.25), RetailPrice.getPrice("medium"));
        assertEquals(Double.valueOf(0.5), RetailPrice.getPrice("large"));
        assertEquals(Double.valueOf(0.5), RetailPrice.getPrice("sauce"));

    }

    @Test
    public void testContainsKeyExtra() {

        assertTrue("This extra doesn't exist in the Map", RetailPrice.contains("cheese"));
        assertTrue("This extra doesn't exist in the Map", RetailPrice.contains("sauce"));
        assertTrue("This extra doesn't exist in the Map", RetailPrice.contains("medium"));
        assertTrue("This extra doesn't exist in the Map", RetailPrice.contains("large"));

    }

}
