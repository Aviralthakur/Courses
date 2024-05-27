package com.springrest.courses.service;

import com.springrest.courses.entity.Course;
import com.springrest.courses.repository.Coursesdao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
     private Coursesdao coursesdao;

    @Override
    public List<Course> getCourses() {
       try {
           return coursesdao.findAll();
       } catch (Exception e){
           logger.error(e.getMessage());
       }
       return new ArrayList<>();
    }

    @Override
    public Course getCoursesById(Long courseID) {

       try {
           return coursesdao.getOne(courseID);
       }catch (Exception e){
           logger.error(e.getMessage());
       }
       return null;
    }

    @Override
    public String setCourses(Course course) {
        try {
            coursesdao.save(course);
                return "Added";

        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return "Error";
    }

    @Override
    public Course updateCourses(Course course) {
        try {
            return coursesdao.save(course);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteCourses(Long courseId) {

            coursesdao.deleteById(courseId);

    }
}
