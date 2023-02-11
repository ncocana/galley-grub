package edu.craptocraft.galleygrub.extras;

import org.junit.Before;
import org.junit.Test;

import edu.craptocraft.galleygrub.items.RetailPrice;
import edu.craptocraft.galleygrub.order.Comanda;
import edu.craptocraft.galleygrub.order.Order;
import edu.craptocraft.galleygrub.receipt.Receipt;

import static org.junit.Assert.assertEquals;

public class RegularTest {
    
    private Receipt receipt = null;
    private Comanda order = null;
    private Extra regular = null;
    
    @Before
    public void setup_receipt() {

        RetailPrice.init_prices();
        order = new Order();

        order.addItem("Krabby Patty", 1.25);
        order.addItem("Coral Bits", 1.00);
        order.addItem("Kelp Rings", 1.50);
        order.addItem("Golden Loaf", 2.00);
        order.addItem("Seafoam Soda", 1.00);

        receipt = new Receipt(order);
        regular = new Regular();
        receipt.setChain(regular);

    }

    // Test if the sum without extras is correct.
    @Test
    public void test_sumRegular() {
        
        regular.sumExtras(order);
        assertEquals(Double.valueOf(6.75d), order.getTotal());
        
    }
    
}
