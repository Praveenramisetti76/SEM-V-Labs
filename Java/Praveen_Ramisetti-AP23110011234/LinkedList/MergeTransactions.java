import java.util.*;

public class MergeTransactions {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(101);
        list1.add(102);
        list1.add(103);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(201);
        list2.add(202);
        list2.add(203);

        System.out.println("Transactions from Branch 1: " + list1);
        System.out.println("Transactions from Branch 2: " + list2);

        // Merge both lists
        list1.addAll(list2);

        System.out.println("Merged Transaction IDs: " + list1);
    }
}
