package com.entity.dean;

public class Teacher1 {

	private int id;
	private int nom;
	private String name;
	private String manager;
	private College1 college;
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
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public College1 getCollege() {
		return college;
	}
	public void setCollege(College1 college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "Teacher [college=" + college + ", id=" + id + ", manager="
				+ manager + ", name=" + name + ", nom=" + nom + "]";
	}
}
