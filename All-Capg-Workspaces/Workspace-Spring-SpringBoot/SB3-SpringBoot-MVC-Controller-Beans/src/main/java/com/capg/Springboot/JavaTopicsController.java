package com.capg.Springboot;
import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaTopicsController {
	
	@RequestMapping("Login.spring")
	public String loginValid() {
		return "Welcome to spring boot application";
	}
	@RequestMapping("/javatopics")
	public List getAllTopics() {
		return Arrays.asList(new JavaTopics("SpringBoot","SpringMVC","Spring"),new JavaTopics("JPA","Hibernate","JDBC"),new JavaTopics("React-js","JavaScript","Ui-Development"));
	}
}
