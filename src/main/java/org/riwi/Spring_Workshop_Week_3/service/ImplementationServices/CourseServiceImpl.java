package org.riwi.Spring_Workshop_Week_3.service.ImplementationServices;

import org.riwi.Spring_Workshop_Week_3.dtos.Request.CourseRequestDTO;
import org.riwi.Spring_Workshop_Week_3.dtos.Response.CourseResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;
import org.riwi.Spring_Workshop_Week_3.repository.Interfaces.ClassRepository;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceCourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements InterfaceCourseService {

    private final ClassRepository classRepository;

    public CourseServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Page<CourseResponseDTO> getCoursesPaginated(int page, int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<CourseEntity> coursePage = classRepository.findAll((org.springframework.data.domain.Pageable) pageable);
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
        return new PageImpl<>(courseResponseDTOList, (org.springframework.data.domain.Pageable) pageable, coursePage.getTotalElements());
    }

    @Override
    public Page<CourseResponseDTO> searchCourses(String keyword, int page, int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        List<CourseEntity> courses = classRepository.searchByKeyword(keyword);
        List<CourseResponseDTO> courseResponseDTOList = courses.stream()
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
        return new PageImpl<>(courseResponseDTOList, (org.springframework.data.domain.Pageable) pageable, courseResponseDTOList.size());

    }
    @Override
    public CourseResponseDTO getCourseById(Long id) {
        CourseEntity course = classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
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
    }
    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO requestDTO) {
        CourseEntity course = new CourseEntity();
        course.setName(requestDTO.getCourseName());
        CourseEntity savedCourse = classRepository.save(course);
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(savedCourse.getId());
        dto.setName(savedCourse.getName());
        dto.setStudentIds(savedCourse.getStudentEntityList().stream()
                .map(student -> student.getId())
                .collect(Collectors.toList()));
        dto.setLessonIds(savedCourse.getLessonEntityList().stream()
                .map(lesson -> lesson.getId())
                .collect(Collectors.toList()));
        return dto;
    }
}
