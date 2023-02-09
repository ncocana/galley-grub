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
        // TODO Auto-generated method stub
        return null;
    }

    public String toString() {
        return name() + "...." + String.format("%.2f", price()) + "$";
    }

    public boolean equals(Object item) {
        return this.name.equals(item);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
    
}
