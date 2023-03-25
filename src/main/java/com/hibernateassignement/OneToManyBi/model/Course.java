package com.hibernateassignement.OneToManyBi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student12M student12M;

    public Student12M getStudent() {
        return this.student12M;
    }

    // constructors, getters, and setters
}
