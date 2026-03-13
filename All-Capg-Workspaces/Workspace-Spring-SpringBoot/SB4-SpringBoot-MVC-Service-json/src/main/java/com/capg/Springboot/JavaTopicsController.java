package com.capg.Springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class JavaTopicsController {
	
	@Autowired
	JavaTopicService topicService;
	
	@RequestMapping("login.spring")
	public String loginValid() {
		return  "Welcome tp SpringBoot Application";
	}
	
	@RequestMapping("/javatopics")
	public List getAllTopics() {
		return topicService.getAllMyTopics();
	}
	
}