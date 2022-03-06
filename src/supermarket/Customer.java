/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.EventSim;

/**
 *
 * @author evenal
 */
public class Customer {
    // customer will pick a random number of products between these two values
    public static final int MAX_PRODUCTS = 50;
    public static final int MIN_PRODUCTS = 0;

    // customer will spend random amount of time between these values before
    // going to check out
    public static final int MAX_SHOP_TIME = 100;
    public static final int MIN_SHOP_TIME = 1;

    SuperMarket shop;
    String name;
    Checkout checkout;

    int beginShoppingTime;
    int shoppingDuration;
    int numProducts;
    int endShoppingTime;
    int queueWaitDuration;
    int checkoutTime;
    int checkoutDuration;
    int leaveTime;

    public Customer(SuperMarket shop, int time) {
        this.shop = shop;
        name = "Customer-" + time;
        beginShoppingTime = EventSim.nextInt(0, 50);
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        shoppingDuration = EventSim.nextInt(MIN_SHOP_TIME, MAX_SHOP_TIME);
        endShoppingTime = beginShoppingTime + shoppingDuration;
        checkoutDuration = (numProducts * Checkout.PROD_DURATION) + Checkout.PAY_DURATION;
    }
}
