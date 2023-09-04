package org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply;

import java.util.HashMap;
import java.util.Map;
import org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy.ParallelMatrixMultiplierStrategyV1;
import org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy.ParallelMatrixMultiplierStrategyV2;
import org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy.ParallelMatrixMultiplierStrategyV3;
import org.embibe.demo.concurrency.threadbasics.examples.matrixmultiply.strategy.SerialMatrixMultiplierStrategy;

public class MatrixMultiplierRegister {

    Map<String, IMatrixMultiplierStrategy> map = new HashMap<>();

    public MatrixMultiplierRegister() {
        map.put("serialVersion", new SerialMatrixMultiplierStrategy());
        map.put("parallelV1", new ParallelMatrixMultiplierStrategyV1());
        map.put("parallelV2", new ParallelMatrixMultiplierStrategyV2());
        map.put("parallelV3", new ParallelMatrixMultiplierStrategyV3());
    }

    public IMatrixMultiplierStrategy getMatrixMultiplierAlgorithm(String strategy){
        return map.get(strategy);
    }
}
