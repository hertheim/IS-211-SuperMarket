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
    public static final int NUM_CHECKOUTS = 1;
    public static final int NUM_CUSTOMERS = 10;

    private Checkout[] checkouts;
    private List<Customer> customers;
    private List<Event> events;

    public SuperMarket() {
        checkouts = new Checkout[NUM_CHECKOUTS];
        for (int i = 0; i < NUM_CHECKOUTS; i++)
            checkouts[i] = new Checkout(this, i);
        customers = new ArrayList<>();
        events = new ArrayList<Event>();
        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Customer customer = new Customer(this, i);
            events.add(new BeginShoppingEvent(customer));
            customers.add(customer);
        }
    }

    public void startSim() {
        EventSim simulation = EventSim.getInstance();
        simulation.setup(events);
        simulation.run();
    }
}
