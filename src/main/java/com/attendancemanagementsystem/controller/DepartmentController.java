package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.entity.Department;
import com.attendancemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    /*
    *
    * Add New Department
    *
    * */
    @PostMapping("add")
    public String addNewDepartment(Department department) {
        return departmentService.addDepartment(department)? "": null;
    }

    /*
    *
    * Update Department
    *
    * */
    @PostMapping("update")
    public String updateDepartment(Long departmentId, Department updatedDepartment) {
        return departmentService.updateDepartment(departmentId, updatedDepartment)? "": null;
    }

    /*
    *
    * Delete Department
    *
    * */
    @RequestMapping("delete")
    public String deleteDepartment(Long departmentId) {
        return departmentService.deleteDepartment(departmentId)? "": null;
    }

    /*
    *
    * Search Department
    *
    * */
    @GetMapping("search")
    public String searchDepartment(Long departmentId) {
        return null;
    }

    /*
    *
    * All Department
    *
    * */
    @GetMapping("list")
    public String getAllDepartments() {
        return null;
    }
}
