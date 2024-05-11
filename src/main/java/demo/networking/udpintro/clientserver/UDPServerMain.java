package demo.networking.udpintro.clientserver;

public class UDPServerMain {

    public static void main(String[] args){
        UDPServer server = UDPServer.getInstance();
        server.init();
    }

}
