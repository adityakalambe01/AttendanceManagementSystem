package com.attendancemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Faculty extends JpaRepository<Faculty, Long> {
}
