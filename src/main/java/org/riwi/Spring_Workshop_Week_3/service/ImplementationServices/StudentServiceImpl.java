package org.riwi.Spring_Workshop_Week_3.service.ImplementationServices;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.riwi.Spring_Workshop_Week_3.repository.Interfaces.StudentRepository;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements InterfaceStudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public StudentResponseDTO update(Long id, StudentResponseDTO studentResponseDTO) {
        return null;
    }

    @Override
    public List<StudentResponseDTO> readAll() {
        return List.of();
    }

    @Override
    public StudentResponseDTO readById(Long id) {

        StudentEntity student = studentRepository.findById(id).orElse(null);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setCc(student.getCc());
        studentResponseDTO.setEmail(student.getEmail());
        return studentResponseDTO;
    }


    @Override
    public StudentEntity save(StudentResponseDTO entity) {
        return null;
    }
}
