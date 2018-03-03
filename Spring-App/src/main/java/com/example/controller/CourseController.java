package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Course;
import com.example.exception.NoCoursesFoundException;
import com.example.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
		
	@GetMapping("/courses")
	public List<Course> getAllCourses() throws NoCoursesFoundException {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/courses/{name}")
	public Course getCourse(@PathVariable String name) {
		//System.out.println(topicService.getAllTopics().size()+"**********");
		return courseService.getCourse(name);
	}
	
	@PostMapping("/courses")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	@PutMapping("/courses/{name}")
	public void updateTopic(@RequestBody Course course, @PathVariable String name) {
		courseService.updateCourse(course, name);
	}
	
	@DeleteMapping("/courses/{name}")
	public void deleteCourse(@PathVariable String id) {
		//System.out.println(topicService.getAllTopics().size()+"**********");
		courseService.deleteCourse(id);
	}
	
}
