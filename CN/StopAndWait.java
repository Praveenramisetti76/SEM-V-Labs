import java.util.Random;

public class StopAndWait {

    static Random random = new Random();

    // Sender function
    public static void sender(int totalFrames) {
        int frame = 0;
        while (frame < totalFrames) {
            System.out.println("Sender: Sending Frame " + frame);

            // Call receiver and check if ACK received
            boolean ackReceived = receiver(frame);

            if (ackReceived) {
                System.out.println("Sender: ACK received for Frame " + frame + "\n");
                frame++; // move to next frame
            } else {
                System.out.println("Sender: Timeout! Resending Frame " + frame + "\n");
                // don't increment, resend same frame
            }
        }
        System.out.println("Sender: All frames sent successfully!");
    }

    // Receiver function
    public static boolean receiver(int frame) {
        // Simulate frame loss with probability 30%
        boolean frameLost = random.nextInt(10) < 3;

        if (frameLost) {
            System.out.println("Receiver: Frame " + frame + " lost! No ACK sent.");
            return false; // ACK not received
        } else {
            System.out.println("Receiver: Frame " + frame + " received. Sending ACK...");
            return true; // ACK received
        }
    }

    public static void main(String[] args) {
        int totalFrames = 5;  // Number of frames to send
        sender(totalFrames);
    }
}