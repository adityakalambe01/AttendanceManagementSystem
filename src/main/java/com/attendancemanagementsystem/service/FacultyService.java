package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.customexceptions.FacultyException;
import com.attendancemanagementsystem.entity.Faculty;
import com.attendancemanagementsystem.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository facultyRepository;

    /*
    *
    * Add new Faculty
    *
    * */
    public boolean addNewFaculty(Faculty newFaculty){
        facultyRepository.save(newFaculty);
        return true;
    }

    /*
    *
    * Update Faculty
    *
    * */
    public boolean updateFaculty(Long facultyId, Faculty updatedFaculty){
        try {
            Faculty dbFaculty = facultyRepository.findById(facultyId).orElseGet(null);
            if (dbFaculty == null ) throw new FacultyException("Invalid Faculty id");

            dbFaculty.setFacultyName(
                    updatedFaculty.getFacultyName().trim()
            );
            dbFaculty.setFacultyEmail(
                    updatedFaculty.getFacultyEmail()
            );
            dbFaculty.setDepartmentId(
                    updatedFaculty.getDepartmentId()
            );

            facultyRepository.save(dbFaculty);
            return true;

        }catch (FacultyException facultyException){
            System.out.println(facultyException.getMessage());

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    /*
    *
    * Delete Faculty
    *
    * */
    public boolean deleteFaculty(Long facultyId){
        if (facultyRepository.existsById(facultyId)){
            facultyRepository.deleteById(facultyId);
            return true;
        }
        return false;
    }

    /*
    *
    * Get all faulty
    *
    * */
    public List<Faculty> getAllFaculty(){
        return facultyRepository.findAll();
    }

    /*
    *
    * Get Faculty by Department
    *
    * */
    public List<Faculty> getFacultyByDepartmentId(Long departmentId){
        return facultyRepository.findByDepartmentId(departmentId);
    }

    /*
    *
    * Get Faculty by Name
    *
    * */
    public List<Faculty> getFacultyByName(String facultyName){
        return facultyRepository.findByFacultyNameContainingIgnoreCase(facultyName.trim());
    }
}
