package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.entity.Faculty;
import com.attendancemanagementsystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("faculty")
public class FacultyController {
    @Autowired
    FacultyService facultyService;

    /*
    *
    * Add New Faculty
    *
    * */
    @PostMapping("add")
    public String addNewFaculty(Faculty faculty){
        return facultyService.addNewFaculty(faculty)? "": "";
    }

    /*
    *
    * Update Faculty
    *
    * */
    @PostMapping("update")
    public String updateFaculty(Long facultyId, Faculty faculty){
        return facultyService.updateFaculty(facultyId, faculty)? "": null;
    }

    /*
    *
    * Delete Faculty
    *
    * */
    @PostMapping("delete")
    public String deleteFaculty(Long facultyId){
        return facultyService.deleteFaculty(facultyId)? "": null;
    }

    /*
    *
    * All Faculty
    *
    * */
    @GetMapping("all")
    public String getAllFaculty(){
        List<Faculty> facultyList = facultyService.getAllFaculty();
        return "";
    }

    /*
    *
    * Faculty By Department
    *
    * */
    @GetMapping("byDepartment")
    public String getFacultyByDepartmentId(Long departmentId){
        List<Faculty> facultyList = facultyService.getFacultyByDepartmentId(departmentId);
        return null;
    }

    /*
    *
    * Faculty By Name
    *
    * */
    @GetMapping("byName")
    public String getFacultyByName(String facultyName){
        List<Faculty> facultyList = facultyService.getFacultyByName(facultyName);
        return "";
    }
}
