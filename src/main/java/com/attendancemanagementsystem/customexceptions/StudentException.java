package com.attendancemanagementsystem.customexceptions;

public class StudentException extends Exception{
    public StudentException(){
        super();
    }
    public StudentException(String message){
        super(message);
    }
}
