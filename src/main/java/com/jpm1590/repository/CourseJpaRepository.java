package com.jpm1590.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpm1590.entity.Course;

@Repository("CourseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {

	public abstract Course findByPrice(int price);

	public abstract Course findByPriceAndName(int price, String name);
	
	public abstract Course findByName(String name);	

}
