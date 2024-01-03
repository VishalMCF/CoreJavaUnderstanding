package org.embibe.demo.concurrency.threadbasics.custom;

public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread created by extending runnable interface -> "+Thread.currentThread().getName());
    }
}
