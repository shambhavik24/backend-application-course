package com.example.courses_backend_application.service.impl;

import com.example.courses_backend_application.entity.CourseInstance;
import com.example.courses_backend_application.repository.CourseInstanceRepository;
import com.example.courses_backend_application.service.CourseInstanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseInstanceServiceImpl implements CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;


    @Override
    public List<CourseInstance> getInstanceByYearAndSemister(Long year, Long semister) {
        return courseInstanceRepository.findByYearAndSemister(year, semister);
    }

    @Override
    public Optional<CourseInstance> getInstanceById(Long courseInsId) {
        return courseInstanceRepository.findById(courseInsId);

    }

    @Override
    public CourseInstance createInstance(CourseInstance instance) {
        CourseInstance instance1 = courseInstanceRepository.save(instance);
        return instance1;
    }

    @Override
    public void deleteInstance(Long courseInsId, Long semister, Long year) {
        courseInstanceRepository.deleteById(courseInsId);
    }

}
