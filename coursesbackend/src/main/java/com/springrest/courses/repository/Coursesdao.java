package com.springrest.courses.repository;

import com.springrest.courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Coursesdao extends JpaRepository<Course,Long> {

}
