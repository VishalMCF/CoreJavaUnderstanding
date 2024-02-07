package demo.networking.networkscalibility.perrequest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleMultiThreadedServer implements Runnable {
    private static ConcurrentHashMap<String, Double> database;
    private Socket clientSocket;

    static {
        database.put("Axle",238.60);
        database.put("Gear",28.60);
        database.put("Wheel",79.60);
        database.put("Rotor",152.60);
        database.put("Spanner",39.60);
        database.put("Type",21.60);
    }

    public SimpleMultiThreadedServer(Socket socket){
        this.clientSocket = socket;
    }

    public static void main(String[] args) {
        System.out.println("Multi threaded server started");
        try {
            ServerSocket socket = new ServerSocket(5000);
            while(true){
                System.out.println("Listening for a client connection");
                Socket clientSocket = socket.accept();
                System.out.println("Connected to a client");
                new Thread(new SimpleMultiThreadedServer(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Multi threaded server terminated");
    }

    @Override
    public void run() {
        System.out.println("Client Thread started ......");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
            while(true){
                String keyName = br.readLine();
                if(keyName.equals("quit")){
                    break;
                }
                if(!database.containsKey(keyName)){
                    printWriter.print("ERR: NOT FOUND");
                } else {
                    double price = database.get(keyName);
                    printWriter.print(price);
                    System.out.println(" Request for "+keyName+ " and returned a price of "+price);
                }
            }
            clientSocket.close();
            System.out.println("Client connection terminated");
        }catch(IOException exception){
            exception.printStackTrace();
        }
        System.out.println("Client Thread terminated .......");
    }
}
