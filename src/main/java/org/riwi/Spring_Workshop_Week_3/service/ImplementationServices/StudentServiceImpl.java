package org.riwi.Spring_Workshop_Week_3.service.ImplementationServices;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
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



        return null;
    }

    @Override
    public StudentResponseDTO save(StudentResponseDTO studentResponseDTO) {
        return null;
    }
}
