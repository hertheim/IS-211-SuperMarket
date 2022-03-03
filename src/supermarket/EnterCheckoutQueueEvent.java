package supermarket;


import eventsim.Event;

public class EnterCheckoutQueueEvent extends Event{
    Customer customer;

    public EnterCheckoutQueueEvent(Customer customer) {
        super(customer.endShoppingTime + 1);
        this.customer = customer;
        customer.checkout = customer.shop.getShortestCheckoutQueue();
        customer.checkoutTime = customer.endShoppingTime + customer.checkout.calculateQueueWaitDuration(customer) + 1;
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        customer.queueWaitDuration = customer.checkout.calculateQueueWaitDuration(customer);
        customer.shop.addToShortestCheckout(customer);
    }

    @Override
    public String toString() {
        return customer.name + " queues up at " + customer.checkout.name + ". The wait time is: " + customer.queueWaitDuration + ".";
    }

    @Override
    public Event happen() {
        return new CheckoutEvent(customer);
    }
}
