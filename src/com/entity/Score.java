package com.entity;

public class Score {

	private int id;
	private int year;
	private int course_id;
	private double score;
	private long stu_no;
	private String term;
	
	public int getId() {
		return id;
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
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public long getStu_no() {
		return stu_no;
	}
	public void setStu_no(long stu_no) {
		this.stu_no = stu_no;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	
}
