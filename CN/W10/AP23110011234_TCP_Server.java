import java.io.*;
import java.net.*;

public class AP23110011234_TCP_Server {

    public static void main(String[] args) {
        int port = 5000;  // default port

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Echo Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Create thread for each client
                new Thread(new ClientHandler(clientSocket)).start();
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            )
        ) {

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Echo back to client
                out.println(message);
            }

        } catch (IOException e) {
            System.out.println("Client disconnected.");
        }
    }
}
