package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply;

public interface IMatrixMultiplierStrategy<T extends Number> {

    T[][] multiply(T[][] matrixA, T[][] matrixB);
}
