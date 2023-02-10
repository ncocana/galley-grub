package edu.craptocraft.galleygrub.extras;

import java.util.Optional;

import edu.craptocraft.galleygrub.order.Comanda;

public abstract class Extra {
 
    protected static final String CHEESE = "cheese";
    protected static final String SAUCE = "sauce";
    protected static final String SIZE_LARGE = "large";
    protected Optional<Extra> nextExtra = Optional.ofNullable(null);
    
    public Extra() {}

    public void setNextExtra(Extra extra) {
        this.nextExtra = Optional.of(extra);
    }

    public abstract void sumExtras(Comanda comanda);

}
