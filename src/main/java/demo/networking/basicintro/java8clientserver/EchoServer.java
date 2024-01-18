package demo.networking.basicintro.java8clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class EchoServer {

    public static void main(String[] args) {
        execute_demo_for_java8_client_server_demo();
    }

    private static void execute_demo_for_java8_client_server_demo() {
        try(ServerSocket serverSocket = new ServerSocket(6000)){
            System.out.println("Server started onn port => 6000");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Waiting for a client to connect....");
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
            Supplier<String> inputSupplier = ()->{
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    return null;
                }
            };
            Stream<String> clientInputStream = Stream.generate(inputSupplier);
            clientInputStream.map((s) -> {
                System.out.println("Client sent -> "+s);
                printWriter.println("Server respose -> "+s);
                return s;
            }).allMatch(s -> s!=null);
        }catch(Exception e){
            System.out.println("Exception happend while connecting to socket...");
        }
    }

}
