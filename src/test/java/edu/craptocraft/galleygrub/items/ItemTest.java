package edu.craptocraft.galleygrub.items;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ItemTest {
    
    @Test
    public void testGetPriceExtra() {

        Product patty = new Item("Krabby Patty", 1.25);
        Product pattyRepeat = new Item("Krabby Patty", 1.00);
        
        assertTrue(patty.equals(pattyRepeat));

    }

}
