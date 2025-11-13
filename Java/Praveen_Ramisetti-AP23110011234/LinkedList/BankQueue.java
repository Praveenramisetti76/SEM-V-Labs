import java.util.*;

public class BankQueue {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        // Adding customers to queue
        queue.add("praveen");
        queue.add("dharma");
        queue.add("madhav");
        queue.add("mohan");

        System.out.println("Initial Queue: " + queue);

        // Serve the first customer
        String served = queue.poll();
        System.out.println("Customer served: " + served);

        // Display remaining queue
        System.out.println("Remaining Queue: " + queue);
    }
}
