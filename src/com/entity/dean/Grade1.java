package com.entity.dean;


public class Grade1 {

	private int id;
	private String name;
	private Teacher1 teacher;
	private int major_id;
	private int college_id;
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
	public Teacher1 getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher1 teacher) {
		this.teacher = teacher;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int majorId) {
		major_id = majorId;
	}
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int collegeId) {
		college_id = collegeId;
	}
	
}
