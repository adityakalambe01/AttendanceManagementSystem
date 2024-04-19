package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.customexceptions.StudentException;
import com.attendancemanagementsystem.entity.Student;
import com.attendancemanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    /*
    *
    * Add New Student
    *
    * */
    public boolean addNewStudent(Student newStudent){
        try {
            if (
                    studentRepository.findByStudentEmailId(newStudent.getStudentEmailId()) != null
            ){
                  throw new StudentException("Student Exist!");
            }

            studentRepository.save(newStudent);
        }catch (StudentException e){
            return false;
        }
        return true;
    }

    /*
    *
    * Delete Student
    *
    * */
    public boolean deleteStudent(Long studentId){
        try {
            if (studentRepository.existsById(studentId)){
                studentRepository.deleteById(studentId);
                return true;
            }else {
                throw new StudentException("Student not found");
            }
        }catch (StudentException studentException){
            System.out.println(studentException.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    /*
    *
    * Mark Present
    *
    * */


}
