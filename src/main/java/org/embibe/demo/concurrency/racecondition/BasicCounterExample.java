package org.embibe.demo.concurrency.racecondition;

public class BasicCounterExample {

    public static void main(String[] args) {
        execute_multiple_threads_to_demonstrate_race_condition();
    }

    /**
     * The following method demonstrates how the CPU executes the thread using the time slicing algorithm
     * where each thread gets to execute the printCounter() for some random amount of time
     */
    private static void execute_multiple_threads_to_demonstrate_race_condition() {
        Thread t1 = new Thread(BasicCounterExample::printCounter);
        Thread t2 = new Thread(BasicCounterExample::printCounter);

        t1.start();
        t2.start();
    }

    /**
     * In the below method we have written the logic to increment a counter
     * and print the name of the thread which is executing the method
     */
    private static void printCounter(){
        for(int i=0; i<100; i++){
            System.out.println("Name => "+Thread.currentThread().getName()
                +" ||  current count is i -> "+i+" ");
        }
    }
}
