package com.entity;

public class Grade {

	private int id;
	private String name;
	private int teac_id;
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
	public int getTeac_id() {
		return teac_id;
	}
	public void setTeac_id(int teacId) {
		teac_id = teacId;
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
