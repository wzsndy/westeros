package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.dao.AccountDao;
import com.dao.GradeDao;
import com.dao.TeacherDao;
import com.entity.dean.Account1;
import com.entity.dean.College1;
import com.entity.dean.Grade1;
import com.entity.dean.Major1;
import com.entity.dean.Role1;
import com.entity.dean.Student1;
import com.entity.dean.Teacher1;

@Controller
public class TeacherAction implements SessionAware{
	private Map<String, Object> session=new HashMap<String, Object>();
	@Resource
	private TeacherDao teacherdao;//院长的dao
	@Resource
	private GradeDao gradedao;//班级的dao
	@Resource
	private AccountDao accountDao;//账号dao
	private List<Teacher1> deans=new ArrayList<Teacher1>();//院长的基本信息
	private List<College1> colleges=new ArrayList<College1>();//院长所属院系
	private List<Major1> majors=new ArrayList<Major1>();//院长所属专业
	private int accountNom;//账号的编号
	private List<Major1> majors2;
	private College1 college;
	private Major1 major;//院长对应的专业信息
	private int id;//院长对应的专业id
	private Teacher1 teacher;//院长的基本信息和所属院系
	private Account1 account;//账号实体类

	
	private List<Grade1> grades;//所有班级信息
	private String name;//院长名称
	private int gradeId;//班级id
	private List<Student1> students;
	private int studentId;//学生id
	private Grade1 grade;//班级实体类
	private int roleId=3;//辅导员的id
	private List<Teacher1> teachers=new ArrayList<Teacher1>();//所有辅导员信息集合
	private int collegeId;//院系id
	
	
	//删除专业操作
	public String deleteMajor(){
		System.out.println("id:"+id);
		teacherdao.deleteMajor(id);
		return "success";
	}
	//进行修改专业操作
	public String updateMajor2(){
		System.out.println("修改后的数据:"+major.toString());
		teacherdao.updateMajor2(major);
		return "success";
	}
	//进入修改专业界面
	public String updateMajor(){
		System.out.println("accountNom:"+accountNom);
		deans = teacherdao.findAll2(accountNom);//查询院长信息集合
		teacher = deans.get(0);//院长的基本信息和所属院系
		
		System.out.println("id:"+id);
		major = teacherdao.findOne(id);
		System.out.println("major:"+major.toString());
		return "success";
	}
	
	//确认添加专业操作
	public String addMajro2(){
		System.out.println("major添加专业的参数："+major.toString());
		teacherdao.addMajor(major);
		return "success";
	}
	
