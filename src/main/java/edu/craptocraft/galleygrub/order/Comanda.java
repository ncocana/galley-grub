package edu.craptocraft.galleygrub.order;

import java.util.List;

import edu.craptocraft.galleygrub.items.Item;

public interface Comanda {
    
    void addItem(String item, Double price);

    void addItem(String item, Double price, String extra);

    int size();

    List<Item> itemList();

    Double getTotal();

    void updateTotal(Double price);

    void display();

}
