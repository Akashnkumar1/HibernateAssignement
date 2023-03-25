package com.hibernateassignement.OneToManyBi.service;

import com.hibernateassignement.OneToManyBi.model.Course;
import com.hibernateassignement.OneToManyBi.model.Student12M;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

/**
 * CURD -Opertaions
 */
public class StudentOpertaions12MBiImpl implements StudentOpertaions12MBi {

    Session session;

    Scanner in = new Scanner(System.in);

    public StudentOpertaions12MBiImpl(Session session) {
        this.session = session;
    }

    /**
     *
     */
    @Override
    public void findCourseByStudentId(Long studentId) {
        // Retrieve the student object by Id
        Student12M student = session.get(Student12M.class, studentId);

// Get the set of courses assigned to the student
        List<Course> courses = student.getCourses();

// Iterate over the set of courses and print their names
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }

    /**
     *
     */
    @Override
    public void findStudentByCourseId(Long courseId) {
        // Create a query to fetch students by course Id
        List<Student12M> query = session.createQuery("SELECT s FROM Student s JOIN s.courses c WHERE c.id = :courseId", Student12M.class)
                .setParameter("courseId", courseId).getResultList();

// Iterate over the list of students and print their names
        for (Student12M student : query) {
            System.out.println(student);
        }

    }

    /**
     *
     */
    @Override
    public void createStudentWithCourseData(Student12M student, List<Course> courses) {

        // Create a new student object
        Student12M newStud = new Student12M();
        newStud.setName(student.getName());
        newStud.setCourses(courses);
//        newStud.setName(student.getName());
//
//        for (Course course : courses) {
//            student.addCourse(course);
//        }

// Save student object in database
        session.persist(student);

    }

    /**
     *
     */
    @Override
    public void removeCourseWithoutStudent(Long courseId) {
        // Retrieve the course to be deleted
        Course course = session.get(Course.class, courseId);

// Remove the course from the student's courses set
        course.getStudent().removeCourse(course);

// Delete the course from the database
        session.remove(course);
    }
}
