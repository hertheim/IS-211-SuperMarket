package supermarket;


import eventsim.Event;

public class BeginCheckoutEvent extends Event{
    Customer customer;

    public BeginCheckoutEvent(Customer customer) {
        super(customer.endShoppingTime);
        this.customer = customer;
        customer.checkout = customer.shop.getShortestCheckoutQueue();
        customer.checkoutTime = customer.endShoppingTime + customer.checkout.calculateQueueWaitDuration(customer);
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        customer.queueWaitDuration = customer.checkout.calculateQueueWaitDuration(customer);
        customer.shop.addToShortestCheckout(customer);
    }

    @Override
    public String toString() {
        return "BeginCheckoutEvent for " + customer.name + ". At checkout: " + customer.checkout.getName() + ". Number of products: " + customer.numProducts + ". Leave time:" + customer.leaveTime;
    }

    @Override
    public Event happen() {
        return new CheckoutEvent(customer);
    }
}
