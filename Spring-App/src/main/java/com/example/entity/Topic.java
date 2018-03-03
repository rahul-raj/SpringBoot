package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="topic")
public class Topic {

	@Id
	@Column(name="topic_id")
	private String topicId;
	@Column(name="topic_name")
	private String topicName;
	@Column(name="description")
	private String description;
	
    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
	private Course course;
	
	public Topic() {

	}
	public Topic(String id, String name, String description) {
		super();
		this.topicId = id;
		this.topicName = name;
		this.description = description;
	}
	public String getId() {
		return topicId;
	}
	public void setId(String id) {
		this.topicId = id;
	}
	public String getName() {
		return topicName;
	}
	public void setName(String name) {
		this.topicName = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
