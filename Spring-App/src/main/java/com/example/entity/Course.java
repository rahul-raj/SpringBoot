package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="course_id")
	private String courseId;
	@Column(name="course_name")
	private String courseName;	
	@Column(name="description")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="course")
	List<Topic> topics = new ArrayList<Topic>();
	
	
	public Course() {

	}
	public Course(String id, String name, String description) {
		super();
		this.courseId = id;
		this.courseName = name;
		this.description = description;
	}
	public String getId() {
		return courseId;
	}
	public void setId(String id) {
		this.courseId = id;
	}
	public String getName() {
		return courseName;
	}
	public void setName(String name) {
		this.courseName = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
