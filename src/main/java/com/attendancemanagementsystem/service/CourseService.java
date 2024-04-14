package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.customexceptions.CourseException;
import com.attendancemanagementsystem.entity.Course;
import com.attendancemanagementsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    /*
    *
    * Add new Course
    *
    * */
    public boolean addNewCourse(Course newCourse){
        newCourse.setCourseName(
                newCourse.getCourseName().trim()
        );
        courseRepository.save(newCourse);
        return true;
    }

    /*
    *
    * Delete Course
    *
    * */
    public boolean deleteCourse(Long courseId){
        if (courseRepository.existsById(courseId)){
            courseRepository.deleteById(courseId);
            return true;
        }
        return false;
    }

    /*
    *
    * Update Course
    *
    * */
    public boolean updateCourse(Long courseId, Course updatedCourse){
        try{
            Course dbCourse = courseRepository.findById(courseId).orElseGet(null);
            if (dbCourse==null) throw new CourseException("Invalid Course Id");

            dbCourse.setCourseName(
                    updatedCourse.getCourseName().trim()
            );
            dbCourse.setDepartmentId(
                    updatedCourse.getDepartmentId()
            );
            dbCourse.setCourseCredits(
                    updatedCourse.getCourseCredits()
            );

            courseRepository.save(dbCourse);

            return true;
        }catch (CourseException | NoSuchElementException courseException){
            System.out.println(courseException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    /*
    *
    * Get Course by id
    *
    * */
    public Course getCourseById(Long courseId){
        Course dbCourse = null;
        try {
            dbCourse = courseRepository.findById(courseId).orElseGet(null);
            if (dbCourse==null) throw new CourseException("Invalid Course!");
        }catch (CourseException courseException){
            System.out.println(courseException.getMessage());
        }
        return dbCourse;
    }

    /*
    *
    * Get all course
    *
    * */
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    /*
    *
    * Get Course by name
    *
    * */
    public List<Course> getCourseByName(String courseName){
        return courseRepository.findByCourseName(courseName);
    }

    /*
    *
    * Get Course by Department Name
    *
    * */
    public List<Course> getCourseNyDepartmentId(Long departmentId){
        return courseRepository.findByDepartmentId(departmentId);
    }
}
