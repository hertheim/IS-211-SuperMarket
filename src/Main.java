import supermarket.Checkout;
import supermarket.SuperMarket;

public class Main {

    public static void main(String[] arts) {
        SuperMarket superMarket = new SuperMarket();
        System.out.println("SuperMarket's checkouts:");
        for (Checkout checkout : superMarket.getCheckouts()) {
            System.out.println(checkout.getName());
        }
        superMarket.startSim();
    }
}
