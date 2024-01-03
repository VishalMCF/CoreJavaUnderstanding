package demo.newio.buffer.basic;

import java.nio.*;
import java.util.Random;

// There are 3 ways to create non-direct byte buffers
// 1. using allocate(int capacity) method
// 2. using an existing byte array as the backing array for the buffer using wrap(byte[] array)
// 3. using wrap(byte[] array, int offset, int limit)


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
        for(int i=0; i<1000; i++) {
            int item = rand.nextInt(256);
            item = item < 0 ? -1*item : item;
            myBuffer.put((byte)item);
        }

        // items are put into the buffer let's now flip it and start reading from it
        myBuffer.flip(); // switched to reading mode

        myBuffer.limit(100); // changed the limit to 100
        int c = 0;
        while(myBuffer.hasRemaining()){
            byte b = myBuffer.get();
//            System.out.print("item -> ");
//            System.out.print(b+"\n");
            c++;
        }
        System.out.println("Item read => "+c);
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

}
