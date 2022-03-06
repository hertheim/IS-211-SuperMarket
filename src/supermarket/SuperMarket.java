/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author evenal
 */
public class SuperMarket {
    public static final int NUM_CHECKOUTS = 2;
    public static final int NUM_CUSTOMERS = 10;

    private Checkout[] checkouts;
    private List<Customer> customers;
    private List<Event> events;

    public SuperMarket() {
        checkouts = new Checkout[NUM_CHECKOUTS];
        for (int i = 0; i < NUM_CHECKOUTS; i++){
            checkouts[i] = new Checkout(this, i);
        }
        customers = new ArrayList<>();
        events = new ArrayList<Event>();
        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Customer customer = new Customer(this, i);
            events.add(new BeginShopping_Event_1(customer));
            customers.add(customer);
        }
    }

    public Checkout getShortestCheckoutQueue() {
        Checkout shortestCheckout = null;
        int leaveTime = 0;
       if (checkouts.length == 1) {
            return checkouts[0];
       } else {
            for (Checkout checkout : checkouts) {
                if (checkout.customers.size() < 1) {
                    return checkout;
                }else if (shortestCheckout == null) {
                    shortestCheckout = checkout;
                    leaveTime = checkout.getLastCustomersLeaveTime();
                }else
                    if (leaveTime > checkout.getLastCustomersLeaveTime()){
                        leaveTime = checkout.getLastCustomersLeaveTime();
                        shortestCheckout = checkout;
                    }
            }
       }
        return shortestCheckout;
    }

    public void addToShortestCheckout(Customer customer) {
        getShortestCheckoutQueue().addCustomer(customer);
    }

    public Checkout[] getCheckouts() {
        return checkouts;
    }


    public void startSim() {
        EventSim simulation = EventSim.getInstance();
        simulation.setup(events);
        simulation.run();
    }
}
