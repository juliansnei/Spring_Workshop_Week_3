package org.riwi.Spring_Workshop_Week_3.controllers.ImplementationControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.riwi.Spring_Workshop_Week_3.controllers.InterfacesControllersPerEntity.InterfaceContStudent;
import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.dtos.exception.ErrorsListsResponse;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceStudentService;
import org.riwi.Spring_Workshop_Week_3.service.Mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
@Tag(name = "RiwiAcademy", description = "This is the Student Controller")
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
    @GetMapping
    @Tag(name = "Find All Atudents, filtering the active ones, by name and description")
    @Operation(summary = "This endpoint is up to find students", description = "The endpoint gives you a pageable list of students filter by active state, name, and description")
    @ApiResponse(
            responseCode = "400",
            description = "This error appears when the type attribute is incorrect or when there is no attribute",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorsListsResponse.class)
                    )
            }
    )
    public List<StudentResponseDTO> findPaginated(
            @Valid @RequestParam(required = false, defaultValue = "0") int page,
            @Valid @RequestParam(required = false, defaultValue = "10") int size,
            @Valid @RequestParam(required = false) String name,
            @Valid @RequestParam(required = false) String description) {
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
