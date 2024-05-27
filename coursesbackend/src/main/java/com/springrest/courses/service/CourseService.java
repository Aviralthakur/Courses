package com.springrest.courses.service;

import com.springrest.courses.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course>getCourses();

    public Course getCoursesById(Long courseID);

    public String setCourses(Course course);

    public Course updateCourses(Course course);

    public void deleteCourses(Long courseId);
}
