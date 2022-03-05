package supermarket;

import eventsim.Event;

public class Event4_CheckoutEvent extends Event {
    Customer customer;

    public Event4_CheckoutEvent(Customer customer) {
        super(customer.checkoutTime);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        return new Event5_LeaveStoreEvent(customer);
    }

    @Override
    public String toString() {
        return customer.name + " is checking out.";
    }
}
