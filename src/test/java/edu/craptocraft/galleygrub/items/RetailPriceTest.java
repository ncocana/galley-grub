package edu.craptocraft.galleygrub.items;

import org.junit.Test;

import static org.junit.Assert.*;

public class RetailPriceTest {
    
    @Test
    public void testGetPriceExtra() {

        RetailPrice.init_prices();
        
        assertEquals(Double.valueOf(0.25), RetailPrice.getPrice("cheese"));
        assertEquals(Double.valueOf(0.25), RetailPrice.getPrice("medium"));
        assertEquals(Double.valueOf(0.5), RetailPrice.getPrice("large"));
        assertEquals(Double.valueOf(0.5), RetailPrice.getPrice("sauce"));

    }

    @Test
    public void testContainsKeyExtra() {

        RetailPrice.init_prices();
        
        assertTrue("This extra doesn't exist in the Map", RetailPrice.contains("cheese"));
        assertTrue("This extra doesn't exist in the Map", RetailPrice.contains("sauce"));
        assertTrue("This extra doesn't exist in the Map", RetailPrice.contains("medium"));
        assertTrue("This extra doesn't exist in the Map", RetailPrice.contains("large"));

    }

}
