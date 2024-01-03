package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy;

public class SerialMatrixMultiplierStrategy extends AbstractMatrixMultiplierStrategy<Number> {

    @Override
    public Number[][] multiply(Number[][] matrixA, Number[][] matrixB) {

        int rowA = matrixA.length;
        int colA = matrixA[0].length;
        int rowB = matrixB.length;
        int colB = matrixB[0].length;

        validateMatrix(matrixA, matrixB);

        Number[][] resultantMatrix = new Double[matrixA.length][matrixB[0].length];

        for(int i=0; i<rowA; i++){
            for(int j=0; j<colB; j++){
                resultantMatrix[i][j] = 0.0;
            }
        }

        for(int i=0; i<rowA; i++){
            for(int j=0; j<colB; j++){
                for(int k=0; k<colA; k++){
                    resultantMatrix[i][j] = resultantMatrix[i][j].doubleValue() + matrixA[i][k].doubleValue()*matrixB[k][j].doubleValue();
                }
            }
        }

        return resultantMatrix;
    }
}
