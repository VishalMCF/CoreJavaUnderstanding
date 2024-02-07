# Exploring Network Scalability in Java Networking

This package explores the concepts related to Network Scalability when we use Java for Networking. There are several areas of concerns when scalability comes into picture:-

a) Server Capacity
b) Multiple Threads
c) Network Bandwidth and Latency
d) Execution Environment

When we are writing java network applications several approaches are present to improve the scalability of the application. These are mainly:-

a) Multiple Threaded Server  
   - Many client requests can be handled concurrently
b) Thread Pool  
   - Reuse existing threads in the existing system
c) Futures and Callables  
   - Enables passing data and retrieving data from the threads
d) Selector (TCP/UDP)  
   - A single thread can handle multiple threads

## Configuring Threads in a Multithreaded Network

### a) Thread per request
   - When a client sends only a single request after establishing connection, this is ideal.

### b) Thread per connection
   - Enables the client to send multiple requests after establishing the connection. It is also called opening the session. Each session contains sending multiple requests. Data related to requests can be persisted as long as the session is active. This is a stateful connection.

### c) Thread per object
   - Each object is associated with a number of requests and its methods and state is put in a thread.
