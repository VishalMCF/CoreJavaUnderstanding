package demo.newio.buffer.basic;

import java.nio.*;
import java.util.Random;

// There are 3 ways to create non-direct byte buffers
// 1. using allocate(int capacity) method
// 2. using an existing byte array as the backing array for the buffer using wrap(byte[] array)
// 3. using wrap(byte[] array, int offset, int limit)


// use get() and put() method to read ot write to the buffer

// use the flip() method to change the mode of the buffer from either read mode to write mode or vice-versa

// use the mark() method to return to the position via reset() method. This will reset the postion to an earlier offset and all the remaing items
// in the buffer will be sent to channel


public class BufferDemo {

    static Random rand = new Random();
    public static void main(String[] args) {
        //execute_demo_for_buffer_basics();
        execute_demo_for_limit_property_of_buffer();
    }

    public static void execute_demo_for_limit_property_of_buffer(){

        // we have set the items to 1000 while capacity was for 1024
        // we will set the limit to 100 so that we can read inly 100 items from the buffer

        ByteBuffer myBuffer = ByteBuffer.allocate(1024);

        // putting 824 items in the buffer
        for(int i=0; i<824; i++) {
            int item = rand.nextInt(256);
            item = item < 0 ? -1*item : item;
            myBuffer.put((byte)item);
        }

        // let's see what are the values of the 4 properties of the buffer i.e -> position, capacity, limit, mark
        printBufferProps(myBuffer);

        // items are put into the buffer let's now flip it and start reading from it
        myBuffer.flip(); // switched to reading mode

        myBuffer.limit(100); // changed the limit to 100
        int c = 0;
        while(myBuffer.hasRemaining()){
            byte b = myBuffer.get();
            System.out.print("item -> ");
            System.out.print(b+"\n");
            c++;
        }
        System.out.println("Item read => "+c);

        myBuffer.compact();

        printBufferProps(myBuffer);
    }

    public static void execute_demo_for_buffer_basics(){
        Buffer buffer = ByteBuffer.allocate(7);
        System.out.println("Capacity: "+ buffer.capacity());
        System.out.println("Limit: "+ buffer.limit());
        System.out.println("Position: "+ buffer.position());
        System.out.println("Remaining: "+ buffer.remaining());
        System.out.println("Changing buffer limit to 5");
        buffer.limit(5);
        System.out.println("Capacity: "+ buffer.capacity());
        System.out.println("Limit: "+ buffer.limit());
        System.out.println("Position: "+ buffer.position());
        System.out.println("Remaining: "+ buffer.remaining());
        System.out.println("Changing buffer limit to 5");
        // will throw an exception if run
        buffer.limit(9);
    }

    private static void printBufferProps(Buffer myBuffer){
        System.out.println("position -> "+myBuffer.position());
        System.out.println("limit -> "+myBuffer.limit());
        System.out.println("mark -> "+myBuffer.mark());
        System.out.println("capacity -> "+myBuffer.capacity());
    }

}
