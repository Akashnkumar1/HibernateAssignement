package com.hibernateassignement.OneTOOneBi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "student")
@Data
@ToString
public class Student121 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "student121", cascade = CascadeType.ALL)
    private Address121 address121;

    // constructors, getters, and setters
}
