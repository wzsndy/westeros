package com.entity.dean;

public class Major1 {

	private int id;
	private String name;
	private String text;
	private int collegeId;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	@Override
	public String toString() {
		return "Major [collegeId=" + collegeId + ", id=" + id + ", name="
				+ name + ", text=" + text + "]";
	}
}
