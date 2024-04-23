package com.attendancemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "name")
    private String courseName;

    @Column(name = "credits")
    private Long courseCredits;

    @Column(name = "dept_id")
    private Long departmentId;

    @Column(name = "department_name")
    private String departmentName;
}
