package com.entity.dean;

import java.util.HashSet;
import java.util.Set;

public class College1 {

	private int id;
	private String name;
	private String text;
	private Set<Major1> majors=new HashSet<Major1>();
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
	public Set<Major1> getMajors() {
		return majors;
	}
	public void setMajors(Set<Major1> majors) {
		this.majors = majors;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", majors=" + majors + ", name=" + name
				+ ", text=" + text + "]";
	}
}
