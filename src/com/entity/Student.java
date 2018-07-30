package com.entity;

public class Student {

	private int id;
	private int nomber;
	private String name;
	private String birthday;
	private int college_id;
	private int major_id;
	private int grade_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNomber() {
		return nomber;
	}
	public void setNomber(int nomber) {
		this.nomber = nomber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int collegeId) {
		college_id = collegeId;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int majorId) {
		major_id = majorId;
	}
	public int getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(int gradeId) {
		grade_id = gradeId;
	}
	
}
