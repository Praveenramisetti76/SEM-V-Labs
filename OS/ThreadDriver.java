import java.io.*;

// Class for printing even numbers
class EvenThread extends Thread {
  //  @Override // Good practice to use @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": even number " + i);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// Class for printing odd numbers
class OddThread extends Thread {
  //  @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ": odd number " + i);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// Driver class containing the main method
public class ThreadDriver {
    public static void main(String[] args) {
        System.out.println("Starting threads...");
        
        EvenThread t1 = new EvenThread();
        t1.setName("Even Thread");
        t1.start(); // Start the even thread

        OddThread t2 = new OddThread();
        t2.setName("Odd Thread");
        t2.start(); // Start the odd thread

        // Optional: Use join to wait for threads to finish before main exits
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("All threads have finished execution.");
    }
}