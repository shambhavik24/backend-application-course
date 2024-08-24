package com.example.courses_backend_application.service;

import com.example.courses_backend_application.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    public Course createCourse(Course course);

    public List<Course> getAllCourses();

    Optional<Course> getCourseById(Long courseId);

    void deleteCourse(Long courseId);
}
