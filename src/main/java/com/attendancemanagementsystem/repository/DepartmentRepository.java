package com.attendancemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.attendancemanagementsystem.entity.Department;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);

    List<Department> findByDepartmentNameContainingIgnoreCase(String departmentName);
}
