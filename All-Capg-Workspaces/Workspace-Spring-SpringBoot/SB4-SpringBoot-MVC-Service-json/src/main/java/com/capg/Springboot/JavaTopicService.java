package com.capg.Springboot;

import java.util.*;

public class JavaTopicService {
	public List topics() {
		return Arrays.asList(new JavaTopics("SpringBoot", "SpringMVC", "Spring"), new JavaTopics("JPA", "Hibernate", "JDBC"), new JavaTopics("ReactJS", "JavaScript", "UI-Development"));
	}
	public List<JavaTopics> getAllMyTopics(){
		return topics();
	}
}
