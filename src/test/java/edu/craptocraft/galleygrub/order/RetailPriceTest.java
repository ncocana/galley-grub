package edu.craptocraft.galleygrub.order;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RetailPriceTest {
    
    private Order order = null;

    @Before
    public void setup_order() {
        order = new Order();
    }

    // Test if a new item is added to the order.
    @Test
    public void test_addNewItem() {
        this.order.addItem("Krabby Patty", 1.25);
        assertEquals(1, this.order.size());
    }

    // Test if an item already addeed is added to the order.
    @Test
    public void test_addExistingItem() {
        this.order.addItem("Krabby Patty", 1.25);
        this.order.addItem("Krabby Patty", 1.25);        
        assertEquals(2, this.order.size());
    }
    
}
