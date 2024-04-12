package com.attendancemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "name")
    private String userFullName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "email")
    private Long userEmailId;

    @Column(name = "role", columnDefinition = "varchar(255) default 'student'")
    private String userRole;
}
