package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy;

import java.util.ArrayList;
import java.util.List;
import org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy.model.ThreadPerElement;

public class ParallelMatrixMultiplierStrategyV1 extends AbstractMatrixMultiplierStrategy<Number> {

    List<Thread> threads = new ArrayList<>();
    private static int totalThreads = 10;


    @Override
    public Number[][] multiply(Number[][] matrixA, Number[][] matrixB) {
        Number[][] result  = new Number[matrixA.length][matrixB[0].length];
        int cnt =1;
        for(int i=0; i<matrixA.length; i++) {
            for(int j=0; j<matrixB[0].length; j++) {
                while(cnt % totalThreads != 0) {
                    cnt++;
                    Thread thread  = new Thread(new ThreadPerElement(matrixA, matrixB, result, i, j));
                    thread.start();
                    threads.add(thread);
                }
                try {
                    waitForThreads();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cnt = 1;
            }
        }
        return result;
    }

    private void waitForThreads() throws InterruptedException {
        for(Thread thread: threads){
            thread.join();
        }
        threads.clear();
    }


}
