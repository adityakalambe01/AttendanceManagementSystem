package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.customexceptions.StudentException;
import com.attendancemanagementsystem.entity.Student;
import com.attendancemanagementsystem.repository.DepartmentRepository;
import com.attendancemanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

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
    * Update Student
    *
    * */
    public boolean updateStudent(Long studentID, Student updatedStudent){
        if (studentRepository.existsById(studentID)){

            Student oldStudent = studentRepository.findById(studentID).get();
            oldStudent.setStudentName(
                    updatedStudent.getStudentName()
            );
            oldStudent.setStudentEmailId(
                    updatedStudent.getStudentEmailId()
            );
            oldStudent.setDepartmentId(
                    updatedStudent.getDepartmentId()
            );
            oldStudent.setDepartmentName(
                    departmentRepository.findById(updatedStudent.getDepartmentId())
                                        .get()
                                        .getDepartmentName()
            );

            studentRepository.save(oldStudent);


            return true;
        }

        return false;
    }

    /*
    *
    * Mark Present
    *
    * */


}
