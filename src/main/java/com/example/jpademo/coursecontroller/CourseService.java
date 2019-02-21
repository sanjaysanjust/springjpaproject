package com.example.jpademo.coursecontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class CourseService {
	@Autowired
	private CourseRepository repository;

	public List<Course> getAllCourses(String topicId) {
		System.out.println("Topic Id ---->" + topicId);
		List<Course> courseList = new ArrayList<Course>();
		repository.findByTopicId(topicId).forEach(courseList::add);
		return courseList;
		// return topics;
	}

	public Optional<Course> getCourse(String id) {
		// return topics.stream().filter(t ->
		// t.getId().equals(id)).findFirst().get();
		Optional<Course> course = repository.findById(id);
		return course;
	}

	public void addCourse(Course course) {

		repository.save(course);
		/*
		 * System.out.println("Inside post"); topics.add(topic);
		 */
	}

	public void updateCourse(String id, Course course) {

		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic topic2 =
		 * topics.get(i); if (topic2.getId().equals(id)) { topics.set(i, topic);
		 * return; } }
		 */
		repository.save(course);

	}

	public void deleteCourse(String id) {

		repository.deleteById(id);
	}

}
