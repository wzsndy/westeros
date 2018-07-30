package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.dao.AccountDao;
import com.dao.CollegeDao;
import com.dao.CourseDao;
import com.dao.GradeDao;
import com.dao.LogDao;
import com.dao.MajorDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.entity.Account;
import com.entity.College;
import com.entity.Course;
import com.entity.Grade;
import com.entity.Log;
import com.entity.Major;
import com.entity.Score;
import com.entity.StuCour;
import com.entity.Student;
import com.entity.Teacher;

@Controller
public class WesterosAction implements SessionAware{

	@Resource
	private AccountDao accountDao;
	@Resource
	private StudentDao studentDao;
	@Resource
	private CollegeDao collegeDao;
	@Resource
	private MajorDao majorDao;
	@Resource
	private GradeDao gradeDao;
	@Resource
	private StudentDao studentdao;
	@Resource
	private CourseDao coursedao;
	@Resource
	private TeacherDao teacherdao;
	@Resource
	private LogDao logDao;
	private Map<String,Object>session;
	private List<Score> scores;
	private List<Course>reqCourses;
	private List<Course>notReqCourses;
	private List<Teacher>teachers;
	private List<Account>accounts;
	private List<StuCour>stucours;
	private List<Major>majors;
	private List<Course>courses;
	private List<Log>logs;
	private Teacher teacher;
	private Course course;
	private StuCour stucour;
	private Student student;
	private Account account;
	private College college;
	private Grade grade;
	private Major major;
	private String pwd;
	private String collegeName;
	private String majorName;
	private String gradeName;
	private int[]courseIds;
	private int role_id;
	private int id;
	private int check;
	private int nom;
	private int page=1;
	private int pageSize=5;
	private int pages;
	
	
	//新生注册验证
	public String checkCreateStuAccount(){
		if(studentdao.findStudentByNum(nom)!=null){
			check=1;
		}else{
			check=0;
		}
		return "success";
	}
	//创建新生账号
	public String createStuAccount(){
		account.setRole_id(4);
		boolean b=accountDao.createTeaAccount(account);
		if(b){
			return "success";
		}
		return "false";
	}
	public String logout(){
		session.put("checkAccount", null);
		ServletActionContext.getRequest().getSession().invalidate();
		return "success";
	}
	@SuppressWarnings("deprecation")
	public String loginAdmin(){
		account=accountDao.findAdmin(account);
		if(account!=null){
			session.put("checkAccount", account);
			session.put("account", account.getAccount());
			Date time=new Date();
			session.put("loginTime",time.toLocaleString());
			return "success";
		}else{
			return "xiaoyang";
		}
	}
	//验证登陆 
	@SuppressWarnings("deprecation")
	public String checkLogin(){
		account=accountDao.findAccount(account);
		if(account!=null){
			session.put("checkAccount", account);
			session.put("account", account.getAccount());
			Date time=new Date();
			session.put("loginTime",time.toLocaleString());
			role_id=account.getRole_id();
			session.put("id", role_id);
			session.put("accountNom", account.getNom());
			if(role_id==2){
				return "dean";
			}else if(role_id==3){
				return "teacher";
			}else if(role_id==4){
				return "student";
			}
		}
		return "error";
	}
	public String findCourse(){
		account=(Account) session.get("checkAccount");
		if(account!=null){
			reqCourses=coursedao.findAllReqCourse(account.getNom());
			notReqCourses=coursedao.findAllNotReqCourse();
			majors=majorDao.findAllMajor();
			return "success";
		}
		return "error";
	}
	public  String findByPageScore(){
		account=(Account) session.get("checkAccount");
		if(account!=null){
			courses=coursedao.findAllCourse();
			scores=studentdao.findByPageScore(page, pageSize,account.getNom());
			pages=studentdao.getPages(pageSize);
			return "success";
		}
		return "error";
	}
	public String selectCourse(){
		account=(Account) session.get("checkAccount");
		if(courseIds!=null){
	  for(int i=0;i<courseIds.length;i++){
		  StuCour stucour=new StuCour();
		  stucour.setCourse_id(courseIds[i]);
		  stucour.setStu_no(account.getNom());
		  coursedao.selectCourse(stucour);
	  }
	  reqCourses=coursedao.findAllReqCourse(account.getNom());
	  for(Course c:reqCourses){
		  StuCour stucour=new StuCour();
		  stucour.setCourse_id(c.getId());
		  stucour.setStu_no(account.getNom());
		  coursedao.selectCourse(stucour);
	  }
		return "success";
		}
		return "error";	
	}
	public String findStudent(){
		student=studentDao.findStudent(account);
		collegeName=collegeDao.findCollegeName(student.getCollege_id());
		majorName=majorDao.findMajorName(student.getMajor_id());
		gradeName=gradeDao.findGradeName(student.getGrade_id());
		return "success";
	}
	public String findStudentById(){
		student=studentDao.findStudentById(id);
		account=accountDao.findAccountByNom(student.getNomber());
		return "success";
	}
	public String updatePassword(){
		accountDao.updatePassword(student.getNomber(), pwd);
		session.put("checkAccount", null);
		return "success";
	}
	public String findSelectCourse(){
		account=(Account) session.get("checkAccount");
		if(account!=null){
			stucours=coursedao.findSelectCourse(account.getNom());
			for(int i=0;i<stucours.size();i++){
				int cid=stucours.get(i).getCourse_id();
				for(int j=0;j<stucours.size();j++){
					int cid1=stucours.get(j).getCourse_id();
					if(cid==cid1&&i!=j){
						stucours.remove(j);
					}	
				}
			}
			courses=coursedao.findAllCourse();
			return "success";
		}
		return "error";
	}
	public String findTeacherByPage(){
		teachers=teacherdao.findTeacherByPage(page, pageSize);
		pages=teacherdao.getPages(pageSize);
		if(page>pages){
			page=1;
		}
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
		accounts=accountDao.findTeacherAccount();
		teachers=teacherdao.findAllTeacher();
		for(Teacher t:teachers){
			if(t.getNomber()==account.getNom()){
				boolean f=accountDao.createTeaAccount(account);
				if(f){
					return "success";
				}else{
					return "error";
				}
			}
		}
		return "error";
	}
	public String getAdminAccount(){
		account=accountDao.findAdminAccount(account);
		if(account!=null){
			return "success";
		}
		return "error";
	}
	public String updateAdminPassword(){
		accountDao.updatePassword(account.getNom(), pwd);
		return "success";
	}
	public String checkTeaAccount(){
		check=teacherdao.findTeaNom(nom);
		return "success";
	}
	public Account finda(){
		account=accountDao.findAccount(account);
		return account;
	}
	public String findLogDate(){
		logs=logDao.findLogByPage(page, pageSize);
		pages=logDao.getPages(pageSize);
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public AccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int roleId) {
		role_id = roleId;
	}
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public CollegeDao getCollegeDao() {
		return collegeDao;
	}
	public void setCollegeDao(CollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public MajorDao getMajorDao() {
		return majorDao;
	}
	public void setMajorDao(MajorDao majorDao) {
		this.majorDao = majorDao;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public GradeDao getGradeDao() {
		return gradeDao;
	}
	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public StudentDao getStudentdao() {
		return studentdao;
	}
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}
	public CourseDao getCoursedao() {
		return coursedao;
	}
	public void setCoursedao(CourseDao coursedao) {
		this.coursedao = coursedao;
	}
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
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
	public List<Course> getReqCourses() {
		return reqCourses;
	}
	public void setReqCourses(List<Course> reqCourses) {
		this.reqCourses = reqCourses;
	}
	public List<Course> getNotReqCourses() {
		return notReqCourses;
	}
	public void setNotReqCourses(List<Course> notReqCourses) {
		this.notReqCourses = notReqCourses;
	}
	public StuCour getStucour() {
		return stucour;
	}
	public void setStucour(StuCour stucour) {
		this.stucour = stucour;
	}
	public int[] getCourseIds() {
		return courseIds;
	}
	public void setCourseIds(int[] courseIds) {
		this.courseIds = courseIds;
	}
	public List<StuCour> getStucours() {
		return stucours;
	}
	public void setStucours(List<StuCour> stucours) {
		this.stucours = stucours;
	}
	public List<Major> getMajors() {
		return majors;
	}
	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public TeacherDao getTeacherdao() {
		return teacherdao;
	}
	public void setTeacherdao(TeacherDao teacherdao) {
		this.teacherdao = teacherdao;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public int getNom() {
		return nom;
	}
	public void setNom(int nom) {
		this.nom = nom;
	}
//	public HttpSession getHs() {
//		return hs;
//	}
//	public void setHs(HttpSession hs) {
//		this.hs = hs;
//	}
	public LogDao getLogDao() {
		return logDao;
	}
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	public List<Log> getLogs() {
		return logs;
	}
	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}
	
}
