import java.util.*;

class Customer {
    int id;
    String name;
    double balance;

    Customer(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
}

public class CustomerList {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();

        customers.add(new Customer(101, "Ravi", 8500));
        customers.add(new Customer(102, "Sneha", 12000));
        customers.add(new Customer(103, "Amit", 20000));
        customers.add(new Customer(104, "Priya", 9500));

        System.out.println("Customers with balance > ₹10,000:");
        for (Customer c : customers) {
            if (c.balance > 10000) {
                System.out.println("ID: " + c.id + ", Name: " + c.name + ", Balance: ₹" + c.balance);
            }
        }
    }
}
