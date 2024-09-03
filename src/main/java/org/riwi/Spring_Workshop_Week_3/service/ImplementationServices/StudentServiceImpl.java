package org.riwi.Spring_Workshop_Week_3.service.ImplementationServices;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.riwi.Spring_Workshop_Week_3.repository.Interfaces.StudentRepository;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceStudentService;
import org.riwi.Spring_Workshop_Week_3.service.Mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements InterfaceStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentResponseDTO update(Long id, StudentResponseDTO studentResponseDTO) {
        return null;
    }

    @Override
    public Page<StudentEntity> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<StudentEntity> TolistActiveStudents(List<StudentEntity> listStudents) {
        return listStudents
                .stream()
                .filter(StudentEntity::isActive)
                .collect(Collectors.toList());
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

    @Override
    public List<StudentResponseDTO> readAll() {
        return List.of();
    }

    @Override
    public List<StudentEntity> TolistStudentsByName(String name, List<StudentEntity> listOfStudents) {
        return  listOfStudents.stream()
                .filter(studentEntity -> studentEntity.getName()
                        .equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentEntity> TolistStudentsByDescription(String description, List<StudentEntity> listOfStudents) {
        return listOfStudents.stream()
                .filter(studentEntity -> studentEntity.getAddress()
                        .equals(description))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentEntity> checkRequestParams(List<StudentEntity> listActiveStudents, String name, String description) {
        if(name != null && !name.isEmpty()){
            List<StudentEntity> ListOfStudentsByName =  TolistStudentsByName(name,listActiveStudents);
            if(description != null && !description.isEmpty()){
                List<StudentEntity> ListOfStudentsByDescription = TolistStudentsByDescription(description,ListOfStudentsByName);
                return ListOfStudentsByDescription;
            } else {
                return ListOfStudentsByName;
            }
        } else if(description != null && !description.isEmpty()){
            List<StudentEntity> ListOfStudentsByDescription = TolistStudentsByDescription(description,listActiveStudents);
            return  ListOfStudentsByDescription;
        } else {
            return  listActiveStudents;
        }
    }
}
