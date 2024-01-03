package org.embibe.demo.newio.buffer;

import java.nio.*;

public class BufferDemo {

    public static void main(String[] args) {
        execute_demo_for_buffer_basics();
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
        buffer.limit(9);
    }

}
