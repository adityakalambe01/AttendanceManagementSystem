package com.attendancemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendancemanagementsystem.entity.AttendanceRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Long> {
    List<AttendanceRecord> findByAttendanceDate(LocalDate localDate);

    List<AttendanceRecord> findByAttendanceDateAndAttendanceStatus(LocalDate localDate, String attendanceStatus);
}
