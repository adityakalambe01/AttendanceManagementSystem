package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.entity.Faculty;
import com.attendancemanagementsystem.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
