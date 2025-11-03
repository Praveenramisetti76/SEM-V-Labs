// Multithreading example: Palindrome and Perfect Numbers
class PalindromeThread extends Thread {
    public void run() {
        System.out.println("Palindrome numbers between 1 and 100:");
        for (int i = 1; i <= 100; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
            }
            try {
                Thread.sleep(100); // small delay for clear output
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("\nPalindrome thread completed.\n");
    }

    boolean isPalindrome(int num) {
        int temp = num, rev = 0;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return rev == num;
    }
}

class PerfectNumberThread extends Thread {
    public void run() {
        System.out.println("Perfect numbers between 1 and 100:");
        for (int i = 1; i <= 100; i++) {
            if (isPerfect(i)) {
                System.out.print(i + " ");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("\nPerfect number thread completed.\n");
    }

    boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num && num != 0;
    }
}

public class MultiThreadTasks {
    public static void main(String[] args) {
        PalindromeThread t1 = new PalindromeThread();
        PerfectNumberThread t2 = new PerfectNumberThread();

        t1.start(); // start palindrome thread
        t2.start(); // start perfect number thread
    }
}
