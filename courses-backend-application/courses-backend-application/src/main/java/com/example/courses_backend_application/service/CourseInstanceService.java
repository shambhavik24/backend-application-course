package com.example.courses_backend_application.service;

import com.example.courses_backend_application.entity.CourseInstance;

import java.util.List;
import java.util.Optional;

public interface CourseInstanceService {

    List<CourseInstance> getInstanceByYearAndSemister(Long year, Long semister);

    Optional<CourseInstance> getInstanceById(Long courseInsId);

    CourseInstance createInstance (CourseInstance instance);

    void  deleteInstance (Long courseInsId, Long semistetr, Long year);






}
