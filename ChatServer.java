import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876); // Create a socket on port 9876
            byte[] receiveData = new byte[1024];
            
            System.out.println("Server is running...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                System.out.println("Client (" + clientAddress + ":" + clientPort + "): " + receivedMessage);

                // Send a response (echo back the message to the client)
                DatagramPacket sendPacket = new DatagramPacket(receivedMessage.getBytes(), receivedMessage.length(), clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
