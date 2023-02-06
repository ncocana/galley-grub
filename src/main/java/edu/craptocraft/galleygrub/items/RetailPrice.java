package edu.craptocraft.galleygrub.items;

import java.util.HashMap;
import java.util.Map;

public class RetailPrice {
    
    private static Map<String,Double> prices = new HashMap<String,Double>();

    private RetailPrice() {}

    // Insert extra ingredients and its prices on the "prices" Map.
    public static void init_prices() {
        prices.put("large", 0.5);
        prices.put("sauce", 0.5);
        prices.put("meidum", 0.25);
        prices.put("cheese", 0.25);
    }

    // Returns the price.
    public static Double getPrice(String item) {
        return prices.get(item);
    }

    // Checks if it contains "item" as Key and returns a boolean.
    public static boolean contains(String item) {
        return prices.containsKey(item);
    }

    public static void display() {
        prices.entrySet().stream().forEach(entry -> System.out.println("\t"+entry));
    }

}
