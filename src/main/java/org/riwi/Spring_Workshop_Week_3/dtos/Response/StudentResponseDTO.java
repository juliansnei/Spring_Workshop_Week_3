package org.riwi.Spring_Workshop_Week_3.dtos.Response;


import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;

import java.util.List;

public class StudentResponseDTO {
    private String name;
    private String cc;
    private String email;
    private List<CourseEntity> courseEntityList;

    public List<CourseEntity> getCourseEntityList() {
        return courseEntityList;
    }

    public void setCourseEntityList(List<CourseEntity> courseEntityList) {
        this.courseEntityList = courseEntityList;
    }

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(String name, String cc, String email) {
        this.name = name;
        this.cc = cc;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentResponseDTO{" +
                "name='" + name + '\'' +
                ", cc='" + cc + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
