package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dao.AccountDao;
import com.dao.CollegeDao;
import com.dao.CourseDao;
import com.dao.GradeDao;
import com.dao.CounsellorDao;
import com.dao.MajorDao;
import com.dao.StudentDao;
import com.entity.Account;
import com.entity.College;
import com.entity.Course;
import com.entity.Grade;
import com.entity.Major;
import com.entity.Score;
import com.entity.Student;
import com.entity.Teacher;

@Controller
public class CounsellorAction {
	@Resource
	private CounsellorDao dao;
	@Resource
	private GradeDao gradeDao;
	@Resource
	private MajorDao majorDao;
	@Resource
	private CollegeDao collegeDao;
	@Resource
	private StudentDao studentDao;
	@Resource
	private CourseDao courseDao;
	private List<Student> students;
	private List<Score> scores;
	private List<College>colleges;
	private List<Major>majors;
	private List<Grade>grades;
	private List<Course>courses;
	private int page=1;
	private int pageSize=10;
	private int pages;
	private Teacher teacher;
	private Student student;
	private Account account;
	private Score score;
	private int nomber;
	@Resource
	private WesterosAction w;
	public WesterosAction getW() {
		return w;
	}

	public void setW(WesterosAction w) {
		this.w = w;
	}
	private long stu_no;
	private int id;
	@Resource
	private AccountDao accountDao;
	//辅导员身份验证
	public String checkTeacher(){
		account=w.finda();
		int nom=account.getNom();
		int teac_id=dao.findIdByNom(nom);
		int grade_id=gradeDao.findIdByTid(teac_id);
		students=dao.findAll(grade_id);
		grades=gradeDao.findAllGrade1();
		majors=majorDao.findAllMajor();
		colleges=collegeDao.findAllCollege();
		return "success";
	}
	//修改学员信息
	public String update(){
		dao.updateStudent(student);
		return "success";
	}
	//查询学员信息
	public String findStudentById(){
		student=dao.findstudentById(id);
		return "success";
	}
	//删除学员信息
	public String deletedStudent(){
		dao.deletedStudent(id);
		return "success";
	}
	//添加学员信息
	public String addStudent(){
		if(student.getName()!=null&student.getBirthday()!=null&student.getCollege_id()!=0&student.getMajor_id()!=0&student.getGrade_id()!=0){
			int nom=students.size()+1;
			String nomb="";
			if(nom<10){
				nomb="330"+student.getGrade_id()+"0"+nom;
			}else{
				nomb="330"+student.getGrade_id()+nom;
			}
			Integer nomber=Integer.parseInt(nomb);
			student.setNomber(nomber);
			dao.saveStudent(student);
			return "success";
		}
		return "error";
	}
	//保持修改
public String updatesave(){
	dao.updatesave(score);
	return "success";
}
	//查询所有学习成绩
	public String findScore(){
		student=null;
		scores=dao.findScore(nomber);
		student=studentDao.findStudentByNum(nomber);
		courses=courseDao.findAllCourse();
		return "success";
	}
	//通过id查询成绩
	public String findscoreBystu_no(){
		System.out.println(id);
		score=dao.findscoreBystu_no(id);
		courses=courseDao.findAllCourse();
		return "success";
	}
	//修改成绩
	public String updatescore(){
		dao.updateScore(score);
		return "sucess";
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	//	public String findStudents(){
//		students=dao.findAll();
//		 return "success";
//	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public CounsellorDao getDao(){
		return dao;
	}
	public void setDao(CounsellorDao dao){
		this.dao=dao;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public GradeDao getGradeDao() {
		return gradeDao;
	}

	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public int getNomber() {
		return nomber;
	}

	public void setNomber(int nomber) {
		this.nomber = nomber;
	}

	public long getStu_no() {
		return stu_no;
	}

	public void setStu_no(long stuNo) {
		stu_no = stuNo;
	}

	public MajorDao getMajorDao() {
		return majorDao;
	}

	public void setMajorDao(MajorDao majorDao) {
		this.majorDao = majorDao;
	}

	public CollegeDao getCollegeDao() {
		return collegeDao;
	}

	public void setCollegeDao(CollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
