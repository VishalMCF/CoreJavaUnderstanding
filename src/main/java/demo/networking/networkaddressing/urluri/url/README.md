basic concepts in network addressing:-
1. Network basics:-  essential concepts and terms
2. Using the NetworkInterface class:- this provides access to system devices
3. URL/UII/URN:- how they are related to each other
4. The Inet4Address and Inet6Address class:- how to use them
5. Network Properties:- network properties that are configurable in java

URL:- Uniform Resource Locator
URI:- Uniform Resource Identifier
URN:- Uniform Resource Name

URL is mapped to IP Address and DNS is used to store these mappings
InetAddress class is used to access IP Addresss and resources

UDP and TCP both are supported by IP. Java provides support for both IPv4 and IPv6 protocol versions
IP [1st Layer] > (TCP and UDP) [2nd Layer]> (HTTP, SMTP, FTP, ....)[3rd Layer]

2 types of IP address:- static and dynamic. static IP address remain constant even f the device is rebooted
in case of dynamic, the IP address may change when device is rebooted or the network connection is reset.

Dynamic addresses are assigned by (DHCP) Dynamic Host Configuration Protocol.

