package com.entity.dean;

import java.util.HashSet;
import java.util.Set;

public class Role1 {

	private int id;
	private String name;
	private String text;
	private String page;
	private Set<Account1> Accounts=new HashSet<Account1>();
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
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Set<Account1> getAccounts() {
		return Accounts;
	}
	public void setAccounts(Set<Account1> accounts) {
		Accounts = accounts;
	}
	@Override
	public String toString() {
		return "Role [Accounts=" + Accounts + ", id=" + id + ", name=" + name
				+ ", page=" + page + ", text=" + text + "]";
	}
}
