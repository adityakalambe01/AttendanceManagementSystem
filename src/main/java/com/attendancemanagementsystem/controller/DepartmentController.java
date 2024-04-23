package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.controller.page.PageRedirect;
import com.attendancemanagementsystem.entity.Department;
import com.attendancemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    private PageRedirect pageRedirect;

    /*
    *
    * Add New Department
    *
    * */
    @PostMapping("department-added")
    public String addNewDepartment(Department department, Model model) {
        return departmentService.addDepartment(department)? pageRedirect.getAllDepartments(model): pageRedirect.somethingWentWrong();
    }

    /*
    *
    * Update Department
    *
    * */
    @PostMapping("department-updated")
    public String updateDepartment(Long departmentId, Department updatedDepartment, Model model) {
        return departmentService.updateDepartment(departmentId, updatedDepartment)?
                pageRedirect.getAllDepartments(model): pageRedirect.somethingWentWrong();
    }

    /*
    *
    * Delete Department
    *
    * */
    @RequestMapping("delete-department")
    public String deleteDepartment(Long departmentId, Model model) {
        return departmentService.deleteDepartment(departmentId)? pageRedirect.getAllDepartments(model): pageRedirect.somethingWentWrong();
    }

    /*
    *
    * Search Department
    *
    * */
    @GetMapping("search-department")
    public String searchDepartment(Long departmentId) {
        return null;
    }

    /*
    *
    * All Department
    *
    * */
    @GetMapping({"list-department", "departments"})
    public String getAllDepartments(Model model) {
        return pageRedirect.getAllDepartments(model);
    }
}
