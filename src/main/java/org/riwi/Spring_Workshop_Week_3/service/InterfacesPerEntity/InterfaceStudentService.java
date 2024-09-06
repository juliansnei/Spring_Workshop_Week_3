package org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.Disable;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadAll;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadByID;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.Save;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InterfaceStudentService extends
                ReadByID<StudentResponseDTO,Long>,
                ReadAll<StudentResponseDTO>,
                Save<StudentEntity,StudentResponseDTO>,
                Disable<StudentResponseDTO, Long>
    {
        List<StudentEntity> findPaginated(int pageNo, int pageSize, String name, String description);
        List<StudentEntity> TolistActiveStudents(List<StudentEntity> listStudents);
        List<StudentEntity>  TolistStudentsByName(String name, List<StudentEntity> listOfStudents);
        List<StudentEntity>  TolistStudentsByDescription(String description, List<StudentEntity> listOfStudents);
        List<StudentEntity> checkRequestParams(List<StudentEntity> listActiveStudents, String name, String description);
        List<StudentEntity> toPageAList(List<StudentEntity> list, Pageable pageable);

    }
