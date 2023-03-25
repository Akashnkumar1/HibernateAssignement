package com.hibernateassignement.HibernateChallenge.service;

import com.hibernateassignement.HibernateChallenge.model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

/**
 * CURD -Opertaions
 */
public class TeacherOpertaionsImpl implements TeacherOpertaions {

    private Teacher teacher;
    private Session session;
    private Transaction transaction;
    private Scanner in = new Scanner(System.in);
    int choice;

    public TeacherOpertaionsImpl(Session session) {
        this.session = session;
    }

    /**
     *  C --- Create Record
     */
    @Override
    public void addTeacher() {
        System.out.println("Please Enter Details");
        teacher = new Teacher();
        System.out.print("\nEnter Email: ");
        teacher.setEmail(in.nextLine());
        System.out.print("\nEnter the First Name: ");
        teacher.setF_name(in.nextLine());
        System.out.print("\nEnter the Last Name: ");
        teacher.setL_name(in.nextLine());

        transaction = session.beginTransaction();
        session.persist(teacher);
        transaction.commit();
    }

    /**
     *  D --- Delete Record
     */
    @Override
    public void removeTeacher() {
        System.out.print("\nPlease Enter Email: ");
        String email = in.nextLine();
        teacher = session.createQuery("from Teacher where email=:email_id", Teacher.class).setParameter("email_id", email).uniqueResult();
        transaction = session.beginTransaction();
        session.remove(teacher);
        transaction.commit();
    }

    /**
     *  U -- Update Record
     */
    @Override
    public void updateTeacher() {

        System.out.println("Please Enter Details");
        System.out.print("\nPlease Enter Email: ");
        String email = in.nextLine();
        teacher = session.createQuery("from Teacher where email=:email_id", Teacher.class).setParameter("email_id", email).uniqueResult();
        transaction = session.beginTransaction();
        System.out.println("""
                
                Please Select
                1. Update First Name
                2. Update Last Name
                3. Update Email
                
                """);
        choice = in.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Enter the First Name: ");
                String firstName = in.nextLine();
                teacher.setF_name(firstName);
                session.persist(teacher);
                transaction.commit();
                break;
            case 2:
                System.out.println("Enter the Last Name: ");
                String lastName = in.nextLine();
                teacher.setL_name(lastName);
                session.persist(teacher);
                transaction.commit();
                break;

            case 3:
                System.out.println("Enter the Email: ");
                String emailid = in.nextLine();
                teacher.setEmail(emailid);
                session.persist(teacher);
                transaction.commit();
                break;
        }
    }

    /**
     *  R -- Read Record
     */

    @Override
    public void showAllTeacher() {
        System.out.println("Teachers List :");
        List<Teacher> teacherList = session.createQuery("from Teacher", Teacher.class).getResultList();
        System.out.println(teacherList);
    }
}
