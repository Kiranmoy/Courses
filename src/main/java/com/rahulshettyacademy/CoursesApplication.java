package com.rahulshettyacademy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rahulshettyacademy.entity.Courses;


import com.rahulshettyacademy.repository.CoursesRepository;


@SpringBootApplication
public class CoursesApplication implements CommandLineRunner{

	@Autowired
	CoursesRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication.class, args);
	}
	
	@Override

	public void run(String[] args)
	{
		List<Courses> lib= repository.findAll();
		System.out.println("IS EMPTY = " + lib.isEmpty());
		System.out.println(lib.get(0).getCourse_name()+"is this");
		

}
}
