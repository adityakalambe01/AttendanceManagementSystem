package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.entity.Department;
import com.attendancemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String addNewDepartment(Department department) {
        return departmentService.addDepartment(department)? "": null;
    }

    /*
    *
    * Update Department
    *
    * */
    public String updateDepartment(Long departmentId, Department updatedDepartment) {
        return departmentService.updateDepartment(departmentId, updatedDepartment)? "": null;
    }

    /*
    *
    * Delete Department
    *
    * */
    public String deleteDepartment(Long departmentId) {
        return departmentService.deleteDepartment(departmentId)? "": null;
    }

    /*
    *
    * Search Department
    *
    * */
    public String searchDepartment(Long departmentId) {
        return null;
    }

    /*
    *
    * All Department
    *
    * */
    public String getAllDepartments() {
        return null;
    }
}
