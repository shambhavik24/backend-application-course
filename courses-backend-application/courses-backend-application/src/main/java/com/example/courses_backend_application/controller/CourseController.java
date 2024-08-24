package com.example.courses_backend_application.controller;

import com.example.courses_backend_application.entity.Course;
import com.example.courses_backend_application.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course course1 = courseService.createCourse(course);
        return new ResponseEntity<>(course1, HttpStatus.CREATED);
    }

    @GetMapping("/allcourse")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Course> getByCourseId(@PathVariable Long courseId) {
        Optional<Course> course = courseService.getCourseById(courseId);

        if (course.isPresent()) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
         courseService.deleteCourse(courseId);
        return  new ResponseEntity<>("Deleted sucessfully", HttpStatus.OK);

    }
}


