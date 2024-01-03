package org.embibe.demo.concurrency.synnchronisation.boundedbuffer;

public interface BoundedQueue<T> {

    void enqueue(T item) throws InterruptedException;

    T deque() throws InterruptedException;

    int getSize();
}
