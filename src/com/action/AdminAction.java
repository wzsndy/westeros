package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dao.AccountDao;
import com.dao.TeacherDao;
import com.entity.Account;
import com.entity.Teacher;

@Controller
public class AdminAction {

	@Resource
	private TeacherDao teacherdao;
	@Resource
	private AccountDao accountdao;
	private int page=1;
	private int pageSize=7;
	private int pages;
	private List<Teacher>teachers;
	private List<Account>accounts;
	private Teacher teacher;
	private Account account;
	private String pwd;
	
	
	public String findTeacherByPage(){
		teachers=teacherdao.findTeacherByPage(page, pageSize);
		pages=teacherdao.getPages(pageSize);
		if(teachers!=null){
		return "success";
		}else{
			return "error";
		}
	}
	public String saveTeacher(){
		boolean f = teacherdao.saveTeacher(teacher);
		if(f){
		return "success";
		}
		return "error";
	}
	public String createTeaAccount(){
		accounts=accountdao.findTeacherAccount();
		teachers=teacherdao.findAllTeacher();
		for(Teacher t:teachers){
			if(t.getNomber()==account.getNom()){
				boolean f=accountdao.createTeaAccount(account);
				if(f){
					return "success";
				}else{
					return "error";
				}
			}
		}
		return "null";
	}
	public String getAdminAccount(){
		System.out.println(account.getPwd());
		account=accountdao.findAdminAccount(account);
		return "success";
	}
	public String updatePassword(){
		accountdao.updatePassword(account.getNom(), pwd);
		return "success";
	}
	
	
	
	
	
	
	public TeacherDao getTeacherdao() {
		return teacherdao;
	}
	public void setTeacherdao(TeacherDao teacherdao) {
		this.teacherdao = teacherdao;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public AccountDao getAccountdao() {
		return accountdao;
	}

	public void setAccountdao(AccountDao accountdao) {
		this.accountdao = accountdao;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
