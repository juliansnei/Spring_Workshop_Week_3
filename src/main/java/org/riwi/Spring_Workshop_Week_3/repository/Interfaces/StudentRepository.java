package org.riwi.Spring_Workshop_Week_3.repository.Interfaces;

import org.riwi.Spring_Workshop_Week_3.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
