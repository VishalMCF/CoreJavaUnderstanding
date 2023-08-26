package org.embibe.demo.dashboard;


import org.embibe.demo.dashboard.dto.RequestWrapper;

@FunctionalInterface
public interface MethodInvokerForDataFetching<T, V> {

    public T collectMetrics(RequestWrapper<V> requestDTO);

}
