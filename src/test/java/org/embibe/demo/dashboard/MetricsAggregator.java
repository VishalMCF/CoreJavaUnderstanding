package org.embibe.demo.dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.embibe.demo.dashboard.dto.MetricsCollector;
import org.embibe.demo.dashboard.dto.RequestWrapper;
import org.embibe.demo.dashboard.dto.TableCountDto;

public class MetricsAggregator {

    public <T, V, U, ID> void buildCountTableDto(MetricsCollector<T, V, ID> metricsCollector, List<String> headers,
        RequestWrapper<U> request) {
        MethodRegister methodRegister = new MethodRegister();
        Map<String, V> dataMapAgainstHeader = (Map<String, V>) metricsCollector.getMetricsStore();
        headers.forEach((header) -> {
            MethodInvokerForDataFetching<?, U> selectedMethod = (MethodInvokerForDataFetching<?, U>) methodRegister.getMethodExecutorForDataFetching("count", header);
            V data = (V) selectedMethod.collectMetrics(request);
            dataMapAgainstHeader.put(header, data);
        });
        System.out.println(dataMapAgainstHeader);
        List<TableCountDto> tableCountDtoList = new ArrayList<>();
        List<String> ids = List.of("org_id1","org_id2","org_id3","org_id4");
        ids.forEach((id) -> {
            TableCountDto tableCountDto  = new TableCountDto();
            tableCountDto.setId(id);
            tableCountDtoList.add(tableCountDto);
        });
        headers.forEach((header) -> {
            MethodInvokerForDataCombining<U,T,V,ID> selectedMethod = (MethodInvokerForDataCombining<U,T,V,ID>) methodRegister.getMethodExecutorForDataCombining("count", header);
            selectedMethod.combineMetrics(metricsCollector, (U) tableCountDtoList);
        });
        System.out.println(tableCountDtoList);
    }

}
