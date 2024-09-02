package org.riwi.Spring_Workshop_Week_3.controllers.InterfacesControllersPerEntity;

import org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods.DisableControllerMethod;
import org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods.ReadAllControllerMethod;
import org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods.ReadByIDControllerMethod;
import org.riwi.Spring_Workshop_Week_3.dtos.Response.StudentResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.Save;


public interface InterfaceContStudent extends
        ReadByIDControllerMethod<StudentResponseDTO,Long>,
        DisableControllerMethod<StudentResponseDTO,Long>,
        ReadAllControllerMethod<StudentResponseDTO>,
        Save<StudentEntity,StudentResponseDTO> {
}
