/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;

/**
 * A customer finishes shopping and heads for the checkout with the shortest
 * queue
 *
 * @author evenal
 */
public class Event2_EndShoppingEvent extends Event {
    Customer customer;


    public Event2_EndShoppingEvent(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        if(customer.numProducts == 0) {
            customer.leaveTime = customer.endShoppingTime + 1;
            return new Event5_LeaveStoreEvent(customer);
        }else {
            return new Event3_EnterCheckoutQueueEvent(customer);
        }
    }


    @Override
    public String toString() {
        if(customer.numProducts == 0) {
            return customer.name + " decided not to buy anything, and is done shopping.";
        }else{
            return customer.name + " has collected all it's items(" + customer.numProducts + "), and is done shopping.";
        }
    }

}
