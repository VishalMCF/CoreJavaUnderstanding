package demo.networking.udpintro.clientserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

import javax.xml.crypto.Data;

public class UDPServer {

    private static final UDPServer SERVER = new UDPServer();

    public static UDPServer getInstance() {
        return SERVER;
    }

    public void init() {
        System.out.println("Starting UDP server....");
        try (DatagramSocket socket = new DatagramSocket(9003)) {
            while (true) {
                byte[] receiveMessage = new byte[1024];
                DatagramPacket packet = new DatagramPacket(receiveMessage, receiveMessage.length);
                socket.receive(packet);
                String message = new String(packet.getData());
                System.out.println("Received from client: [ " + message.trim() + "]\nFrom: " + packet.getAddress());

                // to send a response
                String response = "Request Acknowledged..";
                InetAddress address = packet.getAddress();
                int clientPort = packet.getPort();
                byte[] sendMessage = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(sendMessage, sendMessage.length, address, clientPort);
                socket.send(responsePacket);
            }
        } catch (SocketException exception) {
            System.out.println("socket exception happened" + Arrays.toString(exception.getStackTrace()));
        } catch (IOException exception) {
            System.out.println("socket exception happened" + Arrays.toString(exception.getStackTrace()));
            throw new RuntimeException(exception);
        }
        System.out.println("UDP server stopped");
    }
}
