package com.example.courses_backend_application.controller;


import com.example.courses_backend_application.entity.CourseInstance;
import com.example.courses_backend_application.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CourseInstanceController {

        @Autowired
        private CourseInstanceService courseInstanceService;

    @PostMapping("/instance")
    public ResponseEntity<CourseInstance> createInstance(@RequestBody CourseInstance courseInstance){
        CourseInstance instance = courseInstanceService.createInstance(courseInstance);
        return new ResponseEntity<>(instance, HttpStatus.CREATED);
    }

    @GetMapping("instance/{year}/{semister}")
    public ResponseEntity <List<CourseInstance>> getInstanceByYearAndSemister(@PathVariable Long year,@PathVariable Long semister){
      List<CourseInstance> instance =  courseInstanceService.getInstanceByYearAndSemister(year, semister);
      return new ResponseEntity<>(instance, HttpStatus.OK);
    }


    @GetMapping("instance/{courseInsId}")
    public ResponseEntity<CourseInstance> getByInstanceId(@PathVariable Long courseInsId){
        Optional <CourseInstance> courseInstance = courseInstanceService.getInstanceById(courseInsId);

        if(courseInstance.isPresent()){
            return new ResponseEntity<>(courseInstance.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(courseInstance.get(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("instance/{year}/ {semister} /{courseInsId}")
    public ResponseEntity<String> deleteByCourseInsId(@PathVariable Long courseInsId,
                                                      @PathVariable Long semister,
                                                      @PathVariable Long year

    ){
        courseInstanceService.deleteInstance(courseInsId,  semister, year);
        return new ResponseEntity<>("Deleted sucessfully", HttpStatus.OK);

    }










}
