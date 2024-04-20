package com.attendancemanagementsystem.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageRedirect {
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
    public String adminDashboard(){
        return "admin/dashboard";
    }

    //department
    @RequestMapping({"addDepartment","addNewDepartment","newDepartment","new_dept"})
    public String addNewDepartment(){
        return "admin/department/add";
    }

    @RequestMapping({"viewDepartment","showDepartment","view_dept"})
    public String viewDepartment(){
        return "admin/department/view";
    }

    //faculty
    @RequestMapping({"addFaculty","addNewFaculty","newFaculty","new_fact"})
    public String addNewFaculty(){
        return "admin/faculty/add";
    }

    @RequestMapping({"viewFaculty","showFaculty","view_fact"})
    public String viewFaculty(){
        return "admin/faculty/view";
    }

    //student
    @RequestMapping({"addStudent","addNewStudent","newStudent","new_stud"})
    public String addNewStudent(){
        return "admin/student/add";
    }

    @RequestMapping({"viewStudent","showStudent","view_stud"})
    public String viewStudent(){
        return "admin/student/view";
    }





//
    @RequestMapping("userSignUp")
    public String userSignUpPage(){
        return "signup";
    }

    @RequestMapping("userSignIn")
    public String userSignInPage(){
        return "signin";
    }

    @RequestMapping("welcomePage")
    public String welcomePage(){
        return "welcome";
    }

}
