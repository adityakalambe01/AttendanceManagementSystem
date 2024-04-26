package com.attendancemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long studentId;

    @Column(name = "name")
    private String studentName;

    @Column(name = "email")
    private String studentEmailId;

    @Column(name = "dept_id")
    private Long departmentId;

    @Column(name = "dept_name")
    private String departmentName;
}
