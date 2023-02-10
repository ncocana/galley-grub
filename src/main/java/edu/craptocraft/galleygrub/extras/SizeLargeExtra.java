package edu.craptocraft.galleygrub.extras;

import java.util.Optional;

import edu.craptocraft.galleygrub.items.RetailPrice;
import edu.craptocraft.galleygrub.order.Comanda;

public class SizeLargeExtra extends Extra {
    
    public SizeLargeExtra() {};

    public void sumExtras(Comanda comanda) {
        
        // Creates an Optional List with the prices of the items and sums it into "sumRegularPrice".
        Optional<Double> sumSizeLargePrice = comanda.itemList().stream().filter(item -> item.extra().equals(SIZE_LARGE))
        .map(item -> RetailPrice.getPrice(item.extra())).reduce(Double::sum);

        // If "sumRegularPrice" isn't empty,
        // calls the "updateTotal" method to update the "total" attribute of Comanda.
        if (sumSizeLargePrice.isPresent()) {
            comanda.updateTotal(sumSizeLargePrice.get());
        }

        // // If there's another extra, sum it to the "total".
        this.nextExtra.ifPresent( chain -> chain.sumExtras(comanda) );
    }

}
