package org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.CourseResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadAll;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadByID;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.Save;
import org.springframework.data.domain.Page;

import javax.swing.text.html.parser.Entity;

public interface InterfaceCourseService extends ReadAll<CourseResponseDTO>,
        ReadByID<CourseResponseDTO, Long>,
        Save<CourseEntity ,CourseResponseDTO> {

    Page<CourseResponseDTO> getCoursesPaginated(int page, int size);

    Page<CourseResponseDTO> searchCourses(String keyword, int page, int size);

}
