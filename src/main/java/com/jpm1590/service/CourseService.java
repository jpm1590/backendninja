package com.jpm1590.service;

import java.util.List;

import com.jpm1590.entity.Course;

public interface CourseService {
	
	public abstract List<Course> listAllCourses();
	
	public abstract Course findByName(String name);
	
	public abstract Course addCourse(Course course);
	
	public abstract int removeCourse(int id);
	
	public abstract Course updateCourse(Course course); 

}
