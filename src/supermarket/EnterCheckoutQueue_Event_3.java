package supermarket;

import eventsim.Event;
import eventsim.EventSim;

public class EnterCheckoutQueue_Event_3 extends Event{
    Customer customer;

    public EnterCheckoutQueue_Event_3(Customer customer) {
        super(customer.endShoppingTime + 1);
        this.customer = customer;
        customer.checkout = customer.shop.getShortestCheckoutQueue();
        customer.checkoutTime = customer.endShoppingTime + customer.checkout.calculateQueueWaitDuration(customer) + 1;
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        customer.queueWaitDuration = customer.checkout.calculateQueueWaitDuration(customer);
        customer.checkout.totalQueueWaitDuration += customer.queueWaitDuration;
        customer.checkout.totalQueueSize ++;
        customer.checkout.calculateTotalQueueLength(EventSim.getClock() + 1);
        customer.shop.addToShortestCheckout(customer);
        customer.checkout.setMaxQueueSize();
        customer.checkout.setMaxQueueWaitDuration(customer.queueWaitDuration);
    }

    @Override
    public Event happen() {
        return new Checkout_Event_4(customer);
    }

    @Override
    public String toString() {
        return customer.name + " queues up at " + customer.checkout.name + ". The wait time is: " + customer.queueWaitDuration + ".";
    }


}
