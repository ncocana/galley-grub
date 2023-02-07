package edu.craptocraft.galleygrub.extras;

import java.util.Optional;

import edu.craptocraft.galleygrub.order.Comanda;

public abstract class Extra {
 
    protected static final String CHEESE = "";
    protected static final String SAUCE = "";
    protected static final String SAUCE_LARGE = "";
    protected String extraProduct = "";
    protected Optional<Extra> nextExtra = Optional.ofNullable(null);
    
    public Extra() {}

    public void setNextExtra(Extra extra) {
        this.nextExtra = Optional.of(extra);
    }

    public abstract void sumExtras(Comanda comanda);

}
