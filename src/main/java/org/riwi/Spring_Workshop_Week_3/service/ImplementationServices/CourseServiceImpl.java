package org.riwi.Spring_Workshop_Week_3.service.ImplementationServices;
import org.riwi.Spring_Workshop_Week_3.dtos.Response.CourseResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;
import org.riwi.Spring_Workshop_Week_3.repository.Interfaces.CourseRepository;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceCourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements InterfaceCourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Page<CourseResponseDTO> getCoursesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CourseEntity> coursePage = courseRepository.findAll(pageable);

        List<CourseResponseDTO> courseResponseDTOList = coursePage.stream()
                .map(course -> {
                    CourseResponseDTO dto = new CourseResponseDTO();
                    dto.setId(course.getId());
                    dto.setName(course.getName());
                    dto.setStudentIds(course.getStudentEntityList().stream()
                            .map(student -> student.getId())
                            .collect(Collectors.toList()));
                    dto.setLessonIds(course.getLessonEntityList().stream()
                            .map(lesson -> lesson.getId())
                            .collect(Collectors.toList()));
                    return dto;
                })
                .collect(Collectors.toList());

        return new PageImpl<>(courseResponseDTOList, pageable, coursePage.getTotalElements());
    }

    @Override
    public Page<CourseResponseDTO> searchCourses(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CourseEntity> coursePage = courseRepository.findAll(pageable);

        List<CourseResponseDTO> courseResponseDTOList = coursePage.stream()
                .map(course -> {
                    CourseResponseDTO dto = new CourseResponseDTO();
                    dto.setId(course.getId());
                    dto.setName(course.getName());
                    dto.setStudentIds(course.getStudentEntityList().stream()
                            .map(student -> student.getId())
                            .collect(Collectors.toList()));
                    dto.setLessonIds(course.getLessonEntityList().stream()
                            .map(lesson -> lesson.getId())
                            .collect(Collectors.toList()));
                    return dto;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(courseResponseDTOList, pageable, coursePage.getTotalElements());
    }
}
