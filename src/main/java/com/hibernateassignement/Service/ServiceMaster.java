package com.hibernateassignement.Service;

import com.hibernateassignement.HibernateChallenge.service.TeacherOpertaions;
import com.hibernateassignement.HibernateChallenge.service.TeacherOpertaionsImpl;
import com.hibernateassignement.OneTOOneUni.service.StudentOpertaions121Uni;
import com.hibernateassignement.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class ServiceMaster implements StudentOpertaions121Uni {
    private static final SessionFactory factory = HibernateConfig.getSessionFactory();
    private static Scanner sc;
    private static int choice;
    private static Session session;

    public ServiceMaster() {

        welcomeToAssigment();
    }

    private void welcomeToAssigment() {

        System.out.println("Welcome to Hibernate Assignment !");
        session = factory.openSession();
        sc = new Scanner(System.in);
        do {
            MainMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> TeacherCrud();
                case 2 -> OnetoOneUni();
                case 3 -> OnetoOneBi();
                case 4 -> OnetoMany();
                case 5 -> ManytoMany();
                default -> System.out.println("Please Select correct options");
            }
        } while (true);
    }

    private static void ManytoMany() {
        System.out.println("""
                Select form Options
                1. Teacher Crud Operation
                2. One to One Unidirectional
                3. One to One Bidirectional
                4. One to Many Bidirectional
                5. Many to Many Bidirectional""");

    }

    private static void OnetoMany() {
        System.out.println("""
                Select form Options
                1. Create Student along with data in the courses
                2. Removing a Course without affecting students
                3. Fetch all student names for a course Id
                4. Fetch all course names for a student Id""");


    }

    private static void OnetoOneBi() {
        System.out.println("""
                Select form Options
                1. Teacher Crud Operation
                2. One to One Unidirectional
                3. One to One Bidirectional
                4. One to Many Bidirectional
                5. Many to Many Bidirectional""");

    }

    private static void OnetoOneUni() {
        System.out.println("""
                Select form Options
                1. Save Student
                2. Delete Student along with Address
                3. One to One Bidirectional
                4. One to Many Bidirectional
                5. Many to Many Bidirectional""");

    }

    private static void TeacherCrud() {
        System.out.println("""
                Select form Options
                1. Show all Teacher
                2. Add a Teacher
                3. Update a Teacher
                4. Delete a Teacher
                """);
        choice = sc.nextInt();
        TeacherOpertaions teacherOpertaions = new TeacherOpertaionsImpl(session);
        switch (choice) {
            case 1 -> teacherOpertaions.showAllTeacher();
            case 2 -> teacherOpertaions.addTeacher();
            case 3 -> teacherOpertaions.updateTeacher();
            case 4 -> teacherOpertaions.removeTeacher();
            default -> System.out.println("Please Select Correct Option");
        }
    }

    private static void MainMenu() {
        System.out.println("""
                Select form Options
                1. Teacher Crud Operation
                2. One to One Unidirectional
                3. One to One Bidirectional
                4. One to Many Bidirectional
                5. Many to Many Bidirectional""");
    }
}
