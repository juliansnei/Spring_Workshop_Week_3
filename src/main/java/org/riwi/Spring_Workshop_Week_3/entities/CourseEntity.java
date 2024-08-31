package org.riwi.Spring_Workshop_Week_3.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @ManyToMany(mappedBy = "courseEntityList")
    private List<StudentEntity> studentEntityList;
    @OneToMany(mappedBy = "courseEntity")
    private List<LessonEntity> lessonEntityList;

}
