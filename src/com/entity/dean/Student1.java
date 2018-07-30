package com.entity.dean;

import java.util.Date;

public class Student1 {

	private int id;
	private int nom;
	private String name;
	private Date birthday;
	private College1 college;
	private Major1 major;
	private int gradeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNom() {
		return nom;
	}
	public void setNom(int nom) {
		this.nom = nom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public College1 getCollege() {
		return college;
	}
	public void setCollege(College1 college) {
		this.college = college;
	}
	public Major1 getMajor() {
		return major;
	}
	public void setMajor(Major1 major) {
		this.major = major;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
}
