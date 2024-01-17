# Java NIO (New I/O) Concepts

Java NIO (New I/O) provides an alternative to the traditional I/O (Input/Output) API for handling data in a more scalable and efficient manner. In Java NIO, there are three key concepts that form the foundation of the framework:

1. **Buffer:**

   A Buffer in Java NIO is essentially a temporary repository for data. It is a container for a fixed amount of data of a specific primitive type (e.g., bytes, integers, characters). Buffers are used to read data from channels or write data into channels. They offer a way to efficiently manage data in memory before it is sent or received through a channel.

2. **Channels:**

   Channels are a fundamental part of Java NIO and are closely associated with buffers. A channel represents an open connection to an I/O source or destination, such as a file or a network socket. Data can be transferred between a channel and a buffer in either direction. Channels provide a more flexible and efficient means of reading and writing data compared to traditional stream-based I/O.

3. **Selectors:**

   Selectors are an advanced feature of Java NIO that allows a single thread to manage multiple channels efficiently. With a Selector, a single thread can monitor multiple channels for I/O events and respond accordingly. This enables applications to handle many channels concurrently without the need for creating a separate thread for each channel, making it a powerful tool for building scalable and high-performance network applications.

## Buffer and Channels Relationship

Buffer and channels work closely together in Java NIO:

- Data can be read from a channel into a buffer.
- Data can be written from a buffer into a channel.

Buffer acts as an intermediate storage for data between a channel and the application. It allows for more efficient I/O operations by reducing the need for constant interaction with the underlying I/O system.

## Important Channel Types

In Java NIO, there are several types of channels, each designed for specific I/O operations:

a) **FileChannel:**

FileChannel is used for reading and writing data to and from files. It provides a way to perform file I/O operations efficiently, such as reading from or writing to files using buffers.

b) **DatagramChannel:**

DatagramChannel is used for reading and writing data via UDP (User Datagram Protocol) communication. UDP is a connectionless protocol often used in scenarios where low overhead and speed are crucial.

c) **SocketChannel:**

SocketChannel is used in conjunction with TCP (Transmission Control Protocol) for network communication. It is typically used on the client side to establish connections and exchange data with remote servers over a network.

d) **ServerSocketChannel:**

ServerSocketChannel is used on the server side for accepting incoming TCP connections from clients. It listens for incoming connections and creates a new SocketChannel for each client connection.

Understanding these Java NIO concepts is crucial for building efficient and scalable I/O operations in Java applications. By using buffers, channels, and selectors, you can take advantage of non-blocking I/O and design high-performance network and file I/O applications.

# Using URLConnection and Channels in Java NIO

In this tutorial, we'll explore how to use Java NIO (New I/O) with `URLConnection` and `Channels` to efficiently read data from a URL. We will break down the code step by step.

## Key Concepts

### 1. URLConnection

- `URLConnection` is a Java class that helps connect to a remote server using its URL.
- It establishes a communication link between your application and a resource over the internet represented by a URL.

### 2. Channels and Buffers

- Channels and buffers are core concepts in Java NIO for efficient I/O operations.
- A `Channel` represents an open connection to an I/O source or destination, while a `Buffer` is used to read from or write to a `Channel`.
- Channels and buffers offer improved performance compared to traditional stream-based I/O.

## Implementation

Let's analyze the code in the `UrlConectionAndChannelDemo` class.

```java
import java.io.BufferedReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class UrlConectionAndChannelDemo {
```

### Main Method

```java
    public static void main(String[] args) {
        execute_demo_for_channel_usage_with_url_connection();
    }
```

In the `main` method, we call `execute_demo_for_channel_usage_with_url_connection()` to demonstrate the usage of channels and URLConnection.

### Channel Usage with URLConnection

```java
    private static void execute_demo_for_channel_usage_with_url_connection() {
        try {
            URL url = new URL("https://www.youtube.com/watch?v=VI4s1w5ywzc");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
```

1. We create a `URL` object representing the URL we want to connect to (`"https://www.youtube.com/watch?v=VI4s1w5ywzc"`).

2. Using `url.openConnection()`, we establish a connection to the URL and obtain a `URLConnection` object.

3. We retrieve an `InputStream` from the `URLConnection`, which allows us to read data from the URL.

4. Next, we create a `ReadableByteChannel` using `Channels.newChannel(inputStream)`. This channel will enable us to efficiently read data from the input stream.

5. We allocate a `ByteBuffer` of size 1024 bytes. The buffer acts as a temporary storage for the data we read from the URL.

```java
            // by default buffer when uffer is created it will be a write buffer
            String line = null;
            int cnt = 0;
            while (readableByteChannel.read(buffer) > 0) {
                line = new String(buffer.array());
                System.out.println(line);
                buffer.clear();
                if (cnt > 0) break;
                cnt++;
            }
        } catch (Exception e) {
            System.out.println("An exception occurred while executing the demo...");
        }
    }
}
```

1. We enter a loop to read data from the URL using the `readableByteChannel`.

2. Inside the loop, we read data into the `ByteBuffer` using `readableByteChannel.read(buffer)`. The `read` method returns the number of bytes read.

3. We convert the data from the `ByteBuffer` to a `String` and print it to the console.

4. We clear the buffer to prepare it for the next read.

5. We break out of the loop after reading one iteration to demonstrate the process.

6. Exception handling is included to catch any exceptions that may occur during the demo.

This code illustrates how to use URLConnection and channels to efficiently read data from a URL in a Java NIO context. Understanding these concepts can be valuable for handling network communication and data retrieval in Java applications.