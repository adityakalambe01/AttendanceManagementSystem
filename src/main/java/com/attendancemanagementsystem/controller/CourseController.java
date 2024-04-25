package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.controller.page.PageRedirect;
import com.attendancemanagementsystem.entity.Course;
import com.attendancemanagementsystem.service.CourseService;
import com.attendancemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    DepartmentService departmentService;
    @Autowired
    private PageRedirect pageRedirect;

    /*
    *
    * Add New Course
    *
    * */
    @PostMapping("course-added")
    public String addNewCourse(Course course, Model model) {

        return courseService.addNewCourse(course)? pageRedirect.getAllCourses(model) : pageRedirect.somethingWentWrong();
    }

    /*
    *
    * Delete Course
    *
    * */
    @GetMapping("course-deleted")
    public String deleteCourse(Long courseId, Model model) {
        return courseService.deleteCourse(courseId)? pageRedirect.getAllCourses(model) : pageRedirect.somethingWentWrong();
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
    @GetMapping("view-course")
    public String getCourseById(Long courseId, Model model) {
        model.addAttribute("departments",departmentService.getAllDepartment());
        model.addAttribute("currentCourse",courseService.getCourseById(courseId));
        model.addAttribute("defaultDepartmentId", courseService.getCourseById(courseId).getDepartmentId());

        return pageRedirect.viewCourse(model);
    }

    /*
    *
    * Get All Courses
    *
    * */
//    @RequestMapping("courses")
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
