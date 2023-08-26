package org.embibe.demo.dashboard;


import org.embibe.demo.dashboard.dto.MetricsCollector;


@FunctionalInterface
public interface MethodInvokerForDataCombining <T,V,S,ID> {

    void combineMetrics(MetricsCollector<V,S,ID> metricsCollector, T data);

}
