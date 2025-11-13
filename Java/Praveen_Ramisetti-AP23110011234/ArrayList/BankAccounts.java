import java.util.*;

public class BankAccounts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> accounts = new ArrayList<>();

        System.out.println("Enter 5 bank account numbers:");
        for (int i = 0; i < 5; i++) {
            accounts.add(sc.nextLong());
        }

        System.out.print("Enter account number to search: ");
        long search = sc.nextLong();

        if (accounts.contains(search)) {
            System.out.println("Account number found!");
        } else {
            System.out.println("Account number not found.");
        }

        sc.close();
    }
}
