package com.example.courses_backend_application.repository;

import com.example.courses_backend_application.entity.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemister(Long year, Long semister);

}
