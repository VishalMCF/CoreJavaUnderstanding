package demo.networking.basicintro.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {
        System.out.println("Echo client code demo");
        execute_demo_for_the_echo_client();
    }

    private static void execute_demo_for_the_echo_client() {
        try{
            System.out.println("Waiting for connection");
            InetAddress address = InetAddress.getLocalHost();
            try(Socket clientSocket = new Socket(address, 6000);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                System.out.println("Connected to the server");
                Scanner scanner = new Scanner(System.in);
                while(true){
                    System.out.println("Enter text: ");
                    String inputLine = scanner.nextLine();
                    if("quit".equalsIgnoreCase(inputLine)){
                        break;
                    }
                    out.println(inputLine);
                    String outputLine = br.readLine();
                    System.out.println("Server responded -> "+outputLine);
                }
            }catch(Exception e){
                System.out.println("Error happened while connecting to the socket");
            }
        }catch(IOException exc){

        }
    }
}
