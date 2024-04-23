package com.attendancemanagementsystem.controller;

import ch.qos.logback.core.model.Model;
import com.attendancemanagementsystem.controller.page.PageRedirect;
import com.attendancemanagementsystem.entity.Course;
import com.attendancemanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    private PageRedirect pageRedirect;

    /*
    *
    * Add New Course
    *
    * */
    @PostMapping("course-added")
    public String addNewCourse(Course course) {

        return courseService.addNewCourse(course)? "redirect:/course/list":"redirect:/course/add";
    }

    /*
    *
    * Delete Course
    *
    * */
    @PostMapping("course-deleted")
    public String deleteCourse(Long courseId) {
        return courseService.deleteCourse(courseId)? "redirect:/course/list":"redirect:/course/delete";
    }

    /*
    *
    * Update Course
    *
    * */
    @PostMapping("course-updated")
    public String updateCourse(Long courseId, Course course) {
        return courseService.updateCourse(courseId, course)? "redirect:/course/list":"redirect:/course/update";
    }

    /*
    *
    * Get Course by Id
    *
    * */
//    @GetMapping("id")
//    public String getCourseById(Long courseId, Model model) {
//
//        return "";
//    }

    /*
    *
    * Get All Courses
    *
    * */
    @GetMapping("courses")
    public String getAllCourses(org.springframework.ui.Model model){
        return pageRedirect.getAllCourses(model);
    }

    /*
    *
    * Course By Name
    *
    * */
    public String getCourseByName(String courseName, org.springframework.ui.Model model){

        return null;
    }

    /*
    *
    * Course By Department
    *
    * */
    public String getCourseByDepartmentId(Long departmentId){
        return null;
    }


}
