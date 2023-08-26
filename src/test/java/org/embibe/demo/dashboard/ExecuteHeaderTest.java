package org.embibe.demo.dashboard;

import java.util.List;
import org.embibe.demo.dashboard.dto.GenericDTO;
import org.embibe.demo.dashboard.dto.MetricsCollector;
import org.embibe.demo.dashboard.dto.RequestWrapper;
import org.junit.jupiter.api.Test;

public class ExecuteHeaderTest {

    @Test
    public void test_preparation_of_object_for_count() {
        MetricsCollector<String ,List<GenericDTO<String, Integer>>, String> metricsCollector = new MetricsCollector<>();
        List<String> ids = List.of("org_id1", "org_id2", "org_id3", "org_id4");
        RequestWrapper<List<String>> requestWrapper  = new RequestWrapper<>(ids);
        MetricsAggregator metricsAggregator = new MetricsAggregator();
        metricsAggregator.buildCountTableDto(metricsCollector, HeaderValues.HEADER_FOR_COUNT_FOR_EACH_ORG, requestWrapper);
        System.out.println(metricsAggregator);
    }

}
