package com.hibernateassignement.HibernateChallenge.service;

import com.hibernateassignement.HibernateChallenge.model.Teacher;
import org.hibernate.Session;

public interface TeacherOpertaions {

    void addTeacher();
    void removeTeacher();

    void updateTeacher();

    void showAllTeacher();
}
