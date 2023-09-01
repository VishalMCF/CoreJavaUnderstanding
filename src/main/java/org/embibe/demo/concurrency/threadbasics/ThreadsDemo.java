package org.embibe.demo.concurrency.threadbasics;

import org.embibe.demo.concurrency.threadbasics.custom.MyThread;

public class ThreadsDemo {

    public static void main(String[] args) {
        System.out.println("Main Thread executing -> "+Thread.currentThread().getName());
        execute_demo_for_thread_creation_using_implementation_of_runnable_interface();
        execute_demo_for_thread_creation_without_implementation_of_runnable_interface();
    }

    /**
     * Number of ways to create a thread:-
     * 1. Extending the Runnable interface and using Thread class constructor to create threads
     * 2. Directly extending the Thread class
     */

    public static void execute_demo_for_thread_creation_using_implementation_of_runnable_interface() {
        Thread newThread = new Thread(new MyThread());
        newThread.start();
    }

    public static void execute_demo_for_thread_creation_without_implementation_of_runnable_interface() {
        Thread newThread = new Thread(()-> System.out.println("Thread Created using lambdas "+Thread.currentThread().getName()));
        newThread.start();
    }

}

