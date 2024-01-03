package org.embibe.demo.concurrency.customlock;

public class MyLockDemo {

    static class SumClass {
        private int sum = 0;

        public void increment(){
            sum++;
        }

        public void printSum(){
            System.out.println("Sum -> "+sum);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final SumClass sumClass = new SumClass();
        MyLock lock = new MyLock();
        Thread a = new Thread(() -> {
            for(int i=0; i< 10000000;i++){
                lock.accessLock();
                sumClass.increment();
                lock.releaseLock();
            }
        });

        Thread b = new Thread(() -> {
            for(int i=0; i< 10000000;i++){
                lock.accessLock();
                sumClass.increment();
                lock.releaseLock();
            }
        });

        Thread c = new Thread(() -> {
            for(int i=0; i< 10000000;i++){
                lock.accessLock();
                sumClass.increment();
                lock.releaseLock();
            }
        });

        a.start();
        b.start();
        c.start();

        a.join();
        b.join();
        c.join();

        sumClass.printSum();

    }

}
