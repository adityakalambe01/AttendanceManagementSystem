package com.attendancemanagementsystem.customexceptions;

public class AttendanceRecordException extends Exception{
    public AttendanceRecordException(){
        super();
    }
    public AttendanceRecordException(String message){
        super(message);
    }
}
