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
        if(customer.numProducts == 0) {
            return null;
        }else {
            customer.checkout.customers.remove(customer);
            return null;
        }
    }

    @Override
    public String toString() {
        if(customer.numProducts == 0) {
            return customer.name + " leaves the store without buying anything.";
        }else {
            return customer.name + " is done checking out at " + customer.checkout.name + ", and leaves the store.";
        }
    }
}
