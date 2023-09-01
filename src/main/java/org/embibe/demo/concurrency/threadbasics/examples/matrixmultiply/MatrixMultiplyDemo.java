package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply;

import java.util.Arrays;

public class MatrixMultiplyDemo {


    public static void main(String[] args) {
        Integer[][] matrixA = new Integer[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        Integer[][] matrixB = new Integer[][]{{5,4,3},{2,1,10},{10,9,8},{7,6,15},{15,14,13}};
        MatrixMultiplierRegister matrixMultiplierRegister = new MatrixMultiplierRegister();
        Double[][] result = (Double[][]) matrixMultiplierRegister.getMatrixMultiplierAlgorithm("serialVersion").multiply(matrixA, matrixB);
        System.out.println(Arrays.deepToString(result));
    }

}
