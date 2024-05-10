## UDP (User Datagram Protocol)

UDP is known for being unreliable yet fast, and unlike TCP, it does not maintain state. It's commonly used in scenarios where speed is favored over reliability.

### Common Use Cases

1. **Real Time Streaming Protocol (RTSP):**  
   Utilized for controlling media streaming operations.

2. **Routing Information Protocol (RIP):**  
   Determines the routes for transmitting packets across networks.

3. **Domain Name System (DNS):**  
   Resolves internet domain names into their corresponding IP addresses.

4. **Network Time Protocol (NTP):**  
   Synchronizes clocks throughout the internet, ensuring all devices have the same time.

### Contents of the UDP packets:-
1. **IP Address and Port:** This is used to identify the destination where packet needs to be send
2. **Typical Size of UDP:** This is usually around 65507 bytes. If message is larger than that multiple packets would be needed to send
3. **Multicasting:** UDP packets can also be multicast. Which means message can be sent to every node which is part of the UDP group.

Following are the demonstrations illustrated in the package:-
1. Building traditional UDP client server model
2. Using NIO Channels to perform UDP operations
3. Multicast packets
4. Stream media such as audio or video to a client

### UDP Client Server
Similar to TCP client server. Server creates a socket out of the DatagramSocket class and the client will send packets using the
DatagramPacket class to hold the message. There is no restriction on the message content type.