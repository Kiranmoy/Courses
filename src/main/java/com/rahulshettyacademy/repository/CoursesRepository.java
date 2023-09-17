package com.rahulshettyacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahulshettyacademy.entity.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, String>{

}
