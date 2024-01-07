package demo.newio.channel.basic;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelDemo {

    // Channel interface -> isOpen() and close()
    // interface is further extended by ReadByteChannel ad WritableByteChannel interfaces
    // ReadByteChannel -> int read(ByteBuffer buffer)
    // WritableByteChannel -> int write(ByteBuffer buffer)

    // How to obtain a channel ? Using Channels utility method -> WritableByteChannel Channels.newChannel(OutputStream outputStream)
    // or ReadByteChannel Channels.newChannel(InputStream inputStream)
    public static void main(String[] args) {

    }

    public static void execute_demo_for_copy_byte_from_one_channel_to_aother_channel(){
        // first open the channels using the utility class
        // open input and output channel
        // use these channels to copy bytes from input channel to the output channel
        ReadableByteChannel src = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);

        try{
            copy(src, dest);
        }catch(IOException ioe){
            System.err.println("I/O error: "+ioe.getMessage());
        }
        finally {
            try{
                src.close();
                dest.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }

    }

    private static void copy (ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        // declare the buffer to which data can be transferred from channel to the buffer
        ByteBuffer buffer = ByteBuffer.allocateDirect(2048);

        // start reading from the channel by default buffer is in the write mode
        // src.read(buffer) it reads from the source but in buffer writing operation is happening
        while(src.read(buffer) != 1){
            buffer.flip();
            dest.write(buffer);
            buffer.compact();
        }
        buffer.flip();
        while(buffer.hasRemaining()){
            dest.write(buffer);
        }
    }

    private static void copyAlt(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(2048);
        while(src.read(buffer) != -1){
            buffer.flip();
            while(buffer.hasRemaining()){
                dest.write(buffer);
            }
            buffer.clear();
        }
    }

}
