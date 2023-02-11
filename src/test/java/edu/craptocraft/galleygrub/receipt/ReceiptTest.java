package edu.craptocraft.galleygrub.receipt;

import org.junit.Before;
import org.junit.Test;

import edu.craptocraft.galleygrub.extras.CheeseExtra;
import edu.craptocraft.galleygrub.extras.Extra;
import edu.craptocraft.galleygrub.extras.Regular;
import edu.craptocraft.galleygrub.extras.SauceExtra;
import edu.craptocraft.galleygrub.extras.SizeLargeExtra;
import edu.craptocraft.galleygrub.extras.SizeMediumExtra;
import edu.craptocraft.galleygrub.items.RetailPrice;
import edu.craptocraft.galleygrub.order.Comanda;
import edu.craptocraft.galleygrub.order.Order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReceiptTest {
    
    private Receipt receipt = null;
    private Comanda order = null;
    private Extra regular = null;
    private Extra cheese = null;
    private Extra sauce = null;
    private Extra sizeMedium = null;
    private Extra sizeLarge = null;
    
    @Before
    public void setup_receipt() {

        RetailPrice.init_prices();
        order = new Order();

        order.addItem("Krabby Patty", 1.25, "cheese");
        order.addItem("Coral Bits", 1.00, "medium");
        order.addItem("Kelp Rings", 1.50, "sauce");
        order.addItem("Golden Loaf", 2.00, "sauce");
        order.addItem("Seafoam Soda", 1.00, "large");
        order.addItem("Coral Bits", 1.00, "large");

        receipt = new Receipt(order);

    }
    
    // Test if the sum without the extras is correct.
    @Test
    public void test_sumWithoutExtras() {

        regular = new Regular();
        receipt.setChain(regular);
        assertNotNull(receipt.getChain());

        Comanda savedOrder = receipt.getOrder();
        assertNotNull(savedOrder);
        assertEquals(Double.valueOf(0d), savedOrder.getTotal());

        assertEquals(Double.valueOf(7.75d), receipt.total());

    }

    // Test if the sum with only one extra is correct.
    @Test
    public void test_sumExtraCheese() {
        
        cheese = new CheeseExtra();
        receipt.setChain(cheese);
        assertNotNull(receipt.getChain());

        Comanda savedOrder = receipt.getOrder();
        assertNotNull(savedOrder);
        assertEquals(Double.valueOf(0d), savedOrder.getTotal());

        receipt.sumExtrasCharges();
        assertEquals(Double.valueOf(0.25d), savedOrder.getTotal());
        
    }

    // Test if the sum with only all the extras is correct.
    @Test
    public void test_sumAllExtras() {

        regular = new Regular();
        cheese = new CheeseExtra();
        sauce = new SauceExtra();
        sizeMedium = new SizeMediumExtra();
        sizeLarge = new SizeLargeExtra();
        
        regular.setNextExtra(cheese);
        cheese.setNextExtra(sauce);
        sauce.setNextExtra(sizeMedium);
        sizeMedium.setNextExtra(sizeLarge);

        receipt.setChain(regular);
        assertNotNull(receipt.getChain());

        Comanda savedOrder = receipt.getOrder();
        assertNotNull(savedOrder);
        assertEquals(Double.valueOf(0d), savedOrder.getTotal());

        assertEquals(Double.valueOf(10.25d), receipt.total());

        
    }
    
}
