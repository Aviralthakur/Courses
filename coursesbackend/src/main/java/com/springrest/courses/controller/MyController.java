package com.springrest.courses.controller;

import com.springrest.courses.entity.Course;
import com.springrest.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MyController {

    @Autowired
    private CourseService courseService;


    //get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    //get courses by id
    @GetMapping("/courses/{courseId}")
    public Course getCoursById(@PathVariable String courseId){
        return courseService.getCoursesById(Long.parseLong(courseId));
    }

    //courses added
    @PostMapping("/courses")
    public String addCourses(@RequestBody Course course){
        return courseService.setCourses(course);
    }

    //courses updated
    @PutMapping("/courses")
    public Course updateCourses(@RequestBody Course course){
        return courseService.updateCourses(course);
    }

    //delete courses
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourses(@PathVariable String courseId){
        try{
            courseService.deleteCourses(Long.parseLong(courseId));

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
