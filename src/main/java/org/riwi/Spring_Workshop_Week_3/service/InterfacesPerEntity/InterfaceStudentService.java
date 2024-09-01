package org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadByID;

public interface InterfaceStudentService extends
        ReadByID<StudentResponseDTO,Long>,

        {
}
