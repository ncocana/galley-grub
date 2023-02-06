package edu.craptocraft.galleygrub.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.craptocraft.galleygrub.items.Item;
import edu.craptocraft.galleygrub.items.ItemFactory;

public class Order implements Comanda {

    private List<Item> items = new ArrayList<Item>();
    private Double total = 0.0;

    public Order() {}

    // Get the item from the Map of "ItemFactory" class
    // and adds it to "items" List.
    @Override
    public void addItem(String name, Double price) {
        Item item = ItemFactory.getItem(name, price);
        this.items.add(item);
    }

    // Get the item from the Map of "ItemFactory" class
    // and adds it to "items" List.
    @Override
    public void addItem(String name, Double price, String extra) {
        Item item = ItemFactory.getItem(name, price, extra);
        this.items.add(item);
    }

    // Returns the length/size of the "items" List.
    @Override
    public int size() {
        return this.items.size();
    }

    // Gets an unmodifiable List of "itemList",
    // preventing its modification.
    @Override
    public List<Item> itemList() {
        return Collections.unmodifiableList(this.items);
    }

    // Gets "total";
    @Override
    public Double getTotal() {
        return this.total;
    }

    // Sums "price" to "total".
    @Override
    public void updateTotal(Double price) {
        this.total += price;
        
    }

    // For each item in "itemList", display it this way:
    @Override
    public void display() {
        System.out.print("\n\t --- ORDER --- \n");
        itemList().stream().forEach(this::itemDisplay);
    }

    private void itemDisplay(Item item) {
        System.out.print("\t" + item.toString() + "\n");
    }
    
}
