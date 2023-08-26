package org.embibe.demo.reactor.udemycourse.sec01;

import java.util.stream.Stream;

public class StreamBehaviour {

    public static void main(String[] args) {
        stream_lazy_behaviour_introduction_with_no_terminal_operation();
        stream_lazy_behaviour_introduction_with_terminal_operation();
    }

    /**
     *
     */
    private static void stream_lazy_behaviour_introduction_with_no_terminal_operation(){
        Stream<String> stream = Stream.of(1,2,3,4,5,6,7,8,9).map((i) -> {
            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Current number is : "+i;
        });

        // streams dont get executed until anny terminal operation are not attached
        System.out.println(stream);
    }

    /**
     *
     */
    private static void stream_lazy_behaviour_introduction_with_terminal_operation(){
        Stream<String> stream = Stream.of(1,2,3,4,5,6,7,8,9).map((i) -> {
            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Current number is : "+i;
        });

        // streams dont get executed until anny terminal operation are not attached
        // here the streams will be executed because forEach is a terminal operation
        stream.forEach(System.out::println);
    }
}
