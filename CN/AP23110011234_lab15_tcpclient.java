
import java.io.*;
import java.net.*;

public class AP23110011234_lab15_tcpclient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server.");

        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("received.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = is.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bos.close();
        is.close();
        socket.close();

        System.out.println("✅ File received successfully!");
    }
}
