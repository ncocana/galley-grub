package edu.craptocraft.galleygrub.items;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    
    private Map<String, Item> itemMap = new HashMap<String, Item>();

    public ItemFactory() {}

    // Get the item without extras.
    public Item getItem(String item, Double price) {
        itemMap.putIfAbsent(item, new Item(item, price));
        return itemMap.get(item);
    }

    // Get the item with extras.
    // e.g.: "item /w extra".
    public Item getItem(String item, Double price, String extra) {
        itemMap.putIfAbsent(item + " /w " + extra, new Item(item, price, extra));
        return itemMap.get(item + " /w " + extra);
    }

    // Returns the length/size of the Map.
    public int size() {
        return itemMap.size();
    }

    // Clears the Map.
    public void clear() {
        itemMap.clear();
    }

}
