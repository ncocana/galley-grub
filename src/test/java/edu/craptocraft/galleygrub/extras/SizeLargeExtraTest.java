package edu.craptocraft.galleygrub.extras;

import org.junit.Before;
import org.junit.Test;

import edu.craptocraft.galleygrub.items.RetailPrice;
import edu.craptocraft.galleygrub.order.Comanda;
import edu.craptocraft.galleygrub.order.Order;
import edu.craptocraft.galleygrub.receipt.Receipt;

import static org.junit.Assert.assertEquals;

public class SizeLargeExtraTest {
    
    private Receipt receipt = null;
    private Comanda order = null;
    private Extra sizeLarge = null;
    
    @Before
    public void setup_receipt() {

        RetailPrice.init_prices();
        order = new Order();

        order.addItem("Krabby Patty", 1.25, "cheese");
        order.addItem("Coral Bits", 1.00, "medium");
        order.addItem("Kelp Rings", 1.50, "large");
        order.addItem("Golden Loaf", 2.00, "sauce");
        order.addItem("Seafoam Soda", 1.00, "large");

        receipt = new Receipt(order);
        sizeLarge = new SizeLargeExtra();
        receipt.setChain(sizeLarge);

    }

    // Test if the sum of the size large extra is calculated correctly.
    @Test
    public void test_sumRegular() {
        
        sizeLarge.sumExtras(order);
        assertEquals(Double.valueOf(1.00d), order.getTotal());
        
    }
    
}
