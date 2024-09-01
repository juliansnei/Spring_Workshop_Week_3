package org.riwi.Spring_Workshop_Week_3.dtos.Response;

import lombok.Data;

import java.util.List;

@Data
public class CourseResponseDTO {

    private Long id;
    private String name;
    private List<Long> studentIds;
    private List<Long> lessonIds;
}