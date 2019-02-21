package com.example.jpademo.coursecontroller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpademo.controller.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicid}/courses")
	public List<Course> getAllCourses(@PathVariable("topicid") String topicid) {
		return courseService.getAllCourses(topicid);
	}

	@RequestMapping("/topics/{topicid}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable("id") String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(value = "/topics/{topicid}/courses", method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable("topicid") String topicid) {
		course.setTopic(new Topic(topicid, "", ""));
		courseService.addCourse(course);
	}

	@RequestMapping(value = "/topics/{topicid}/courses/{id}", method = RequestMethod.PUT)
	public void addTopic(@PathVariable("topicid") String topicid, @PathVariable("topicid") String id,
			@RequestBody Course course) {
		course.setTopic(new Topic(topicid, "", ""));
		courseService.updateCourse(id, course);
	}

	@RequestMapping(value = "/topics/{topicid}/courses/{id}", method = RequestMethod.DELETE)
	public void addTopic(@PathVariable("id") String id) {
		courseService.deleteCourse(id);
	}

}
