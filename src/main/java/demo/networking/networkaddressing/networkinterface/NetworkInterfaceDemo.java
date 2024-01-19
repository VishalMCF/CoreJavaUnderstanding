package demo.networking.networkaddressing.networkinterface;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkInterfaceDemo {

    public static void main(String[] args) {
        execute_demo_for_network_interface_concepts();
    }

    public static void execute_demo_for_network_interface_concepts(){
        try{
            Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
            System.out.println("Name display name :- ");
            for(NetworkInterface element: Collections.list(interfaceEnum)){
                System.out.println(element.getName()+", "+element.getDisplayName());
            }
        }catch(Exception e){

        }
    }

}
