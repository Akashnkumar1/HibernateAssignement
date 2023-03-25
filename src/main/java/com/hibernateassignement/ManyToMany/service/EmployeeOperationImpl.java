package com.hibernateassignement.ManyToMany.service;

import org.hibernate.Session;

/**
 * CURD -Opertaions
 */
public class EmployeeOperationImpl implements EmployeeOperation {

    Session session;

    public EmployeeOperationImpl(Session session) {
        this.session = session;
    }
}
