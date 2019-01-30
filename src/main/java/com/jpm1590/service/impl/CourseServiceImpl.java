package com.jpm1590.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jpm1590.entity.Course;
import com.jpm1590.repository.CourseJpaRepository;
import com.jpm1590.service.CourseService;

@Service("courseServiceImp")
public class CourseServiceImpl implements CourseService {

	private static final Log LOG = LogFactory.getLog(CourseService.class);
	
	@Autowired
	@Qualifier("CourseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		courseJpaRepository.findAll();
		return courseJpaRepository.findAll();
	}
	
	@Override
	public Course findByName(String name){
		return courseJpaRepository.findByName(name);
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("Call: " + "addCourse()");
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);;
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}	

}
