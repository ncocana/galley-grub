package edu.craptocraft.galleygrub.items;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemFactoryTest {
    
    @Before
    public void setup_initPrices() {

        ItemFactory.clear();
        assertEquals(0, ItemFactory.size());
        RetailPrice.init_prices();
        
    }

    // Test if different items are created and added.
    @Test
    public void test_GetDifferentItems() {

        Item kpatty = ItemFactory.getItem("Krabby Patty", 1.25);
        assertNotNull(kpatty);

        assertEquals("Krabby Patty....1,25$", kpatty.toString());
        assertEquals(1, ItemFactory.size());

        Item coral = ItemFactory.getItem("Coral Bits", 1.00);
        assertNotNull(coral);

        assertEquals("Coral Bits....1,00$", coral.toString());
        assertNotSame(kpatty,coral);

        assertEquals(2, ItemFactory.size()); 

    }

    // Test if an item similar to one already created isn't added.
    @Test
    public void test_GetSameItems() {

        Item kpatty = ItemFactory.getItem("Krabby Patty", 1.25);
        assertNotNull(kpatty);

        assertEquals("Krabby Patty....1,25$", kpatty.toString());
        assertEquals(1, ItemFactory.size());

        Item kpattyRepeat = ItemFactory.getItem("Krabby Patty", 1.25);
        assertNotNull(kpattyRepeat);

        assertEquals("Krabby Patty....1,25$", kpattyRepeat.toString());
        assertEquals(kpatty,kpattyRepeat);

        assertEquals(1, ItemFactory.size()); 

    }

    // Test if different items with extras are created and added.
    @Test
    public void test_GetDifferentItemsWithExtra() {

        Item item = ItemFactory.getItem("Krabby Patty", 1.25, "cheese");
        assertNotNull(item);

        assertEquals("Krabby Patty w/ cheese....1,25$ + 0,25$", item.toString());
        assertEquals(1, ItemFactory.size());

        Item itemTwo = ItemFactory.getItem("Coral Bits", 1.00, "medium");
        assertNotNull(itemTwo);

        assertEquals("Coral Bits w/ medium....1,00$ + 0,25$", itemTwo.toString());
        assertNotEquals(item,itemTwo);

        assertEquals(2, ItemFactory.size()); 

    }

    // Test if an item with an extra similar to one already created isn't added.
    @Test
    public void test_GetSameItemsWithExtra() {

        Item item = ItemFactory.getItem("Krabby Patty", 1.25, "cheese");
        assertNotNull(item);

        assertEquals("Krabby Patty w/ cheese....1,25$ + 0,25$", item.toString());
        assertEquals(1, ItemFactory.size());

        Item itemTwo = ItemFactory.getItem("Krabby Patty", 1.25, "cheese");
        assertNotNull(itemTwo);

        assertEquals("Krabby Patty w/ cheese....1,25$ + 0,25$", itemTwo.toString());
        assertEquals(item,itemTwo);

        assertEquals(1, ItemFactory.size()); 

    }

    // Test if an item similar in name but with and without an extra it's created and added.
    @Test
    public void test_GetBothItemsRegularExtra() {

        Item item = ItemFactory.getItem("Krabby Patty", 1.25, "cheese");
        assertNotNull(item);

        assertEquals("Krabby Patty w/ cheese....1,25$ + 0,25$", item.toString());
        assertEquals(1, ItemFactory.size());

        Item itemTwo = ItemFactory.getItem("Krabby Patty", 1.25);
        assertNotNull(itemTwo);

        assertEquals("Krabby Patty....1,25$", itemTwo.toString());
        assertNotEquals(item,itemTwo);

        assertEquals(2, ItemFactory.size()); 

    }

}
