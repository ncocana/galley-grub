package edu.craptocraft.galleygrub.extras;

import java.util.Optional;

import edu.craptocraft.galleygrub.items.Item;
import edu.craptocraft.galleygrub.order.Comanda;

public class Regular extends Extra {
    
    public Regular() {};

    public void sumExtras(Comanda comanda) {
        
        // Creates an Optional List with the prices of the items and sums it into "sumRegularPrice".
        Optional<Double> sumRegularPrice = comanda.itemList().stream().map(Item::price).reduce(Double::sum);

        // If "sumRegularPrice" isn't empty,
        // calls the "updateTotal" method to update the "total" attribute of Comanda.
        if (sumRegularPrice.isPresent()) {
            comanda.updateTotal(sumRegularPrice.get());
        }

        // // If there's another extra, sum it to the "total".
        this.nextExtra.ifPresent( chain -> chain.sumExtras(comanda) );
    }

}
