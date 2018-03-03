package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Topic;

public interface TopicRespository extends CrudRepository<Topic, String>{
	
	public List<Topic> findByCourseCourseId(String courseId);

}
