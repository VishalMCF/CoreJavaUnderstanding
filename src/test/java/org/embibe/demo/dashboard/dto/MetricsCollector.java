package org.embibe.demo.dashboard.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class MetricsCollector <T, V, ID > {

    private Map<T,V> metricsStore = new HashMap<>();
    private List<ID> idList = new ArrayList<>();

    public void addData(T key, V data) {
        metricsStore.put(key, data);
    }

    public void fetchData(T key){
        metricsStore.get(key);
    }
}
