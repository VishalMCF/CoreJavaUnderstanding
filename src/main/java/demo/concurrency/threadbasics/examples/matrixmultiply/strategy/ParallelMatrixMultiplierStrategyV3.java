package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy;

import java.util.ArrayList;
import java.util.List;
import org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy.model.GroupRowMethod;

public class ParallelMatrixMultiplierStrategyV3 extends AbstractMatrixMultiplierStrategy<Number> {

    List<Thread> threads = new ArrayList<>();

    @Override
    public Number[][] multiply(Number[][] matrixA, Number[][] matrixB)  {
        Number[][] result  = new Number[matrixA.length][matrixB[0].length];
        int startIx = 0;
        int endIx = 0;
        int numberOfCores  = Runtime.getRuntime().availableProcessors();
        int steps = matrixA.length/numberOfCores == 0 ? matrixA.length : matrixA.length/numberOfCores;

        for(int i=0; i<steps; i++){
            endIx = startIx+steps-1;
            Thread t = new Thread(new GroupRowMethod(matrixA, matrixB, result, startIx,endIx));
            t.start();
            threads.add(t);
            startIx = startIx+steps;
        }
        try {
            waitForThreads();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
