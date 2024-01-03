package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply;

import java.util.Arrays;

public class MatrixMultiplyDemo {

    private static final String SERIAL_VERSION    = "serialVersion";
    private static final String PARALLEL_VERSION1 = "parallelV1";
    private static final String PARALLEL_VERSION2 = "parallelV2";
    private static final String PARALLEL_VERSION3 = "parallelV3";

    public static void main(String[] args) {
        Integer[][] matrixA = new Integer[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        Integer[][] matrixB = new Integer[][]{{5,4,3},{2,1,10},{10,9,8},{7,6,15},{15,14,13}};
        MatrixMultiplierRegister matrixMultiplierRegister = new MatrixMultiplierRegister();
        Number[][] result = matrixMultiplierRegister.getMatrixMultiplierAlgorithm(PARALLEL_VERSION3).multiply(matrixA, matrixB);
        printMatrix(result);
    }

    public static void printMatrix(Number[][] resultantMatrix){
        for (int i=0;i<resultantMatrix.length;i++){
            for (int j=0;j<resultantMatrix[0].length;j++){
                System.out.print(resultantMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
