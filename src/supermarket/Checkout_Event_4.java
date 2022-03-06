package supermarket;

import eventsim.Event;

public class Checkout_Event_4 extends Event {
    Customer customer;

    public Checkout_Event_4(Customer customer) {
        super(customer.checkoutTime + 1);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        customer.checkoutTime ++;
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        customer.checkout.lastCustomerServedTime = customer.leaveTime;
        customer.checkout.setMaxQueueSize(customer.checkout.customers.size());
        return new LeaveStore_Event_5(customer);
    }

    @Override
    public String toString() {
        return customer.name + " is checking out at " + customer.checkout.name + ".";
    }
}