	//进入添加专业界面
	public String addMajor(){
		major=new Major1();
		System.out.println("collegeId:"+collegeId);
		System.out.println("accountNom:"+accountNom);
		deans = teacherdao.findAll2(accountNom);//查询院长信息集合
		teacher = deans.get(0);//院长的基本信息和所属院系
		
		/*majors2 = teacherdao.findAllMajor();
		System.out.println("majors2:"+majors2.size()+"条专业数据");
		colleges = teacherdao.findAllCollege();
		System.out.println("colleges:"+colleges.size()+"条院系数据");*/
		return "success";
	}
	//进入查看院长专业界面
	public String findAMajor(){
		System.out.println("accountNom:"+accountNom);
		deans = teacherdao.findAll2(accountNom);//查询院长信息集合
		teacher = deans.get(0);//院长的基本信息和所属院系
		
		System.out.println("collegeId:"+collegeId);
		majors = teacherdao.findAll3(collegeId);
		System.out.println(majors.size());
		return "success";
	}
	//查询院长信息
	public String findAllTeacher(){
		System.out.println("进入TeacherAction_findAllTeacher");
		//每次查询时清空集合内容
		deans.clear();
		colleges.clear();
		majors.clear();
		teacher=new Teacher1();
		int id =Integer.parseInt(session.get("id").toString());//角色ID
		System.out.println("id:"+id);
		accountNom=Integer.parseInt(session.get("accountNom").toString());//账号编号
		List<Teacher1> teacherName = teacherdao.findAll2(accountNom);//查询院长信息集合
		teacher = teacherName.get(0);//院长的基本信息和所属院系
		List<Role1> roles = teacherdao.findAll(id);//找到角色院长
		List<Account1> list=accountDao.findAccountByRoleId(roles.get(0).getId());
		for(int i=0; i<list.size(); i++){
			int nom = list.get(i).getNom();
			List<Teacher1> teachers2 = teacherdao.findAll2(nom);//查询院长基本信息
			deans.addAll(teachers2);//所有院长的基本信息
			College1 college = deans.get(i).getCollege();//获取院长所属院系
			colleges.add(college);
			System.out.println(deans.get(i).getCollege().toString());
			Set<Major1> set2 = college.getMajors();
			System.out.println("set2所属院系对应的专业:"+set2.size());
			majors.addAll(set2);	
		}
		teachers.clear();
		List<Account1> accounts = gradedao.findAllAccount(roleId);//所有辅导员账号的集合
		for(int i=0; i<accounts.size(); i++){
			int accountNom = accounts.get(i).getNom();//每个辅导员账号对应的编号nom
			List<Teacher1> list1 = gradedao.findAllTeacher(accountNom);//查询单个辅导员信息的集合
			Teacher1 teacher = list1.get(0);
			teachers.add(teacher);
		}
		grades=gradedao.findCollegeGrade(collegeId);
	/*	System.out.println("teachers:"+teachers.size());
		System.out.println("teachers:"+teachers.get(0).toString());
		System.out.println("colleges:"+colleges.size());
		System.out.println("colleges:"+colleges.toString());
		System.out.println("colleges:"+colleges.get(0).toString());
		System.out.println("majors:"+majors.size());
		for(int a=0;a<majors.size(); a++){
			System.out.println("majors:"+majors.get(a).toString());
		}*/
		return "success";
	}
	//进入修改院长账号界面
	public String updateAccount(){
		System.out.println("accountNom:"+accountNom);
		deans = teacherdao.findAll2(accountNom);//查询院长信息集合
		teacher = deans.get(0);//院长的基本信息和所属院系
		
		List<Account1> accounts = teacherdao.findOne2(accountNom);
		account = accounts.get(0);
		System.out.println("account修改前账号："+account.getAccount()+"，密码："+account.getPwd());
		return "success";
	}
	//修改密码确认操作
	public String updateAccount2(){
		System.out.println("修改后的账号："+account.getAccount()+"，密码："+account.getPwd());
		teacherdao.updateAccount(account);
		return "success";
	}
	//进入修改院长基本信息界面
	public String updateTeacher(){
		System.out.println("accountNom:"+accountNom);
		deans = teacherdao.findAll2(accountNom);//查询院长信息集合
		teacher = deans.get(0);//院长的基本信息和所属院系
		
		System.out.println("院长基本信息id:"+id);
		teacher = teacherdao.findOneTeacher(id);
		System.out.println("修改前院长的基本信息:"+teacher.toString());
		return "success";
	}
	//确认修改院长基本信息
	public String updateTeacher2(){
		System.out.println("修改后的院长基本数据："+teacher.toString());
		teacherdao.updateTeacher(teacher);
		return "success";
	}
	//进入班级界面
	public String grade(){
		System.out.println("进入班级界面");
		System.out.println("teacher:"+teacher.getName());
		String name=teacher.getName();
		session.put("name", name);
		return "success";
	}
	/**
	 * 对学生的操作
	 */
	//删除班级操作
	public String deleteGrade(){
		System.out.println("要删除班级的id:"+gradeId);
		gradedao.deleteGrade(gradeId);
		return "success";
	}
	//确认修改班级操作
	public String updateGrade2(){
		gradedao.updateGrade(grade);
		return "success";
	}
	//进入修改班级信息界面 
	public String updateGrade(){
		System.out.println("班级id:"+gradeId);
		teachers.clear();
		grade = gradedao.findOnegrade(gradeId);
		
		List<Account1> accounts = gradedao.findAllAccount(roleId);//所有辅导员账号的集合
		for(int i=0; i<accounts.size(); i++){
			int accountNom = accounts.get(i).getNom();//每个辅导员账号对应的编号nom
			List<Teacher1> list = gradedao.findAllTeacher(accountNom);//查询单个辅导员信息的集合
			Teacher1 teacher = list.get(0);
			teachers.add(teacher);
		}
		System.out.println("teachers辅导员信息有:"+teachers.size()+"个");
		return "success";
	}
	//删除学生信息
	public String deleteStudent(){
		System.out.println("studentId学生id:"+studentId);
		gradedao.deleteStudent(studentId);
		return "success";
	}
	//查询对应班级的学生信息
	public String findAllStudent(){
		/*
		 * 学生信息与班级匹配
		 */
		System.out.println("gradeId班级id:"+gradeId);
		students = gradedao.findAllStudent(gradeId);
		System.out.println("students对应班级的学生有："+students.size()+"条数据");
		grades = gradedao.findAllGrade();//所有班级信息
		System.out.println("所有班级的数量grades："+grades.size());
		/*
		 * 学生信息与院系匹配
		 */
		/*grade= gradedao.findOnegrade(gradeId);
		collegeId=grade.getTeacher().getCollege().getId();//查询院系的id
		students=gradedao.findAllStudent(collegeId);
		System.out.println("students对应班级的学生有："+students.size()+"条数据");*/
		return "success";
	}
	//进入添加班级信息界面 
	public String addGrade(){
		grade=new Grade1();
		teachers.clear();
		List<Account1> accounts = gradedao.findAllAccount(roleId);//所有辅导员账号的集合
		for(int i=0; i<accounts.size(); i++){
			int accountNom = accounts.get(i).getNom();//每个辅导员账号对应的编号nom
			List<Teacher1> list = gradedao.findAllTeacher(accountNom);//查询单个辅导员信息的集合
			Teacher1 teacher = list.get(0);
			teachers.add(teacher);
		}
		System.out.println("teachers辅导员信息有:"+teachers.size()+"个");
		return "success";
	}
	//进行添加班级操作
	public String addGrade2(){
		System.out.println("班级名称："+grade.getName());
		System.out.println("所属辅导员id："+grade.getTeacher().getId());
		gradedao.addGrade(grade);
		return "success";
	}
	//查询所有班级和对应的所属辅导员
	public String findAllGrade(){
		System.out.println("查询所有班级");
		grades=gradedao.findCollegeGrade(collegeId);
		if(grades!=null){
			System.out.println("grades所有班级有:"+grades.size()+"个");
		}
		name=String.valueOf(session.get("name")).toString();
		System.out.println("name院长名称："+name);
		return "success";
	}
	
	
	/*
	 * 构造方法
	 */
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public TeacherDao getTeacherdao() {
		return teacherdao;
	}
	public void setTeacherdao(TeacherDao teacherdao) {
		this.teacherdao = teacherdao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public List<College1> getColleges() {
		return colleges;
	}
	public void setColleges(List<College1> colleges) {
		this.colleges = colleges;
	}
	public List<Major1> getMajors() {
		return majors;
	}

	public void setMajors(List<Major1> majors) {
		this.majors = majors;
	}
	public int getAccountNom() {
		return accountNom;
	}

	public Teacher1 getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher1 teacher) {
		this.teacher = teacher;
	}

