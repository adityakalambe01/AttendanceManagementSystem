package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.customexceptions.DepartmentException;
import com.attendancemanagementsystem.entity.Department;
import com.attendancemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    /*
    *
    * Add New Department
    *
    * */
    public boolean addDepartment(Department department){
        try {
            department.setDepartmentName(
                    department.getDepartmentName().trim()
            );

            if (departmentRepository.findByDepartmentName(department.getDepartmentName())!=null){
                throw new DepartmentException("Department Name already exists");
            }

            departmentRepository.save(department);

        }catch (DepartmentException departmentException){
            System.out.println(
                    departmentException.getMessage()
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    /*
    *
    * Update Department
    *
    * */
    public boolean updateDepartment(Long departmentId, Department updatedDepartment){
        try {
            Department department = departmentRepository.findById(departmentId).get();
            if (department==null) throw new DepartmentException("Department Not Found!");

            department.setDepartmentName(
                    updatedDepartment.getDepartmentName().trim()
            );
            departmentRepository.save(department);
            return true;


        }catch (DepartmentException departmentException){
            System.out.println(departmentException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /*
    *
    * Delete Department
    *
    * */
    public boolean deleteDepartment(Long departmentId){
        if (departmentRepository.existsById(departmentId)){
            departmentRepository.deleteById(departmentId);
            return true;
        }
        return false;

    }

    /*
    *
    * Search Department
    *
    * */
    public List<Department> searchDepartment(String departmentName){

        return departmentRepository.findByDepartmentNameContainingIgnoreCase(departmentName.trim());
    }

    /*
    *
    * Get All Department
    *
    * */
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
}
