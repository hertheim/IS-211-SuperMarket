/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;

/**
 * A customer enters the shop
 *
 * @author evenal
 */
public class BeginShoppingEvent extends Event {
    Customer customer;

    public BeginShoppingEvent(Customer customer) {
        super(customer.beginShoppingTime);
        this.customer = customer;
    }

    @Override
    public String toString() {
        return customer.name + " enters the shop, and starts shopping.";
    }

    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }
}
