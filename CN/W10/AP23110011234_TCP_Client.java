import java.io.*;
import java.net.*;

public class AP23110011234_TCP_Client {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to Echo Server");
            System.out.println("Type messages and press Enter. Type 'exit' to quit.");

            String message;
            while ((message = userInput.readLine()) != null) {

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                out.println(message);           // Send to server
                String response = in.readLine(); // Receive echo

                System.out.println("Echo: " + response);
            }

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
