package org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity;

import org.riwi.Spring_Workshop_Week_3.dtos.Request.CourseRequestDTO;
import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.*;


public interface InterfaceCourseService extends
        Save<CourseRequestDTO, CourseEntity>,
        ReadByID<CourseEntity,Long>,
        ReadAll<CourseEntity>, ReadBySpecific<CourseEntity,String> {


}
