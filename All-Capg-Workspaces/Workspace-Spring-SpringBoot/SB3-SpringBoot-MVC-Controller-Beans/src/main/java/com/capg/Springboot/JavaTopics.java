package com.capg.Springboot;

import java.io.Serializable;

public class JavaTopics implements Serializable{
	private String name;
	private String description;
	private String id;
	public JavaTopics(String name, String description, String id) {
		this.name = name;
		this.description = description;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}
