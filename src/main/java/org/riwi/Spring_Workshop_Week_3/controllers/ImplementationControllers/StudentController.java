package org.riwi.Spring_Workshop_Week_3.controllers.ImplementationControllers;

import org.riwi.Spring_Workshop_Week_3.controllers.InterfacesControllersPerEntity.InterfaceContStudent;
import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceStudentService;
import org.riwi.Spring_Workshop_Week_3.service.Mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController implements InterfaceContStudent {

    @Autowired
    private InterfaceStudentService studentService;
    private StudentMapper studentMapper = new StudentMapper();

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
    @GetMapping("/api/v1/students")
    public List<StudentResponseDTO> findPaginated(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description) {
        try {
            List<StudentEntity> listStudents = studentService.findPaginated(page,size,name,description);
            System.out.println(listStudents);
            return listStudents
                    .stream()
                    .map(studentMapper::toStudentResponseDTO)
                    .collect(Collectors.toList());

        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public StudentEntity save(StudentResponseDTO entity) {
        return null;
    }
}
