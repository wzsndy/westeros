package com.entity.dean;

public class Score1 {

	private int id;
	private int year;
	private double score;
	private Course1 course1;
	private int studentNom;
	private String term;
	
	public int getId() {
		return id;
	}
	public Course1 getCourse1() {
		return course1;
	}
	public void setCourse1(Course1 course1) {
		this.course1 = course1;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStudentNom() {
		return studentNom;
	}
	public void setStudentNom(int studentNom) {
		this.studentNom = studentNom;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
}
