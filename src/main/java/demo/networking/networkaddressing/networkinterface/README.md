NetworkInterface class provides means to access those devices who are acting like nodes on a network.
It can also be used to provide low level device's addresses.

This class does not have any public constructors. It contains 3 static methods to return an instance of the
Network interface
1. getByInetAddress:- this is used if the IP address is known
2. getByName:-     this is used if the interface name is known     
3. getNetworkInterfaces:- provides an enumeration of available interfaces

getSubInterfaces:- it can be used to return enumeration if the physical network interface is divided 
into multiple subinterfaces
