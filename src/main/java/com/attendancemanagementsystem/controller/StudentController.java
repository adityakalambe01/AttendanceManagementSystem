package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.entity.Student;
import com.attendancemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    /*
    *
    * Add new Student
    *
    * */
    @PostMapping("add")
    public String addNewStudent(Student student) {

        return studentService.addNewStudent(student)? "":"";
    }

    /*
    *
    * Delete Student
    *
    * */
    @PostMapping("delete")
    public String deleteStudent(Long studentId) {
        return studentService.deleteStudent(studentId)? "":"";
    }
}
