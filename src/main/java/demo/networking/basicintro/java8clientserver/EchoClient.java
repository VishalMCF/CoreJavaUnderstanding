package demo.networking.basicintro.java8clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class EchoClient {

    public static void main(String[] args) {
        execute_demo_for_the_java_8_client();
    }

    private static void execute_demo_for_the_java_8_client() {
        try(Socket socket = new Socket(InetAddress.getLocalHost(), 6000);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            System.out.println("Connected to the server");
            // create a scanner which can read from the user
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter text: ");
            Supplier<String> supplier = ()->scanner.nextLine();
            Stream<String> stream = Stream.generate(supplier);
            stream.map(s -> {
                System.out.println("Sending request to the server");
                out.println(s);
                try {
                    System.out.println("Response received from the server -> "+br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return s;
            }).allMatch(
                s -> !"quit".equalsIgnoreCase(s)
            );
        }catch(Exception e){
            System.out.println("client code could not be executed properly");
        }
    }

}
