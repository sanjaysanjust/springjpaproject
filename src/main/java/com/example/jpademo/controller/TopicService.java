package com.example.jpademo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class TopicService {
	@Autowired
	private TopicRepository repository;

	public List<Topic> getAllTopics() {

		List<Topic> topicList = new ArrayList<Topic>();
		repository.findAll().forEach(topicList::add);
		return topicList;
		// return topics;
	}

	public Optional<Topic> getTopic(String id) {
		// return topics.stream().filter(t ->
		// t.getId().equals(id)).findFirst().get();
		Optional<Topic> topic = repository.findById(id);
		return topic;
	}

	public void addTopic(Topic topic) {

		repository.save(topic);
		/*
		 * System.out.println("Inside post"); topics.add(topic);
		 */
	}

	public void updateTopic(String id, Topic topic) {

		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic topic2 =
		 * topics.get(i); if (topic2.getId().equals(id)) { topics.set(i, topic);
		 * return; } }
		 */
		repository.save(topic);

	}

	public void deleteTopic(String id) {

		repository.deleteById(id);
	}

}
