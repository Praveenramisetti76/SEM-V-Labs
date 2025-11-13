import java.util.*;

public class SortTransactions {
    public static void main(String[] args) {
        ArrayList<Integer> transactions = new ArrayList<>();
        transactions.add(2500);
        transactions.add(1200);
        transactions.add(4500);
        transactions.add(3000);
        transactions.add(1800);

        System.out.println("Before sorting: " + transactions);

        Collections.sort(transactions);

        System.out.println("After sorting (Ascending): " + transactions);

        Collections.sort(transactions, Collections.reverseOrder());

        System.out.println("After sorting (Descending): " + transactions);
    }
}
