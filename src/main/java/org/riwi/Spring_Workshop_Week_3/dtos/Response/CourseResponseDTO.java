package org.riwi.Spring_Workshop_Week_3.dtos.Response;

import org.riwi.Spring_Workshop_Week_3.entities.LessonEntity;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;

import java.util.List;

public class CourseResponseDTO {
    private String name;
    private List<LessonEntity> lessonList;
    private List<StudentEntity> StudentList;
}
