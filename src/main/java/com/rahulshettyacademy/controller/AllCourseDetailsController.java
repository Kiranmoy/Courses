package com.rahulshettyacademy.controller;

import java.util.List;

import com.rahulshettyacademy.entity.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rahulshettyacademy.repository.CoursesRepository;


@RestController
public class AllCourseDetailsController {

	@Autowired
	CoursesRepository repository;

	@CrossOrigin
	@GetMapping("/allCourseDetails")
	public List<Courses> GetCourses(){
	return repository.findAll();
	}

	@CrossOrigin
	@RequestMapping("/getCourseByName/{name}")
	public Courses getBookById(@PathVariable(value="name")String name){
		try {
			Courses course =repository.findById(name).get();
			return course;
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
}
