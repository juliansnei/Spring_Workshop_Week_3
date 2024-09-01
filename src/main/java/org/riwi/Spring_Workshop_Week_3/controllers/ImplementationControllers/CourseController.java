package org.riwi.Spring_Workshop_Week_3.controllers.ImplementationControllers;

import org.riwi.Spring_Workshop_Week_3.dtos.Response.CourseResponseDTO;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceCourseService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class CourseController {

    private InterfaceCourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseResponseDTO>> getCoursesPaginated(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<CourseResponseDTO> coursePage = courseService.getCoursesPaginated(page, size);
        return new ResponseEntity<>(coursePage, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Page<CourseResponseDTO>> searchCourses(
            @RequestParam("keyword") String keyword,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<CourseResponseDTO> coursePage = courseService.searchCourses(keyword, page, size);
        return new ResponseEntity<>(coursePage, HttpStatus.OK);
    }


}
