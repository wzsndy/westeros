package com.entity;

public class Major {

	private int id;
	private String name;
	private int college_id;
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int collegeId) {
		college_id = collegeId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
