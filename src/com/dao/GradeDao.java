package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.Grade;


import com.entity.dean.Account1;
import com.entity.dean.Grade1;
import com.entity.dean.Role1;
import com.entity.dean.Student1;
import com.entity.dean.Teacher1;
@Repository
public class GradeDao extends HibernateDaoSupport{

	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	public String findGradeName(int id){
		HibernateTemplate template=super.getHibernateTemplate();
		Grade grade=(Grade)template.get(Grade.class, id);
		return grade.getName();
	}
	@SuppressWarnings("unchecked")
	public int findIdByTid(final int teac_id){
		HibernateTemplate template=super.getHibernateTemplate();
		int grad_id=0;
		List<Integer> ids=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session arg0) throws HibernateException,SQLException {
				String hql="select id from Grade where teac_id=?";
				Query query=arg0.createQuery(hql);
				query.setInteger(0, teac_id);
				return query.list();
			}
		});
		if(ids!=null){
			
			grad_id=ids.get(0);
			System.out.println(grad_id);
		return grad_id;}
		else{
			return 0;}
	}
	
	//查询根据辅导员id查询对应的班级
	@SuppressWarnings("unchecked")
	public List<Grade> findAllGrade2(final int teacherId){
		HibernateTemplate template = super.getHibernateTemplate();
		return template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from Grade where teac_id=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, teacherId);
				return query.list();
			}
		});
	}
	//查询所有班级信息和对应所属辅导员
	@SuppressWarnings("unchecked")
	public List<Grade1> findAllGrade() {
		HibernateTemplate template = super.getHibernateTemplate();
		String hql="from Grade1";
		List<Grade1> list = template.find(hql);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Grade> findAllGrade1() {
		HibernateTemplate template = super.getHibernateTemplate();
		String hql="from Grade";
		List<Grade> list = template.find(hql);
		return list;
	}
	//查询专业对应班级
	@SuppressWarnings("unchecked")
	public List<Grade1> findCollegeGrade(final int college_id){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Grade1> grades=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session arg0) throws HibernateException,SQLException {
				Query query=arg0.createQuery("from Grade1 where college_id=?");
				query.setInteger(0, college_id);
				return query.list();
			}
		});
		if(grades!=null){
			return grades;
		}
		return null;
	}
	//查询对应班级的院系的学生信息
	@SuppressWarnings("unchecked")
	public List<Student1> findAllStudent(final int gradeId) {
		HibernateTemplate template = super.getHibernateTemplate();
		final String hql="from Student1 where gradeId=?";
		return template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, gradeId);
				return query.list();
			}
		});
	}
	//删除学生信息
	public void deleteStudent(int studentId) {
		HibernateTemplate template = super.getHibernateTemplate();
		Student1 student=new Student1();
		student.setId(studentId);
		template.delete(student);
		System.out.println("删除成功");
	}
	//进行添加操作
	public void addGrade(Grade1 grade) {
		HibernateTemplate template = super.getHibernateTemplate();
		template.save(grade);
		System.out.println("添加成功");
	}
	//查询所有辅导员的账号
	public List<Account1> findAllAccount(int roleId) {
		HibernateTemplate template = super.getHibernateTemplate();
		Role1 role= (Role1) template.get(Role1.class, roleId);
		Set<Account1> set = role.getAccounts();
		System.out.println("辅导员账号有"+set.size()+"个");
		List<Account1> list=new ArrayList<Account1>(set);
		return list;
	}
	//查询所有辅导员信息
	@SuppressWarnings("unchecked")
	public List<Teacher1> findAllTeacher(final int nom) {
		HibernateTemplate template = super.getHibernateTemplate();
		return template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from Teacher1 where nom=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, nom);
				return query.list();
			}
		});
	}
	//进入修改班级界面(查询一条班级信息)
	public Grade1 findOnegrade(int gradeId) {
		HibernateTemplate template = super.getHibernateTemplate();
		Grade1 grade = (Grade1) template.get(Grade1.class, gradeId);
		return grade;
	}
	//修改班级操作
	public void updateGrade(Grade1 grade) {
		HibernateTemplate template = super.getHibernateTemplate();
		template.update(grade);
		System.out.println("修改成功");
	}
	//删除班级操作
	public void deleteGrade(int GradeId) {
		HibernateTemplate template = super.getHibernateTemplate();
		Grade1 grade=new Grade1();
		grade.setId(GradeId);
		template.delete(grade);
		System.out.println("删除班级成功");
	}
}
