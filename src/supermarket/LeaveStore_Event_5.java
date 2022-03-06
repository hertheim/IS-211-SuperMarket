package supermarket;

import eventsim.Event;
import eventsim.EventSim;

public class LeaveStore_Event_5 extends Event {
    Customer customer;

    public LeaveStore_Event_5(Customer customer) {
        super(customer.leaveTime);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        if(customer.numProducts == 0) {
            return null;
        }else {
            customer.checkout.calculateTotalQueueLength(EventSim.getClock());
            customer.checkout.customers.remove(customer);
            return null;
        }
    }

    @Override
    public String toString() {
        if(customer.numProducts == 0) {
            return customer.name + " leaves the supermarket without buying anything.";
        }else {
            return customer.name + " is done checking out at " + customer.checkout.name + ", and leaves the supermarket.";
        }
    }
}
