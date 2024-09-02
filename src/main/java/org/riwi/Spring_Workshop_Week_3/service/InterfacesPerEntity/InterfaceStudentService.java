package org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.Disable;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadAll;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadByID;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.Save;

public interface InterfaceStudentService extends
                ReadByID<StudentResponseDTO,Long>,
                ReadAll<StudentResponseDTO>,
                Save<StudentEntity,StudentResponseDTO>,
                Disable<StudentResponseDTO, Long>
    {
}
