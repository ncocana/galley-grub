package edu.craptocraft.galleygrub.items;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    
    private static Map<String, Item> itemMap = new HashMap<String, Item>();

    public ItemFactory() {}

    // Get the item without extras.
    public static Item getItem(String name, Double price) {
        itemMap.putIfAbsent(name, new Item(name, price));
        return itemMap.get(name);
    }

    // Get the item with extras.
    // e.g.: "item w/ extra".
    public static Item getItem(String name, Double price, String extra) {
        itemMap.putIfAbsent(name + " w/ " + extra, new Item(name, price, extra));
        return itemMap.get(name + " w/ " + extra);
    }

    // Returns the length/size of the Map.
    static int size() {
        return itemMap.size();
    }

    // Clears the Map.
    static void clear() {
        itemMap.clear();
    }

}
