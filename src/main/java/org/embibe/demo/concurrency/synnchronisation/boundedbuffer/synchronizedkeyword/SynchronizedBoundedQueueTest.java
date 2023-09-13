package org.embibe.demo.concurrency.synnchronisation.boundedbuffer.synchronizedkeyword;

import org.embibe.demo.concurrency.synnchronisation.boundedbuffer.BoundedQueue;

public class SynchronizedBoundedQueueTest {


    public static void main(String[] args) throws InterruptedException {

        BoundedQueue<Integer> boundedQueue = new SynchronizedBoundedQueue<>(5);

        Thread producerA = new Thread(() -> {
            Thread.currentThread().setName("Producer-A");
            for(int i=0; i<196; i++){
                try {
                    Thread.sleep(20);
                    boundedQueue.enqueue((i+1));
                    System.out.println(Thread.currentThread().getName()+" added "+(i+1)+" in the queue");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread producerB = new Thread(() -> {
            Thread.currentThread().setName("Producer-B");
            for(int i=196; i<201+196; i++){
                try {
                    Thread.sleep(10);
                    boundedQueue.enqueue((i+1));
                    System.out.println(Thread.currentThread().getName()+" added "+(i+1)+" in the queue");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerA = new Thread(() -> {
            Thread.currentThread().setName("Consumer-A");
            for(int i=0; i<106; i++){
                try {
                    Thread.sleep(40);
                    Integer item = boundedQueue.deque();
                    System.out.println(Thread.currentThread().getName()+" removed "+item+" from the queue");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerB = new Thread(() -> {
            Thread.currentThread().setName("Consumer-B");
            for(int i=0; i<291; i++){
                try {
                    Thread.sleep(30);
                    Integer item = boundedQueue.deque();
                    System.out.println(Thread.currentThread().getName()+" removed "+item+" from the queue");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerA.start();
        producerB.start();
        consumerA.start();
        consumerB.start();
        producerA.join();
        producerB.join();
        consumerA.join();
        consumerB.join();
        System.out.println(boundedQueue.getSize());
    }

}
