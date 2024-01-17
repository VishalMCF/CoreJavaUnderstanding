package demo.networking.basicintro.insetaddressintro;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressIntro {

    public static void main(String[] args) {
        execute_demo_for_InetAddress_concepts_if_host_is_valid();
        execute_demo_for_InetAddress_concepts_if_host_is_invalid();
    }

    public static void execute_demo_for_InetAddress_concepts_if_host_is_valid(){
        try {
            InetAddress address = InetAddress.getByName("www.youtube.com");
            System.out.println("Youtube Host adress :-> "+address.getHostAddress());
            System.out.println("Youtube Host name:-> "+address.getHostName());
            address = InetAddress.getByName("www.google.com");
            System.out.println("Google Host adress :-> "+address.getHostAddress());
            System.out.println("Google Host name:-> "+address.getHostName());
        }catch(UnknownHostException exception){
            System.out.println("Could not find any host adress for youtube and google...");
        }
    }

    public static void execute_demo_for_InetAddress_concepts_if_host_is_invalid(){
        try {
            InetAddress address = InetAddress.getByName("https://www.youtube.com/watch?v=qIHOQ");
            System.out.println("Host adress :-> "+address.getHostAddress());
            System.out.println("Host name:-> "+address.getHostName());
        }catch(UnknownHostException exception){
            System.out.println("Could not find any host adress");
        }
    }

}
