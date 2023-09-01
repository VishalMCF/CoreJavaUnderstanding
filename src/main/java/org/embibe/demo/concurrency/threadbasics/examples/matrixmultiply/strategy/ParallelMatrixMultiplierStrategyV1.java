package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy;

public class ParallelMatrixMultiplierStrategyV1<T extends Number> extends AbstractMatrixMultiplierStrategy<Number> {


    @Override
    public Number[][] multiply(Number[][] matrixA, Number[][] matrixB) {
        return new Number[0][];
    }
}
