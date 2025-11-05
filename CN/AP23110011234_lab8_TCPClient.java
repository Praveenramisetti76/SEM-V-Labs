import java.io.*;
import java.net.*;

public class AP23110011234_lab8_TCPClient {
    public static void main(String[] args) {
        try {
            // Connect to server
            Socket socket = new Socket("127.0.0.1", 8080);
            System.out.println("Connected to server.");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send message to server
            out.println("Hello Server");
            System.out.println("Message sent to server.");

            // Receive reply from server
            String reply = in.readLine();
            System.out.println("Reply from server: " + reply);

            // Close connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
