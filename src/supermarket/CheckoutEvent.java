package supermarket;

import eventsim.Event;
import eventsim.EventSim;

public class CheckoutEvent extends Event {
    Customer customer;


    public CheckoutEvent(Customer customer) {
        super(customer.checkoutTime);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return null;
    }


    @Override
    public String toString() {
        return customer.name + " is checking out at time " + customer.checkoutTime + ".";
    }
}
