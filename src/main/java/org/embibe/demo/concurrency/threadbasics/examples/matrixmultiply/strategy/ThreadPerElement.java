package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy;

public class ThreadPerElement implements Runnable {

    private final Number[][] matrix1;
    private final Number[][] matrix2;

    private final Number[][] result;

    private final int row;
    private final int col;

    public ThreadPerElement(Number[][] matrix1, Number[][] matrix2,
        Number[][] result, int row, int col) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.row = row;
        this.col = col;
    }

    public void run() {
        result[row][col] = 0.0;
        for (int i = 0; i < matrix1[0].length; i++) {
            result[row][col] = result[row][col].doubleValue() + matrix1[row][i].doubleValue() * matrix2[i][col].doubleValue();
        }
    }

}
