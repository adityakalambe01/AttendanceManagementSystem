package com.attendancemanagementsystem.customexceptions;

public class DepartmentException extends Exception{
    public DepartmentException(){
        super();
    }
    public DepartmentException(String message){
        super(message);
    }
}
