package org.embibe.demo.dashboard;

import java.util.HashMap;
import java.util.Map;

public class MethodRegister {

    private final Map<String, Map<String, MethodInvokerForDataFetching<?, ?>>> methodStoreForDataFetching;
    private final Map<String, Map<String, MethodInvokerForDataCombining<?, ?, ?, ?>>> methodStoreForDataCombining;

    public MethodRegister(){
        methodStoreForDataFetching = buildMethodStoreForDataFetching();
        methodStoreForDataCombining = buildMethodStoreForDataCombining();
    }

    private Map<String, Map<String, MethodInvokerForDataFetching<?, ?>>> buildMethodStoreForDataFetching() {
        return Map.of("count", new HashMap<>() {{
            put("student", RepositoryBean::studentCountMethod);
            put("principal", RepositoryBean::principalCountMethod);
            put("teacher", RepositoryBean::teacherCountMethod);
        }}, "names", new HashMap<>() {{
            put("student", RepositoryBean::studentNameMethod);
            put("teacher", RepositoryBean::teacherNameMethod);
        }}, "metrics", new HashMap<>() {{
            put("student", RepositoryBean::studentMetricsMethod);
            put("teacher", RepositoryBean::studentMetricsMethod);
        }});
    }

    public Map<String, Map<String, MethodInvokerForDataCombining<?, ?, ?, ?>>> buildMethodStoreForDataCombining(){
        return Map.of("count", new HashMap<>() {{
            put("student", CalculationBean::studentCount);
            put("principal", CalculationBean::teacherCount);
            put("teacher", CalculationBean::principalCount);
        }}, "names", new HashMap<>() {{
            put("student", CalculationBean::studentName);
            put("teacher", CalculationBean::teacherName);
        }}, "metrics", new HashMap<>() {{
            put("student", CalculationBean::studentMetrics);
            put("teacher", CalculationBean::teacherMetrics);
        }});
    }

    public MethodInvokerForDataFetching<?, ?> getMethodExecutorForDataFetching(String purpose, String entity) {
        return methodStoreForDataFetching.get(purpose).get(entity);
    }

    public MethodInvokerForDataCombining<?, ?, ?, ?> getMethodExecutorForDataCombining(String purpose, String entity) {
        return methodStoreForDataCombining.get(purpose).get(entity);
    }

}
