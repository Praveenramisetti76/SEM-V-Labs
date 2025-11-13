import java.util.*;

public class CircularDelivery {
    public static void main(String[] args) {
        LinkedList<String> stops = new LinkedList<>();
        stops.add("Stop A");
        stops.add("Stop B");
        stops.add("Stop C");
        stops.add("Stop D");

        System.out.println("Food Delivery Stops: " + stops);

        System.out.println("\nCircular Traversal (2 rounds):");
        int rounds = 2;

        for (int i = 0; i < rounds; i++) {
            for (String stop : stops) {
                System.out.println("Delivering at: " + stop);
            }
        }
    }
}
