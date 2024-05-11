package demo.networking.udpintro.clientserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {

    public UDPClient() {
    }

    public void init() {
        System.out.println("UDP client started....");
        Scanner scanner = new Scanner(System.in);
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getLocalHost();
            byte[] messageData;
            while (true) {
                System.out.println("Enter a message to be sent:-");
                String message = scanner.nextLine();
                if ("quit".equalsIgnoreCase(message)) {
                    break;
                }
                messageData = message.getBytes();
                DatagramPacket packet = new DatagramPacket(messageData, messageData.length, address, 9003);
                socket.send(packet);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("UDP client Terminating....");
    }
}
