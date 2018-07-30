package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.dao.CourseDao;
import com.dao.GradeDao;
import com.entity.Account;
import com.entity.Grade;
import com.entity.dean.Account1;
import com.entity.dean.Grade1;
import com.entity.dean.Score1;
import com.entity.dean.Student1;
import com.entity.dean.Teacher1;

@Controller
public class GradeAction implements SessionAware{

	@Resource
	private GradeDao gradedao;//班级的dao
	@Resource
	private CourseDao coursedao;
	private List<Grade1> grades;//所有班级信息
	private Map<String, Object> session;
	private String name;//院长名称
	private int gradeId;//班级id
	private List<Student1> students;
	private int studentId;//学生id
	private Grade1 grade;//班级实体类
	private int roleId=3;//辅导员的id
	private List<Teacher1> teachers=new ArrayList<Teacher1>();//所有辅导员信息集合
	private int collegeId;//院系id
	private int accountNom;//账号的编号
	private List<Score1> scores1=new ArrayList<Score1>();//所有学生的成绩
	private Account account;
	
	
	//查询班级对应的学生成绩
	public String gradeScore(){
		System.out.println("进入查询班级对应学生的成绩");
		account=(Account) session.get("checkAccount");
		//students.clear();
		scores1.clear();
		System.out.println("ssssssssss");
		accountNom=Integer.parseInt(session.get("accountNom").toString());
		System.out.println("账号的编号accountNom："+accountNom);
		List<Teacher1> list = gradedao.findAllTeacher(accountNom);//查询辅导员信息
		int teacherId = list.get(0).getId();//辅导员的id
		List<Grade> grades2 = gradedao.findAllGrade2(teacherId);//查询辅导员对应的班级
		int gradesId = grades2.get(0).getId();//获取班级的id
		System.out.println("gradesId班级的id:"+gradesId);
		students = gradedao.findAllStudent(gradesId);//班级对应的所有学生信息
		System.out.println("班级对应的学生有students："+students.size()+"位");
		
		for(int i=0; i<students.size(); i++){
			int nom = students.get(i).getNom();//学生信息中的编号
			List<Score1> list2 = coursedao.findAllCourse2(nom);//学生对应的成绩
			scores1.addAll(list2);
			
		}
		return "success";
	}
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
		grades=gradedao.findAllGrade();
		System.out.println("grades所有班级有:"+grades.size()+"个");
		name=session.get("name").toString();
		System.out.println("name院长名称："+name);
		return "success";
	}
	/*
	 * 构造方法
	 */
	public GradeDao getGradedao() {
		return gradedao;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setGradedao(GradeDao gradedao) {
		this.gradedao = gradedao;
	}
	public List<Teacher1> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher1> teachers) {
		this.teachers = teachers;
	}
	public List<Grade1> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade1> grades) {
		this.grades = grades;
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public List<Student1> getStudents() {
		return students;
	}
	public void setStudents(List<Student1> students) {
		this.students = students;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public Grade1 getGrade() {
		return grade;
	}
	public void setGrade(Grade1 grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CourseDao getCoursedao() {
		return coursedao;
	}
	public void setCoursedao(CourseDao coursedao) {
		this.coursedao = coursedao;
	}
	public int getAccountNom() {
		return accountNom;
	}
	public void setAccountNom(int accountNom) {
		this.accountNom = accountNom;
	}
	public List<Score1> getScores1() {
		return scores1;
	}
	public void setScores1(List<Score1> scores1) {
		this.scores1 = scores1;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
