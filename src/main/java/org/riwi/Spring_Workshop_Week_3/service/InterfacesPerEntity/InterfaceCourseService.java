package org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity;

import org.riwi.Spring_Workshop_Week_3.dtos.Request.CourseRequestDTO;
import org.riwi.Spring_Workshop_Week_3.dtos.Response.CourseResponseDTO;
import org.springframework.data.domain.Page;

public interface InterfaceCourseService {
    Page<CourseResponseDTO> getCoursesPaginated(int page, int size);

    Page<CourseResponseDTO> searchCourses(String keyword, int page, int size);

    CourseResponseDTO getCourseById(Long id);

    CourseResponseDTO createCourse(CourseRequestDTO requestDTO);
}
