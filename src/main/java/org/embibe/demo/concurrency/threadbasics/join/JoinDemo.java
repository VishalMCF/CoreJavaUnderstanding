package org.embibe.demo.concurrency.threadbasics.join;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        execute_join_demo(); // until and unless t1 and t2 doesn't end main thread will not receive CPU resource
    }

    public static void execute_join_demo() throws InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i=0; i<1000;i++){
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("For loop ended :-> "+Thread.currentThread().getName());
        });

        Thread t2 = new Thread(()-> {
            for (int i=0; i<1000; i++){
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("For loop ended :-> "+Thread.currentThread().getName());
        });

        t2.start();
        t2.join();
        t1.start();
        t1.join();
        System.out.println("Main thread doesn't seem to work anymore");
    }

}
