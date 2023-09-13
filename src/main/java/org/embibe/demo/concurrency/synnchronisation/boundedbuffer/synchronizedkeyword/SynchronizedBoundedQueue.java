package org.embibe.demo.concurrency.synnchronisation.boundedbuffer.synchronizedkeyword;

import java.util.LinkedList;
import java.util.List;
import org.embibe.demo.concurrency.synnchronisation.boundedbuffer.BoundedQueue;

public class SynchronizedBoundedQueue<T> implements BoundedQueue<T> {

    private final List<T> queue;
    private final int capacity;

    public SynchronizedBoundedQueue(int size) {
        this.queue = new LinkedList<>();
        this.capacity = size;
    }

    /**
     * enqueue() function should only add item T in the queue when the size of the queue is less than the maximum capacity
     * passed into the constructor. Which ever thread is executing this method must gets blocked until the size of the
     * queue is less than the capacity mentioned.
     * The method uses the synchronized keyword because it checks the size of the queue. The size of the queue must be
     * the most updated value as it is a critical section because other threads might be manipulating the queue by adding or
     * removing the elements.
     * The checking of the size by the consumer must happen in a while loop
     * If the predicate inside the while loop is false then the thread must be transferred to the wait set of the queue object
     * when the predicate inside the where loop becomes true then the thread can proceed to enqueue an item.
     * After doing its job i.e. enqueuing an item the producer thread must also notify all the threads which are present inside
     * the waiting set of the queue.
     */
    @Override
    public synchronized void enqueue(T item) throws InterruptedException {
        while(queue.size() == capacity) {
            wait();
        }
        queue.add(item);
        notifyAll();
    }

    /**
     * dequeue() function should only remove item T when there is no element in the queue. Which is obvious
     * all the consumer thread must gets blocked until there is any item present in the queue
     * the method uses synchronized keyword because queue object inside the class is a critical section and any read or
     * write must be protected.
     * After removing any item from the queue it must notify all the threads waiting in the wait set.
     */
    @Override
    public synchronized T deque() throws InterruptedException {
        T item = null;
        while(queue.size()==0){
            wait();
        }
        item = queue.remove(0);
        notifyAll();
        return item;
    }

    @Override
    public int getSize(){
        return this.queue.size();
    }
}
