package com.jpm1590.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jpm1590.entity.Course;
import com.jpm1590.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager em;

	public Course find(boolean exist) {

		JPAQuery<Course> query = new JPAQuery<Course>(em);

		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

		if (exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}

		// Course query1 = (Course) query.select(qCourse.name,
		// qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		// List<Course> courses =
		// query.select(qCourse).from(qCourse).where(qCourse.hours.between(100,
		// 200)).fetch();
		// Course query1 =
		// query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();

	}

}
