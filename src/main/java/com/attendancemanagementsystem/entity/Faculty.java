package com.attendancemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facilty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long facultyId;

    @Column(name = "name")
    private String facultyName;

    @Column(name = "email")
    private String facultyEmail;

    @Column(name = "dept_id")
    private Long departmentId;


}
