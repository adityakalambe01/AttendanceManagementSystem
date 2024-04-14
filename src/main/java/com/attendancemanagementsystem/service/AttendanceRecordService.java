package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.customexceptions.AttendanceRecordException;
import com.attendancemanagementsystem.entity.AttendanceRecord;
import com.attendancemanagementsystem.repository.AttendanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceRecordService {
    @Autowired
    AttendanceRecordRepository attendanceRecordRepository;

    /*
    *
    * Add Attendance
    *
    * */
    public boolean addAttendance(AttendanceRecord attendanceRecord){
        attendanceRecord.setAttendanceDate(
                LocalDate.now()
        );
        attendanceRecordRepository.save(attendanceRecord);
        return true;
    }

    /*
    *
    * Update Attendance
    *
    * */
    public boolean updateAttendance(Long attendanceId, AttendanceRecord updatedAttendanceRecord){
        try{
            AttendanceRecord attendanceRecord = attendanceRecordRepository.findById(attendanceId).orElseGet(null);
            if (attendanceRecord==null) throw new AttendanceRecordException("Invalid Id");

            attendanceRecord.setStudentId(
                    updatedAttendanceRecord.getStudentId()
            );
            attendanceRecord.setCourseId(
                    updatedAttendanceRecord.getCourseId()
            );
            attendanceRecord.setAttendanceDate(
                    updatedAttendanceRecord.getAttendanceDate()
            );
            attendanceRecord.setAttendanceStatus(
                    updatedAttendanceRecord.getAttendanceStatus()
            );

            attendanceRecordRepository.save(attendanceRecord);

            return true;
        }catch (AttendanceRecordException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    /*
    *
    * Get all attendance
    *
    * */
    public List<AttendanceRecord> getAllAttendance(){
        return attendanceRecordRepository.findAll();
    }

    /*
    *
    * Get all by date
    *
    * */
    public List<AttendanceRecord> getAllAttendanceByDate(LocalDate localDate){
        return attendanceRecordRepository.findByAttendanceDate(localDate);
    }

    /*
    *
    * Get all by attendance status
    *
    * */
    public List<AttendanceRecord> getAllAttendanceByStatus(LocalDate localDate, String attendanceStatus){
        return attendanceRecordRepository.findByAttendanceDateAndAttendanceStatus(localDate, attendanceStatus);
    }
}
