package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Topic;
import com.example.repository.TopicRespository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRespository topicRepository;
	
	public List<Topic> getAllTopics(String courseId) {	
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findByCourseCourseId(courseId).forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String name) {
		return topicRepository.findOne(name);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic, String name) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}

}
