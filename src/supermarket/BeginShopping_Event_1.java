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
public class BeginShopping_Event_1 extends Event {
    Customer customer;

    public BeginShopping_Event_1(Customer customer) {
        super(customer.beginShoppingTime);
        this.customer = customer;
    }

    @Override
    public String toString() {
        return customer.name + " enters the supermarket, and starts shopping.";
    }

    @Override
    public Event happen() {
        return new EndShopping_Event_2(customer);
    }
}
