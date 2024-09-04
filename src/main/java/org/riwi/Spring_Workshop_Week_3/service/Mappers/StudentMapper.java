package org.riwi.Spring_Workshop_Week_3.service.Mappers;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentResponseDTO toStudentResponseDTO(StudentEntity studentEntity){
        StudentResponseDTO student = new StudentResponseDTO();
        student.setCc(studentEntity.getCc());
        student.setName(studentEntity.getName());
        student.setEmail(studentEntity.getEmail());
        student.setCourseEntityList(studentEntity.getCourseEntityList());
        return student;
    }
}
