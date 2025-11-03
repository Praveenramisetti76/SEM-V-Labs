// Program: Multithreading using Runnable interface
// Task 1 -> Print all palindrome numbers between 1 and 100
// Task 2 -> Print all perfect numbers between 1 and 100

class PalindromeTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Palindrome Numbers between 1 and 100:");
        for (int i = 1; i <= 100; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
            }
            try {
                Thread.sleep(100); // small delay for clarity
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("\n--- End of Palindrome Task ---\n");
    }

    private boolean isPalindrome(int num) {
        int rev = 0, temp = num;
        while (temp > 0) {
            rev = rev * 10 + (temp % 10);
            temp /= 10;
        }
        return num == rev;
    }
}

class PerfectTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Perfect Numbers between 1 and 100:");
        for (int i = 1; i <= 100; i++) {
            if (isPerfect(i)) {
                System.out.print(i + " ");
            }
            try {
                Thread.sleep(100); // small delay for clarity
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("\n--- End of Perfect Task ---\n");
    }

    private boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n && n != 0;
    }
}

public class TwoTasksRunnable {
    public static void main(String[] args) {
        // Create Runnable objects
        Runnable palindrome = new PalindromeTask();
        Runnable perfect = new PerfectTask();

        // Create Thread objects for each task
        Thread t1 = new Thread(palindrome);
        Thread t2 = new Thread(perfect);

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both to complete
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Both tasks completed successfully.");
    }
}
