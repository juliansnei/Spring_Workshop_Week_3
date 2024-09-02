package org.riwi.Spring_Workshop_Week_3.controllers.ImplementationControllers;

import org.riwi.Spring_Workshop_Week_3.controllers.InterfacesControllersPerEntity.InterfaceContStudent;
import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudentController implements InterfaceContStudent {

    @Autowired
    private InterfaceStudentService studentService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> readById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.readById(id));
    }

    @Override
    public StudentResponseDTO update(Long aLong, StudentResponseDTO studentResponseDTO) {
        return null;
    }

    @Override
    public List<StudentResponseDTO> readAll() {
        return List.of();
    }

    @Override
    public StudentEntity save(StudentResponseDTO entity) {
        return null;
    }
}
