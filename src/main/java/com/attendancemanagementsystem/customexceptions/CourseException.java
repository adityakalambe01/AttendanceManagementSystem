package com.attendancemanagementsystem.customexceptions;

public class CourseException extends Exception{
    public CourseException(){
        super();
    }
    public CourseException(String message){
        super(message);
    }
}
