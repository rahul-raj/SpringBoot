package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Course;
import com.example.entity.Topic;
import com.example.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	private static final Logger log = LoggerFactory.getLogger(TopicController.class);
	
	@GetMapping("/test")
	public Course[] getCourses(){
		Course[] course = new RestTemplate().getForObject("http://localhost:8080/courses", Course[].class);
		log.info(course.toString());
		return course;
	}
	
	@GetMapping("/courses/{courseId}/topics")
	public List<Topic> getAllTopics(@PathVariable String courseId) {
		return topicService.getAllTopics(courseId);
	}
	
	@GetMapping("/courses/{courseId}/topics/{name}")
	public Topic getTopic(@PathVariable String courseId, @PathVariable String name) {
		//System.out.println(topicService.getAllTopics().size()+"**********");
		return topicService.getTopic(name);
	}
	
	@PostMapping("/courses/{courseId}/topics")
	public void addTopic(@RequestBody Topic topic, @PathVariable String courseId) {
		topic.setCourse(new Course(courseId, "", ""));
		topicService.addTopic(topic);
	}
	
	@PutMapping("/courses/{courseId}/topics/{name}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String name, @PathVariable String courseId) {
		topic.setCourse(new Course(courseId, "", ""));
		topicService.updateTopic(topic, name);
	}
	
	@DeleteMapping("/courses/{courseId}/topics/{name}")
	public void deleteTopic(@PathVariable String name) {
		//System.out.println(topicService.getAllTopics().size()+"**********");
		topicService.deleteTopic(name);
	}
	
}
