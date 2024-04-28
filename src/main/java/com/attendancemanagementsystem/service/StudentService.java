package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.customexceptions.StudentException;
import com.attendancemanagementsystem.entity.Student;
import com.attendancemanagementsystem.repository.DepartmentRepository;
import com.attendancemanagementsystem.repository.StudentRepository;
import com.attendancemanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    UserService userService;

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
        if (studentRepository.existsById(studentId)){
            if (userService.deleteUser(
                    userService.getUserByEmailId(
                            studentRepository.findById(studentId).get().getStudentEmailId()
                    ).getUserId()
            ))
                studentRepository.deleteById(studentId);
            return true;
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
    * All Students
    *
    * */
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    /*
    *
    * Student by Id
    *
    * */
    public Student getStudentById(Long studentId){
        if (studentRepository.existsById(studentId)){
            return studentRepository.findById(studentId).get();
        }
        return null;
    }

    /*
    *
    * Mark Present
    *
    * */


}
