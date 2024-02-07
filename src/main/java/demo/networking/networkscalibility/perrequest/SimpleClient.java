package demo.networking.networkscalibility.perrequest;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
    public static void main(String[] args) {
        System.out.println("Client started...");
        try{
            Socket socket = new Socket("127.0.0.1", 5000);
            System.out.println("Connected to a Server");
            PrintStream write = new PrintStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String partName = "Axle";
            write.println(partName);
            System.out.println("Request sent -> "+partName);
            String response = br.readLine();
            System.out.println("Server responded -> "+response);
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
