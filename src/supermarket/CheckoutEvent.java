package supermarket;

import eventsim.Event;

public class CheckoutEvent extends Event {
    Customer customer;

    public CheckoutEvent(Customer customer) {
        super(customer.checkoutTime);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        return new LeaveStoreEvent(customer);
    }

    @Override
    public String toString() {
        return customer.name + " is checking out.";
    }
}
