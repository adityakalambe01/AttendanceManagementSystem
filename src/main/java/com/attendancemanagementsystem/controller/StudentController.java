package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.controller.page.PageRedirect;
import com.attendancemanagementsystem.entity.Student;
import com.attendancemanagementsystem.service.StudentService;
import com.attendancemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    PageRedirect pageRedirect;
    @Autowired
    UserService userService;

    /*
    *
    * Add new Student
    *
    * */
    @PostMapping({"student-added"})
    public String addNewStudent(Student student, Model model) {

        return studentService.addNewStudent(student)? pageRedirect.listStudent(model): pageRedirect.somethingWentWrong();
    }

    /*
    *
    * Delete Student
    *
    * */
    @GetMapping({"student-deleted","delete-student"})
    public String deleteStudent(Long studentId, Model model) {
        return studentService.deleteStudent(studentId) ?
                pageRedirect.listStudent(model): pageRedirect.somethingWentWrong();
    }
}
