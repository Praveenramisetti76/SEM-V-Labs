import java.util.*;

public class RestaurantWaitList {
    public static void main(String[] args) {
        LinkedList<String> waitlist = new LinkedList<>();

        // Regular customers (added at end)
        waitlist.add("Rahul");
        waitlist.add("Sneha");

        // Priority customer (added at front)
        waitlist.addFirst("VIP - Mr. Sharma");

        waitlist.add("Amit");
        waitlist.add("Priya");

        System.out.println("Restaurant Waitlist: ");
        for (String name : waitlist) {
            System.out.println(name);
        }
    }
}
