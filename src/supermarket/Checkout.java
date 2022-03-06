/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.EventSim;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author evenal
 */
public class Checkout {
    // amount of time per product (to scan barcode)
    public static final int PROD_DURATION = 2;
    // amount of time to pay
    public static final int PAY_DURATION = 10;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd

    SuperMarket shop;
    String name;
    Deque<Customer> customers;
    double totalQueueWaitDuration;
    // Combined queue wait time for all the checkouts customers
    double averageQueueWaitDurationCustomer;
    // Average queue wait time for customers = totalQueueWaitDuration / totalQueueSize
    double lastCustomerServedTime;
    // Last time a customer is served by the checkout
    int maxQueueSize;
    // Largest queue size during simulation
    double totalQueueSize;
    // Total amount of customers that used the checkout
    double averageQueueSize;
    // Average queue size during simulation = calculateTotalQueueLength() / lastCustomerServedTime
    int totalQueueLength;
    int timeOfLastChangeInQueueLength;

    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout-" + i;
        this.customers = new LinkedList<>();
        this.timeOfLastChangeInQueueLength = EventSim.getClock();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int getLastCustomersLeaveTime() {
        return customers.peekLast().leaveTime;
    }

    public String getName() {
        return name;
    }

    public void setMaxQueueSize() {
        if(this.maxQueueSize < customers.size()) {
            this.maxQueueSize = customers.size();
        }
    }

    public void calculateTotalQueueLength(int currentTime) {
            int numberOfTimeIntervals = currentTime - timeOfLastChangeInQueueLength;
            timeOfLastChangeInQueueLength = currentTime;
            totalQueueLength += customers.size() * numberOfTimeIntervals;
    }

    public int getTotalQueueLength() {
        return totalQueueLength;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public void calculateAverageQueueSize() {
        averageQueueSize = totalQueueLength / lastCustomerServedTime;
    }

    public double getAverageQueueSize() {
        calculateAverageQueueSize();
        return averageQueueSize;
    }

    public int calculateQueueWaitDuration(Customer customer) {
        Customer customerAheadInQueue = customers.peekLast();
        if(customerAheadInQueue == null || customerAheadInQueue.equals(customer)){
            return 0;
        } else
            return customerAheadInQueue.leaveTime - customer.endShoppingTime;
    }

    public void calculateAverageQueueWaitDurationPerCustomer() {
        averageQueueWaitDurationCustomer = totalQueueWaitDuration / totalQueueSize;
    }

    public double getAverageQueueWaitDurationPerCustomer() {
        calculateAverageQueueWaitDurationPerCustomer();
        return averageQueueWaitDurationCustomer;
    }

    public double getTotalQueueWaitDuration() {
        return totalQueueWaitDuration;
    }
}
