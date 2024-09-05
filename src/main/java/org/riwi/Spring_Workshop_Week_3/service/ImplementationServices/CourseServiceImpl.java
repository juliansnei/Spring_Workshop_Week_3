package org.riwi.Spring_Workshop_Week_3.service.ImplementationServices;

import org.riwi.Spring_Workshop_Week_3.dtos.Request.CourseRequestDTO;
import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;
import org.riwi.Spring_Workshop_Week_3.repository.Interfaces.CourseRepository;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements InterfaceCourseService {
    @Autowired
    CourseRepository courseRepository;


    @Override
    public CourseRequestDTO save(CourseEntity entity) {
        return null;
    }


    @Override
    public CourseEntity readById(Long aLong) {
        return null;
    }



    @Override
    public List<CourseEntity> readAll() {
        return null;
    }


    @Override
    public List<CourseEntity> readBySpecific(String name, String description) {
        if (name != null) {
            return this.courseRepository.findByNameAndActiveTrue(name);
        } else if (description != null) {
            return this.courseRepository.findByDescriptionAndActiveTrue(description);
        } else {
            return this.courseRepository.findAll();
        }
    }
}