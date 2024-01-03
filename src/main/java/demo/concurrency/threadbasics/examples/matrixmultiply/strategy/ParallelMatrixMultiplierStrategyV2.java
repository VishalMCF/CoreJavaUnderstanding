package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy;

import java.util.ArrayList;
import java.util.List;

public class ParallelMatrixMultiplierStrategyV2<T extends Number> extends AbstractMatrixMultiplierStrategy<Number> {

    List<Thread> threads = new ArrayList<>();
    private static final int MAX_THREADS_AT_TIME = 10;

    @Override
    public Number[][] multiply(Number[][] matrixA, Number[][] matrixB) {
        Number[][] result  = new Number[matrixA.length][matrixB[0].length];
        for(int i=0; i<matrixA.length; i++) {
            int finalI = i;
            int cnt = 1;
            while(cnt <= MAX_THREADS_AT_TIME){
                Thread t = new Thread(() -> {
                    for(int j=0; j<matrixB[0].length;j++){
                        result[finalI][j] = 0.0;
                        for(int k=0; k<matrixA[0].length; k++){
                            result[finalI][j] = result[finalI][j].doubleValue() + matrixA[finalI][k].doubleValue()*matrixB[k][j].doubleValue();
                        }
                    }
                });
                t.start();
                threads.add(t);
                cnt++;
            }
            try {
                waitForThreads();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    private void waitForThreads() throws InterruptedException {
        for(Thread t: threads){
            t.join();
        }
        threads.clear();
    }
}
