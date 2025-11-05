import java.net.*;

public class AP23110011234_lab9_UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(8080);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("UDP Server is waiting for messages...");

            // Receive message from client
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Message received from client: " + message);

            // Get client info
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // Send reply
            String reply = "Hello UDP Client, got your message!";
            sendData = reply.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
            System.out.println("Reply sent to client.");

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
