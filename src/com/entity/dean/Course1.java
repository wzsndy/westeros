package com.entity.dean;

import java.util.HashSet;
import java.util.Set;

public class Course1 {

	private int id;
	private String name;
	private int majorId;
	private String text;
	private String isRequired;
	private Set<Score1> score1=new HashSet<Score1>();
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
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public String getText() {
		return text;
	}
	public Set<Score1> getScore1() {
		return score1;
	}
	public void setScore1(Set<Score1> score1) {
		this.score1 = score1;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIsRequired() {
		return isRequired;
	}
	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}
}
