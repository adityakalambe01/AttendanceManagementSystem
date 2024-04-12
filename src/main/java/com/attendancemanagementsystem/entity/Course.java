package com.attendancemanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long courseId;

    @Column(name = "name")
    private String courseName;

    @Column(name = "credits")
    private Long courseCredits;

    @Column(name = "dept_id")
    private Long departmentId;
}
