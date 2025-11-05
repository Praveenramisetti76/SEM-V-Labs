import java.io.*;
import java.net.*;

public class AP23110011234_lab8_TCPServer {
    public static void main(String[] args) {
        try {
            // Create a server socket at port 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is waiting for client connection...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive message from client
            String message = in.readLine();
            System.out.println("Message from client: " + message);

            // Send reply to client
            out.println("Hello Client, message received!");
            System.out.println("Reply sent to client.");

            // Close connections
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
