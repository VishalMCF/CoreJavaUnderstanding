package org.embibe.demo.concurrency.synnchronisation.semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
//        try {
//            execute_a_simple_demo_to_print_foo_and_bar_randomly();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        try{
            execute_a_simple_demo_to_print_foo_and_bar_sequentially();
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public static void execute_a_simple_demo_to_print_foo_and_bar_sequentially() throws InterruptedException {
        // we have to print the Foo bar sequentially

        final CountingSemaphore semaphore = new CountingSemaphore(1);

        Thread fooThread = new Thread(() -> {
            for(int i=0;i<100; i++){
                try{
                    semaphore.acquire();
//                    System.out.println("Foo");
                } catch(Exception e){
                    System.out.println("Foo could not acquire semaphore.....");
                }
            }
        });

        Thread barThread = new Thread(() -> {
            for(int i=0;i<100; i++){
                try{
                    semaphore.release();
//                    System.out.println("Bar");
                } catch(Exception e){
                    System.out.println("Bar could not acquire semaphore.....");
                }
            }
        });

        fooThread.start();
        barThread.start();

        fooThread.join();
        barThread.join();

        System.out.println(semaphore.sum);
    }

    public static void execute_a_simple_demo_to_print_foo_and_bar_randomly() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int i=0; i<100; i++){
                try {
                    Thread.sleep(10);
                    System.out.println("Foo");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<100; i++){
                try {
                    Thread.sleep(10);
                    System.out.println("Bar");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
