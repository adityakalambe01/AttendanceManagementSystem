package com.attendancemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendancemanagementsystem.entity.AttendanceRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Long> {
}
