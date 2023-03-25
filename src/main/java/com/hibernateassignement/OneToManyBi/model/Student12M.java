package com.hibernateassignement.OneToManyBi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student12M {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student12M", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses = new ArrayList<>();

    // constructors, getters, and setters'
    // Add a new course to student's courses set
    public void addCourse(Course course) {
        courses.add(course);
        course.setStudent12M(this);
    }

    // Remove a course from student's courses set
    public void removeCourse(Course course) {
        courses.remove(course);
        course.setStudent12M(null);
    }
}