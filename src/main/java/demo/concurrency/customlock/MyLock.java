package org.embibe.demo.concurrency.customlock;

public class MyLock {

    // this is the reference to the thread which has acquired the lock
    private Thread currentThread;

    // how many times a thread has acquired the lock
    private int acquiredCount;

    /**
     * How does a thread acquire MyLock instance? For that it needs to call getAccess() method. Until the access is not granted the thread will go
     * into the waiting state on the current lock instance When the thread is woken up from the waiting state it will again try to get access to the
     * lock It uses a tryGetAccess() private method.
     */

    public synchronized void accessLock() {
        while (!tryGetAccess()) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
    }


    /**
     * When the thread tries to get access to the lock this method will be called internally
     * <p>
     * First the method will try to match who has currently occupied the lock. If the same thread has occupied the lock then it will increment the
     * occupied count parameter and will return true.
     * <p>
     * if the lock has not been acquired by any thread then the thread which is executing the getAccess() method will be assigned to currentThread
     * variable, and it will increment the acquiredCount and will return true
     * <p>
     * if the lock has been occupied by some other thread then it will return false
     *
     * @return
     */
    private synchronized boolean tryGetAccess() {
        if (currentThread == Thread.currentThread()) {
            acquiredCount++;
            return true;
        } else if (currentThread == null) {
            currentThread = Thread.currentThread();
            acquiredCount++;
            return true;
        }
        return false;
    }

    /**
     * During release lock first the thread which is trying to execute the method needs to be matched if that is the case then the acquireCount should
     * be reduced.
     * <p>
     * If the value of acquireCount becomes equal to 0 then the currentThread should be made equal to null and the other thread should be notified.
     * The reason is because we are allowing a thread to acquire lock any number of times and release lock as equal to the number of times it has
     * acquired.
     * <p>
     * But at one time only one thread must acquire lock. For example this scenario could be possible:- Thread A acquired lock 3 times and released 2
     * times and Thread B acquired 0 times and released 0 times But this scenario will never be possible:- Thread A acquired 4 times and relaease 2
     * times and Thread B acquired 3 times and release 0 times
     */

    public synchronized void releaseLock() {
        if (currentThread == Thread.currentThread()) {
            acquiredCount--;
            if(acquiredCount==0){
                currentThread = null;
                notifyAll();
            }
        }
    }
}
