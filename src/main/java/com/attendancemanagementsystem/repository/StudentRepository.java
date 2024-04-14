package com.attendancemanagementsystem.repository;

import com.attendancemanagementsystem.entity.Student;
import com.attendancemanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentEmailId(String studentEmailId);
}
