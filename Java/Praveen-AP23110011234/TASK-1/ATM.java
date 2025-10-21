import java.util.*;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 1000.0;  // Initial balance
        int choice;

        System.out.println("=== Welcome to the ATM ===");
        System.out.println("Your initial balance is: " + balance);

        while (true) {
            // Show menu
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: " + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Deposit successful. New balance: " + balance);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw > balance) {
                        System.out.println("Insufficient balance!");
                    } else if (withdraw <= 0) {
                        System.out.println("Invalid withdrawal amount.");
                    } else {
                        balance -= withdraw;
                        System.out.println("Withdrawal successful. New balance: " + balance);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    sc.close();
                    return; // Exit program

                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }
        }
    }
}
