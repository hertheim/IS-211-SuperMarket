package supermarket;

import eventsim.Event;

public class LeaveStoreEvent extends Event {
    Customer customer;


    public LeaveStoreEvent(Customer customer) {
        super(customer.leaveTime);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        customer.checkout.customers.remove(customer);
        return null;
    }

    @Override
    public String toString() {
        return customer.name + " is done checking out, and leaves the store.";
    }
}
