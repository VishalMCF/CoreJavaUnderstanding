package org.embibe.demo.dashboard;


import java.util.List;
import org.embibe.demo.dashboard.dto.GenericDTO;
import org.embibe.demo.dashboard.dto.MetricsDTO;
import org.embibe.demo.dashboard.dto.RequestDTO;
import org.embibe.demo.dashboard.dto.RequestWrapper;

public class RepositoryBean {

    public static <T> List<GenericDTO<String, Integer>> studentCountMethod(RequestWrapper<T> request) {
        List<String> ids = (List<String>) request.getRequestDto();
        System.out.println("request recieved -> "+ids);
        return List.of(new GenericDTO<>("org_id1",100), new GenericDTO<>("org_id2",200),
            new GenericDTO<>("org_id3",300), new GenericDTO<>("org_id4", 400));
    }

    public static <T> List<GenericDTO<String, Integer>> teacherCountMethod(RequestWrapper<T> request) {
        List<String> ids = (List<String>) request.getRequestDto();
        System.out.println("request recieved -> "+ids);
        return List.of(new GenericDTO<>("org_id1",10), new GenericDTO<>("org_id2",20),
            new GenericDTO<>("org_id3",40), new GenericDTO<>("org_id4", 50));
    }

    public static <T> List<GenericDTO<String, Integer>> principalCountMethod(RequestWrapper<T> request) {
        List<String> ids = (List<String>) request.getRequestDto();
        System.out.println("request recieved -> "+ids);
        return List.of(new GenericDTO<>("org_id1",1), new GenericDTO<>("org_id2",2),
            new GenericDTO<>("org_id3",4), new GenericDTO<>("org_id4", 5));
    }

    public static <T> List<GenericDTO<String, Integer>> donorCountMethod(RequestWrapper<T> request) {
        List<String> ids = (List<String>) request.getRequestDto();
        System.out.println("request recieved -> "+ids);
        return List.of(new GenericDTO<>("org_id1",10), new GenericDTO<>("org_id2",10),
            new GenericDTO<>("org_id3",10), new GenericDTO<>("org_id4", 10));
    }

    public static <T> List<GenericDTO<String, String>> studentNameMethod(RequestWrapper<T> request) {
        return List.of(new GenericDTO<>("student_id1","student_name_1"),
            new GenericDTO<>("student_id2","student_name_2"),
            new GenericDTO<>("student_id3", "student_name_3"),
            new GenericDTO<>("student_id4", "student_name_4"));
    }

    public static <T> List<GenericDTO<String, String>> teacherNameMethod(RequestWrapper<T> request) {
        return List.of(new GenericDTO<>("teacher_id1","teacher_name_1"),
            new GenericDTO<>("teacher_id2","teacher_name_2"),
            new GenericDTO<>("teacher_id3", "teacher_name_3"),
            new GenericDTO<>("teacher_id4", "teacher_name_4"));
    }

    public static <T> List<GenericDTO<String, MetricsDTO>> studentMetricsMethod(RequestWrapper<T> request) {
        return List.of(
            new GenericDTO<>("student_id1",
                new MetricsDTO(12,30)),
            new GenericDTO<>("student_id2",
                new MetricsDTO(14,40)),
            new GenericDTO<>("student_id3",
                new MetricsDTO(16,20)),
            new GenericDTO<>("student_id4",
                new MetricsDTO(18,50)));
    }

    public static <T> List<GenericDTO<String, MetricsDTO>> teacherMetricsMethod(RequestWrapper<T> request) {
        return List.of(
            new GenericDTO<>("teacher_id1",
                new MetricsDTO(32,90)),
            new GenericDTO<>("teacher_id2",
                new MetricsDTO(42,50)),
            new GenericDTO<>("teacher_id3",
                new MetricsDTO(54,80)),
            new GenericDTO<>("teacher_id4",
                new MetricsDTO(62,70)));
    }
}
