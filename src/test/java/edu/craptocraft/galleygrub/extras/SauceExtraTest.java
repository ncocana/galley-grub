package edu.craptocraft.galleygrub.extras;

import org.junit.Before;
import org.junit.Test;

import edu.craptocraft.galleygrub.items.RetailPrice;
import edu.craptocraft.galleygrub.order.Comanda;
import edu.craptocraft.galleygrub.order.Order;
import edu.craptocraft.galleygrub.receipt.Receipt;

import static org.junit.Assert.assertEquals;

public class SauceExtraTest {
    
    private Receipt receipt = null;
    private Comanda order = null;
    private Extra sauce = null;
    
    @Before
    public void setup_receipt() {

        RetailPrice.init_prices();
        order = new Order();

        order.addItem("Krabby Patty", 1.25, "cheese");
        order.addItem("Coral Bits", 1.00, "medium");
        order.addItem("Kelp Rings", 1.50, "sauce");
        order.addItem("Golden Loaf", 2.00, "sauce");
        order.addItem("Seafoam Soda", 1.00, "large");

        receipt = new Receipt(order);
        sauce = new SauceExtra();
        receipt.setChain(sauce);

    }

    // Test if the sum of the sauce extra is calculated correctly.
    @Test
    public void test_sumRegular() {
        
        sauce.sumExtras(order);
        assertEquals(Double.valueOf(1.00d), order.getTotal());
        
    }
    
}
