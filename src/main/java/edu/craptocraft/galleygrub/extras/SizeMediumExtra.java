package edu.craptocraft.galleygrub.extras;

import java.util.Optional;

import edu.craptocraft.galleygrub.items.RetailPrice;
import edu.craptocraft.galleygrub.order.Comanda;

public class SizeMediumExtra extends Extra {
    
    public SizeMediumExtra() {};

    public void sumExtras(Comanda comanda) {
        
        // Creates an Optional List with the prices of the items and sums it into "sumRegularPrice".
        Optional<Double> sumSizeMediumPrice = comanda.itemList().stream().filter(item -> item.extra().equals(SIZE_MEDIUM))
        .map(item -> RetailPrice.getPrice(item.extra())).reduce(Double::sum);

        // If "sumRegularPrice" isn't empty,
        // calls the "updateTotal" method to update the "total" attribute of Comanda.
        if (sumSizeMediumPrice.isPresent()) {
            comanda.updateTotal(sumSizeMediumPrice.get());
        }

        // // If there's another extra, sum it to the "total".
        this.nextExtra.ifPresent( chain -> chain.sumExtras(comanda) );
    }

}
