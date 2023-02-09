package edu.craptocraft.galleygrub.receipt;

import edu.craptocraft.galleygrub.extras.Extra;
import edu.craptocraft.galleygrub.order.Comanda;

public class Receipt implements Ticket {

    private Comanda order = null;
    private Double total = 0d;
    private Extra extra = null;

    public Receipt(Comanda order) {
        this.order = order;
    }

    // Returns the value of "order".
    @Override
    public Comanda getOrder() {
        return this.order;
    }

    // Change the value of "extra" to the value of "nextExtra".
    @Override
    public void setChain(Extra nextExtra) {
        this.extra = nextExtra;
    }

    // Returns the value of "extra".
    @Override
    public Extra getChain() {
        return this.extra;
    }

    // If "total" is "0d",
    // executes the method "sumExtrasCharge()".
    // Then assign the value of "total" of
    // the given "order" to "total" and returns it.
    @Override
    public Double total() {
        if (total == 0d) {
            sumExtrasCharges();
            this.total = this.getOrder().getTotal();
        }
        return this.total;
    }

    // If "extra" is not null,
    // calls the method "sumExtras()" from the class "Extra"
    // to sum the value of "order".
    @Override
    public void sumExtrasCharges() {
        if (extra != null) {
            this.extra.sumExtras(this.order);
        }
    }

    @Override
    public void print() {
        this.getOrder().display();
        System.out.println("\tTOTAL --------> " + String.format("%.2f", total()) + "$\n");
    }
    
}
