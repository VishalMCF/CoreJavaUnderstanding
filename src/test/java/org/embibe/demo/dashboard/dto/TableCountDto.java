package org.embibe.demo.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TableCountDto {
    private String id;
    private String teacherCount;
    private String studentCount;
    private String principalCount;
}
