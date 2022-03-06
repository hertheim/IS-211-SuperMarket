import supermarket.Checkout;
import supermarket.SuperMarket;

public class Main {

    public static void main(String[] arts) {
        SuperMarket superMarket = new SuperMarket();
        superMarket.startSim();
        System.out.println("\nDATA MONITORING:");
        for(Checkout checkout : superMarket.getCheckouts()){
            System.out.println(checkout.getName() + ":");
            System.out.println("    " + checkout.getName() + " had a maximum queue size of " + checkout.getMaxQueueSize() + ".");
            System.out.println("    " + checkout.getName() + " had a average queue size of " + checkout.getAverageQueueSize() + ".");
            System.out.println("    " + checkout.getName() + " had a total queue wait duration of " + checkout.getTotalQueueWaitDuration() + " time units.");
            System.out.println("    Customers at " + checkout.getName() + " had a average queue wait duration of " + checkout.getAverageQueueWaitDurationPerCustomer() + " time units.\n");
        }
    }
}
