package org.riwi.Spring_Workshop_Week_3.repository.Interfaces;

import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    List<CourseEntity> findByNameAndActiveTrue(String name);
    List<CourseEntity> findByDescriptionAndActiveTrue(String description);

}
