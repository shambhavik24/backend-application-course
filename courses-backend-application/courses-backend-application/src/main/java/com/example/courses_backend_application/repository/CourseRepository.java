package com.example.courses_backend_application.repository;

import com.example.courses_backend_application.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
