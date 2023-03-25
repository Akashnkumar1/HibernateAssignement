package com.hibernateassignement.OneToManyBi.service;

import com.hibernateassignement.OneToManyBi.model.Course;
import com.hibernateassignement.OneToManyBi.model.Student12M;

import java.util.List;

public interface StudentOpertaions12MBi {

    void findCourseByStudentId(Long courseId);

    void findStudentByCourseId(Long studentId);

    void createStudentWithCourseData(Student12M student, List<Course> courses);

    void removeCourseWithoutStudent(Long courseId);

}
