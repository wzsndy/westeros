package com.entity.dean;


public class Account1 {

	private int id;
	private String account;
	private String pwd;
	private int nom;
	private Role1 role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Role1 getRole() {
		return role;
	}
	public void setRole(Role1 role) {
		this.role = role;
	}
	public int getNom() {
		return nom;
	}
	public void setNom(int nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Account [account=" + account + ", id=" + id + ", nom=" + nom
				+ ", pwd=" + pwd + ", role=" + role + "]";
	}
}
