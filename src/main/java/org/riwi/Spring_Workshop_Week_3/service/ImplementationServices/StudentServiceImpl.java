package org.riwi.Spring_Workshop_Week_3.service.ImplementationServices;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceStudentService;

import java.util.List;

public class StudentServiceImpl implements InterfaceStudentService {
    @Override
    public StudentResponseDTO update(Long aLong, StudentResponseDTO studentResponseDTO) {
        return null;
    }

    @Override
    public List<StudentResponseDTO> readAll() {
        return List.of();
    }

    @Override
    public StudentResponseDTO readById(Long aLong) {
        return null;
    }

    @Override
    public StudentResponseDTO save(StudentResponseDTO studentResponseDTO) {
        return null;
    }
}