	public void setAccountNom(int accountNom) {
		this.accountNom = accountNom;
	}

	public College1 getCollege() {
		return college;
	}

	public void setCollege(College1 college) {
		this.college = college;
	}

	public List<Major1> getMajors2() {
		return majors2;
	}

	public void setMajors2(List<Major1> majors2) {
		this.majors2 = majors2;
	}

	public Account1 getAccount() {
		return account;
	}

	public void setAccount(Account1 account) {
		this.account = account;
	}

	public Major1 getMajor() {
		return major;
	}

	public void setMajor(Major1 major) {
		this.major = major;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public GradeDao getGradedao() {
		return gradedao;
	}
	public void setGradedao(GradeDao gradedao) {
		this.gradedao = gradedao;
	}
	public List<Teacher1> getDeans() {
		return deans;
	}
	public void setDeans(List<Teacher1> deans) {
		this.deans = deans;
	}
	public List<Grade1> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade1> grades) {
		this.grades = grades;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public List<Student1> getStudents() {
		return students;
	}
	public void setStudents(List<Student1> students) {
		this.students = students;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Grade1 getGrade() {
		return grade;
	}
	public void setGrade(Grade1 grade) {
		this.grade = grade;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public List<Teacher1> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher1> teachers) {
		this.teachers = teachers;
	}
	public AccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
}
