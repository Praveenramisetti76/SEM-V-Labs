import java.util.*;

public class AP23110011234_lab14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of frames: ");
        int totalFrames = sc.nextInt();

        System.out.print("Enter window size: ");
        int windowSize = sc.nextInt();

        int frameToSend = 0;
        boolean lostFrame = false;

        while (frameToSend < totalFrames) {
            System.out.println("\n--- Sending Window ---");
            for (int i = frameToSend; i < frameToSend + windowSize && i < totalFrames; i++) {
                System.out.println("Sent Frame " + i);
            }

            // Simulate random lost frame or lost ACK
            Random rand = new Random();
            int event = rand.nextInt(5); // 0 to 4 chance
            if (event == 2 && !lostFrame) {
                System.out.println("\n Frame " + frameToSend + " lost! Retransmitting...");
                lostFrame = true;
                continue; // retransmit same frame
            } else if (event == 3 && !lostFrame) {
                System.out.println("\n ACK for Frame " + frameToSend + " lost! Retransmitting window...");
                lostFrame = true;
                continue;
            }

            lostFrame = false;
            System.out.println("\n--- Receiving Acknowledgments ---");
            for (int i = frameToSend; i < frameToSend + windowSize && i < totalFrames; i++) {
                System.out.println("ACK received for Frame " + i);
            }

            frameToSend += windowSize;
            System.out.println("\nWindow slid to " + frameToSend);
        }

        System.out.println("\n All frames sent and acknowledged successfully!");
        sc.close();
    }
}
