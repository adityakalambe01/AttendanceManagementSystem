package com.attendancemanagementsystem.repository;

import com.attendancemanagementsystem.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByDepartmentId(Long departmentId);

    List<Faculty> findByFacultyNameContainingIgnoreCase(String facultyName);
}
