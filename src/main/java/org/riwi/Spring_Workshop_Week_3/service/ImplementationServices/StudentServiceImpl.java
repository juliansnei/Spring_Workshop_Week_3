
package org.riwi.Spring_Workshop_Week_3.service.ImplementationServices;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.riwi.Spring_Workshop_Week_3.repository.Interfaces.StudentRepository;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
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
    public List<StudentEntity> findPaginated(int pageNo, int pageSize, String name, String description) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<StudentEntity> listAllStudents = studentRepository.findAll();
        List<StudentEntity> listActiveStudents  = TolistActiveStudents(listAllStudents);
        List<StudentEntity> listStudentsWithParams  = checkRequestParams(listActiveStudents, name, description);
        System.out.println(listStudentsWithParams);
        return toPageAList(listStudentsWithParams, pageable);
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

    @Override
    public List<StudentEntity> toPageAList(List<StudentEntity> list, Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        int startIndex = pageNumber * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());
        System.out.println(list.subList(startIndex, endIndex));
        return list.subList(startIndex, endIndex);
    }
}

