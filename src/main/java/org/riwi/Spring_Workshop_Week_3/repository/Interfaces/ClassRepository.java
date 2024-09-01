package org.riwi.Spring_Workshop_Week_3.repository.Interfaces;


import org.riwi.Spring_Workshop_Week_3.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRepository extends JpaRepository<CourseEntity,Long> {

    @Query("SELECT c FROM CourseEntity c WHERE c.name LIKE %:keyword%")
    List<CourseEntity> searchByKeyword(@Param("keyword") String keyword);

}
