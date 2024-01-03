package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy;

import org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.IMatrixMultiplierStrategy;

public abstract class AbstractMatrixMultiplierStrategy<T extends Number> implements IMatrixMultiplierStrategy<Number> {

    protected void validateMatrix(T[][] matrixA, T[][] matrixB) throws ArithmeticException {

        int rowA = matrixA.length;
        int colA = matrixA[0].length;
        int rowB = matrixB.length;
        int colB = matrixB[0].length;

        for(int i=0; i<rowA; i++){
            for(int j=0; j<colA; j++){
                if(matrixA[i][j] == null || matrixA[i][j].getClass().getSuperclass()!= Number.class){
                    throw new ArithmeticException("Invalid input");
                }
            }
        }

        for(int i=0; i<rowB; i++){
            for(int j=0; j<colB; j++){
                if(matrixB[i][j] == null || matrixB[i][j].getClass().getSuperclass()!= Number.class){
                    throw new ArithmeticException("Invalid input");
                }
            }
        }
    }


}
