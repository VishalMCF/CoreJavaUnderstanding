package org.embibe.demo.dashboard;


import java.util.List;
import org.embibe.demo.dashboard.dto.GenericDTO;
import org.embibe.demo.dashboard.dto.MetricsCollector;
import org.embibe.demo.dashboard.dto.TableCountDto;

public class CalculationBean {

    public static <V> void teacherName(MetricsCollector<?,?,?> metricsCollector, V data) {

    }

    public static <V> void studentName(MetricsCollector<?,?,?> metricsCollector, V data) {

    }

    public static <V> void studentMetrics(MetricsCollector<?,?,?> metricsCollector, V data) {

    }

    public static <V> void teacherMetrics(MetricsCollector<?,?,?> metricsCollector, V data) {

    }

    public static <V> void studentCount(MetricsCollector<?,?,?> metricsCollector, V data) {
        List<TableCountDto> tableCountDTOList = (List<TableCountDto>)data;
        List<GenericDTO<String,Integer>> embeddedDataFetchedFromDb = (List<GenericDTO<String,Integer>>)metricsCollector
            .getMetricsStore().get("student");
        for(TableCountDto tableCountDto: tableCountDTOList){
            for(GenericDTO<String,Integer> genericDTO: embeddedDataFetchedFromDb){
                if(tableCountDto.getId().equals(genericDTO.getId())){
                    tableCountDto.setTeacherCount(String.valueOf((int)genericDTO.getData()));
                }
            }
        }
    }

    public static <V> void teacherCount(MetricsCollector<?,?,?> metricsCollector, V data) {
        List<TableCountDto> tableCountDTOList = (List<TableCountDto>)data;
        List<GenericDTO<String,Integer>> embeddedDataFetchedFromDb = (List<GenericDTO<String,Integer>>)metricsCollector
            .getMetricsStore().get("teacher");
        for(TableCountDto tableCountDto: tableCountDTOList){
            for(GenericDTO<String,Integer> genericDTO: embeddedDataFetchedFromDb){
                if(tableCountDto.getId().equals(genericDTO.getId())){
                    tableCountDto.setStudentCount(String.valueOf((int)genericDTO.getData()));
                }
            }
        }
    }

    public static <V> void principalCount(MetricsCollector<?,?,?> metricsCollector, V data) {
        List<TableCountDto> tableCountDTOList = (List<TableCountDto>)data;
        List<GenericDTO<String,Integer>> embeddedDataFetchedFromDb = (List<GenericDTO<String,Integer>>)metricsCollector
            .getMetricsStore().get("student");
        for(TableCountDto tableCountDto: tableCountDTOList) {
            for(GenericDTO<String,Integer> genericDTO: embeddedDataFetchedFromDb) {
                if(tableCountDto.getId().equals(genericDTO.getId())) {
                    tableCountDto.setPrincipalCount(String.valueOf((int)genericDTO.getData()));
                }
            }
        }
    }
}
