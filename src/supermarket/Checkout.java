/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author evenal
 */
public class Checkout {
    // amount of time per prouct (to scan barcode)
    public static final int PROD_DURATION = 2;
    // amount of time to pay
    public static final int PAY_DURATION = 10;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd

    SuperMarket shop;
    String name;
    Deque<Customer> customers;

    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout-" + i;
        this.customers = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int getLastCustomersLeaveTime() {
        return customers.peekLast().leaveTime;
    }

    public int calculateQueueWaitDuration(Customer customer) {
        Customer customerAheadInQueue = customers.peekLast();
        if(customerAheadInQueue == null || customerAheadInQueue.equals(customer)){
            return 0;
        } else
            return customerAheadInQueue.leaveTime - customer.endShoppingTime;
    }
}
