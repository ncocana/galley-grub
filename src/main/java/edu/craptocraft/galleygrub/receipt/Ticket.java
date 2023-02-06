package edu.craptocraft.galleygrub.receipt;

import edu.craptocraft.galleygrub.order.Comanda;
import edu.craptocraft.galleygrub.extras.Extra;

public interface Ticket {
    
    Comanda getOrder();

    void setChain(Extra extra);

    Extra getChain();

    Double total();

    void sumExtrasCharges();

    void print();

}
