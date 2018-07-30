package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dao.CourseDao;
import com.dao.StudentDao;
import com.entity.Course;
import com.entity.Score;
import com.entity.StuCour;
import com.entity.Student;

@Controller
public class StudentAction {

	@Resource
	private StudentDao studentdao;
	@Resource
	private CourseDao coursedao;
	private List<Score> scores;
	private int page=1;
	private int pageSize=10;
	private int pages=1;
	private List<Course>reqCourses;
	private List<Course>notReqCourses;
	private Course course;
	private StuCour stucour;
	private Student student;
	private int[]courseIds;
	private List<StuCour>stucours;
	
	public  String findByPageScore(){
		scores=studentdao.findByPageScore(page, pageSize,330101);
		pages=studentdao.getPages(pageSize);
		return "success";
	}
	
//	public String findCourse(){
//		reqCourses=coursedao.findAllReqCourse();
//		notReqCourses=coursedao.findAllNotReqCourse();
//		return "success";
//	}
	
//	public String selectCourse(){
//		if(courseIds!=null){
//	  for(int i=0;i<courseIds.length;i++){
//		  StuCour stucour=new StuCour();
//		  stucour.setCourse_id(courseIds[i]);
//		  stucour.setStu_no(330101);
//		  coursedao.selectCourse(stucour);
//	  }
//	  reqCourses=coursedao.findAllReqCourse();
//	  for(Course c:reqCourses){
//		  StuCour stucour=new StuCour();
//		  stucour.setCourse_id(c.getId());
//		  stucour.setStu_no(330101);
//		  coursedao.selectCourse(stucour);
//	  }
//		return "success";
//		}
//		return "error";
//		
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	public StudentDao getStudentdao() {
		return studentdao;
	}
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
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

	public CourseDao getCoursedao() {
		return coursedao;
	}

	public void setCoursedao(CourseDao coursedao) {
		this.coursedao = coursedao;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public StuCour getStucour() {
		return stucour;
	}

	public void setStucour(StuCour stucour) {
		this.stucour = stucour;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	

	
	
	
	
}
