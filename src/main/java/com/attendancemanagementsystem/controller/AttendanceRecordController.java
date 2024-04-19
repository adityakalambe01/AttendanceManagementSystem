package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.entity.AttendanceRecord;
import com.attendancemanagementsystem.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("attendance")
public class AttendanceRecordController {
    @Autowired
    AttendanceRecordService attendanceRecordService;

    /*
    *
    * Add Attendance
    *
    * */
    @PostMapping("add")
    public String addAttendanceRecord(AttendanceRecord attendanceRecord) {
        return attendanceRecordService.addAttendance(attendanceRecord)? "": null;
    }

    /*
    *
    * Update Attendance
    *
    * */
    @PostMapping("update")
    public String updateAttendanceRecord(Long attendanceId, AttendanceRecord attendanceRecord) {
        return attendanceRecordService.updateAttendance(attendanceId, attendanceRecord)? null:null;
    }

    /*
    *
    * Get All Attendance
    *
    * */
    @GetMapping("all")
    public String getAllAttendanceRecords() {
        return null;
    }

    /*
    *
    * Attendance By Date
    *
    * */
    @GetMapping("byDate")
    public String getAttendanceRecordsByDate(LocalDate date) {
        return null;
    }

    /*
    *
    * Attendance by Status
    *
    * */
    @GetMapping("status")
    public String getAttendanceByStatus(String status){
        return null;
    }

}
