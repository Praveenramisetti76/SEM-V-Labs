import java.net.*;

public class AP23110011234_lab9_UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

            String message = "Hello UDP Server";
            byte[] sendData = message.getBytes();
            byte[] receiveData = new byte[1024];

            // Send message to server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 8080);
            clientSocket.send(sendPacket);
            System.out.println("Message sent to server.");

            // Receive reply
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String reply = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Reply from server: " + reply);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
