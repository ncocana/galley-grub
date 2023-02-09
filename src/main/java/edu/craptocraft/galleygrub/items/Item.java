package edu.craptocraft.galleygrub.items;

public class Item implements Product {

    protected String name = "";
    protected Double price = 0d;
    protected String extra = "";

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, Double price, String extra) {
        this.name = name;
        this.price = price;
        this.extra = extra;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Double price() {
        return this.price;
    }

    @Override
    public String extra() {
        return this.extra;
    }

    @Override
    public Boolean isRegular() {
        return this.extra().isBlank();
    }

    // If there is a extra, return the string with the extra.
    // Otherwise, return the string without the extra.
    public String toString() {
        return RetailPrice.contains(this.extra())? this.name + "...." + String.format("%.2f", price()) + "$ + " + String.format("%.2f", RetailPrice.getPrice(extra)) + "$":this.name + "...." + String.format("%.2f", price()) + "$";
    }

    public boolean equals(Object item) {
        return this.name.equals(item);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
    
}
