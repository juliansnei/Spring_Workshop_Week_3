package org.riwi.Spring_Workshop_Week_3.controllers.InterfacesControllersPerEntity;

import org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods.ReadByIDControllerMethod;
import org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods.ReadBySpecificControllerMethod;
import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadByID;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadBySpecific;
import org.springframework.http.ResponseEntity;

public interface InterfaceContClass extends ReadByID<CourseEntity,Long>,
        ReadBySpecificControllerMethod<CourseEntity,String> {

}
