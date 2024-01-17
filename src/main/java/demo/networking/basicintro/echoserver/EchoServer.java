package demo.networking.basicintro.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * A server is identified by the IPAddress and the port number because on a machine it is possible that multiple servers are running.
 *
 * For the server to communicate with the client and listen to requests and send the response back a special kind of software is used. This software
 * is called socket.
 * One socket is found on the server side and the other socket is found on the client side.
 * Various types of sockets are there :- StreamSocket (TCP), DatagramSocket(UDP), etc.
 */


/**
 * The below is an implementation of an echo server. It gets the request from the client and send the same request content back to the client.
 *
 * ServerSocket is the class which is used by the server to listen to the client requests
 * its argument is the port number
 * Socket is the class which used by the client to connect to a server.
 *
 */

public class EchoServer {

    public static void main(String[] args) {
        execute_demo_for_a_simple_echo_server();
    }

    /**
     * after the socket is created using the constructor the accept() method will be called.
     * What it means is that the code will pause there until a client sends a request.
     * When the request is reached to the server the accept method returns a socket instance which can be used to read the content from the request
     * It can also be used to write and send response to the client.
     *
     * When a text is written to the socket it will sit in a buffer until either the buffer is full or flush method is called.
     *
     */
    public static void execute_demo_for_a_simple_echo_server(){
        try (ServerSocket socket = new ServerSocket(6000)){
            System.out.println("waiting for the connection...");
            Socket clientSocket = socket.accept();
            System.out.println("A client has connected...");
            try(BufferedReader reader  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine;
                while((inputLine = reader.readLine())!=null){
                    System.out.println("Client send this -> "+inputLine);
                    out.println("Server responded -> "+inputLine);
                }
            }catch(Exception e){
                System.out.println("Exception happend while running the demo");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
