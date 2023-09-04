package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy.model;

public class GroupRowMethod implements Runnable{

    private final Number[][] matrix1;
    private final Number[][] matrix2;

    private final Number[][] result;

    private final int startIndex;
    private final int endIndex;

    public GroupRowMethod(Number[][] matrix1, Number[][] matrix2,
        Number[][] result, int startIndex, int endIndex) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void run() {
        for(int i=startIndex; i<=endIndex; i++){
            for(int j=0; j<matrix2[0].length; j++){
                result[i][j] = 0.0;
                for(int k=0; k<matrix1[0].length; k++){
                    result[i][j] = result[i][j].doubleValue() + matrix1[i][k].doubleValue()*matrix2[k][j].doubleValue();
                }
            }
        }
    }
}
