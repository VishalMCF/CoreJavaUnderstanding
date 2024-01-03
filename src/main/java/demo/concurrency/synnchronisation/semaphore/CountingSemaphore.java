package org.embibe.demo.concurrency.synnchronisation.semaphore;

public class CountingSemaphore {

    int usedPermits = 0; // permits given out
    int maxCount; // max permits to give out

    public int sum = 0;

    public CountingSemaphore(int count) {
        this.maxCount = count;
    }

    public synchronized void acquire() throws InterruptedException {
        while (usedPermits == maxCount) {
            wait();
        }
        sum++;
        usedPermits++;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (usedPermits == 0) {
            wait();
        }
        usedPermits--;
        sum--;
        notify();
    }
}
