package org.riwi.Spring_Workshop_Week_3.repository.Interfaces;

import org.riwi.Spring_Workshop_Week_3.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
}
