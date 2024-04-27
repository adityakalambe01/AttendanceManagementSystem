package com.attendancemanagementsystem.controller.page;

import com.attendancemanagementsystem.entity.Course;
import com.attendancemanagementsystem.entity.Department;
import com.attendancemanagementsystem.service.CourseService;
import com.attendancemanagementsystem.service.DepartmentService;
import com.attendancemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageRedirect {
    @Autowired
    DepartmentService departmentService;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;


    @RequestMapping({"", "/"})
    public String indexPage(){
        return "index";
    }

    /*
    *
    * Admin
    *
    * */
    //auth
    @RequestMapping({"adminSignUp", "signUpAdmin"})
    public String adminSignUp(){
        return "admin/auth/signup";
    }

    @RequestMapping({"adminLogin","loginAdmin"})
    public String loginAdmin(){
        return "admin/auth/login";
    }

    //dashboard main
    @RequestMapping({"adminDashboard","dashboardAdmin"})
    public String adminDashboard(Model model){
        model.addAttribute("totalDepartments", (long) departmentService.getAllDepartment().size());

        model.addAttribute("totalCourses", (long) courseService.getAllCourse().size());

        model.addAttribute("totalStudents",(long) studentService.getAllStudent().size());

        return "admin/dashboard";
    }

    //department
    @RequestMapping({"addDepartment","addNewDepartment","newDepartment","new_dept"})
    public String addNewDepartment(){
        return "admin/department/AddDepartment";
    }

    @RequestMapping({"view-Department","showDepartment","view_dept","viewDepartment"})
    public String viewDepartment(Long departmentId, Model model){
        Department department = departmentService.getDepartmentById(departmentId);
        model.addAttribute("departmentId",department.getDepartmentId());
        model.addAttribute("departmentName",department.getDepartmentName());
        model.addAttribute("headOfDepartment",department.getHeadOfDepartment());
        return "admin/department/ViewDepartment";
    }

    public String getAllDepartments(Model model){
        model.addAttribute("allDepartments",departmentService.getAllDepartment());
        return "admin/department/AllDepartments";
    }

    //Courses
    @RequestMapping("courses")
    public String getAllCourses(Model model){
        model.addAttribute("allCourses",courseService.getAllCourse());
        return "admin/courses/AllCourses";
    }

    @GetMapping("addCourse")
    public String addCourse(Model model){
        model.addAttribute("departments",departmentService.getAllDepartment());
        return "admin/courses/AddCourse";
    }

//    @GetMapping("view-course")
    public String viewCourse(Model model){
//        Course course = courseService.getCourseById(courseId);

        return "admin/courses/ViewCourse";
    }

    //faculty
    @RequestMapping({"addFaculty","addNewFaculty","newFaculty","new_fact"})
    public String addNewFaculty(){
        return "admin/faculty/AddFaculty";
    }

    @RequestMapping({"viewFaculty","showFaculty","view_fact"})
    public String viewFaculty(){
        return "admin/faculty/ViewFaculty";
    }

    //student
    @RequestMapping({"addStudent","addNewStudent","newStudent","new_stud"})
    public String addNewStudent(Model model){
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "admin/student/AddStudent";
    }

    @RequestMapping({"viewStudent","showStudent","view_stud","view-student"})
    public String viewStudent(){
        return "admin/student/ViewStudent";
    }

    @RequestMapping({"students","list-student","student-list"})
    public String listStudent(Model model){
        model.addAttribute("students", studentService.getAllStudent());
        return "admin/student/AllStudents";
    }



    /*
    *
    * Student Attendance
    *
    * */
    @RequestMapping({"attendance"})
    public String attendancePage(){
        return "admin/attendance/AllAttendance";
    }






//
    @RequestMapping("userSignUp")
    public String userSignUpPage(){
        return "student/signup";
    }

    @RequestMapping("userSignIn")
    public String userSignInPage(){
        return "signin";
    }

    @RequestMapping("student-dashboard")
    public String studentDashboard(Model model){
        return "student/dashboard";
    }


    /*
    *
    * Student Pages
    *
    * */
    @RequestMapping({"student-department","department-of-students"})
    public String studentDepartment(Model model){
        return null;
    }


    @RequestMapping("something-went-wrong")
    public String somethingWentWrong(){
        return "SomethingWentWrong";
    }

}
