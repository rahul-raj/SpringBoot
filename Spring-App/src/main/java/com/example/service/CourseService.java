package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.exception.NoCoursesFoundException;
import com.example.repository.CourseRespository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRespository courseRepository;

	public List<Course> getAllCourses() throws NoCoursesFoundException{	
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findAll().forEach(courses::add);
		if(courses.size()==0) {
			throw new NoCoursesFoundException("No course found");
		}
		return courses;
	}
	
	public Course getCourse(String name) {
		return courseRepository.findOne(name);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course, String name) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}

}
