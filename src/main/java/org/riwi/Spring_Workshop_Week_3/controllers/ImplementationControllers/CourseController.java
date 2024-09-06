package org.riwi.Spring_Workshop_Week_3.controllers.ImplementationControllers;

import org.riwi.Spring_Workshop_Week_3.controllers.InterfacesControllersPerEntity.InterfaceContClass;
import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController implements InterfaceContClass {
    @Autowired
    InterfaceCourseService courseService;




    @Override
    public CourseEntity readById(Long aLong) {
        return null;
    }
    @GetMapping("/courses")
    @Override
    public ResponseEntity<List<CourseEntity>> readBySpecific( @RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String description) {

        List<CourseEntity> courses = courseService.readBySpecific(name, description);
        return ResponseEntity.ok(courses);
    }
}
