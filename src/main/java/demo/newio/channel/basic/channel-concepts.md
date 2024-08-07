
Channel Interface

```java
public interface Channel {
	public boolean isOpen();
	public void close() throws IOException;
}
```

Channel implementations by JVM vary radically between operating systems.
Channel interfaces allow us to gain access to the low level I/O services in a controlled way

The 'Channel' interface is extended by three more interfaces
a. WritableByteChannel
b. ReadableByteChannel
c. InterruptibleChannel => Marker interface. If a class implements it then it means that class can be interrupted

Channels operate only on the ByteBuffer classes.

I/O falls into two types of categories:-
a. File I/O => FileChannel Class is the implementation
b. Stream I/O => SocketChannel, ServerSocketChannel, DatagramChannel

```java
public void demo() {
	// open the channel
	SocketChannel sc1 = SocketChannel.open();
	sc1.connect(new InetAddress("somehost", "someport"));

	ServerSocketChannel sc2 = new ServerSocketChannel.open();
	sc2.socket().bind(new InetSocketAddress(somelocalport));

	// open the channel
	DatagramChannel dc = DatagramChannel.open();
	RandomAccessFile raf = new RandomeAccessFile("somefile", "r");
	FileChannel fc = raf.getChannel();
}
```