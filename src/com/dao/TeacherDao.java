package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.Teacher;

import com.entity.dean.Account1;
import com.entity.dean.College1;
import com.entity.dean.Major1;
import com.entity.dean.Role1;
import com.entity.dean.Teacher1;
@Repository
public class TeacherDao extends HibernateDaoSupport {
	public boolean saveTeacher(Teacher tea) {
		HibernateTemplate tem=super.getHibernateTemplate();
		if(tea!=null){
			tem.save(tea);
			return true;
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public List<Teacher> findTeacherByPage(final int page,final int pageSize){
		HibernateTemplate tem=super.getHibernateTemplate();
		return	tem.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery("from Teacher");
				query.setFirstResult(pageSize*(page-1));
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}
	@SuppressWarnings("unchecked")
	public int getPages(int pageSize){
		HibernateTemplate tem=super.getHibernateTemplate();
		List<Teacher>list=tem.find("from Teacher");
		if(list!=null){
		int records=list.size();
		return records%pageSize==0?records/pageSize:records/pageSize+1;
		}else{
			return 0;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Teacher> findAllTeacher(){
		HibernateTemplate tem=super.getHibernateTemplate();
		return tem.find("from Teacher");
	}
	@SuppressWarnings("unchecked")
	public int findTeaNom(final int nom) {
		HibernateTemplate template=super.getHibernateTemplate();
		List<Teacher>teas= template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query=session.createQuery("from Teacher where nomber=?");
				query.setInteger(0, nom);
				return query.list();
			}
		});
		if(teas.size()==0){
			return 0;
		}
		return 1;
	}
	@Resource
	public void setSF(SessionFactory sf){	
		super.setSessionFactory(sf);
	}
	
	
	
	//查询院长所属角色
	@SuppressWarnings("unchecked")
	public List<Role1> findAll(final int id) {
		System.out.println("进入TeacherDao_findAll");
		HibernateTemplate template = super.getHibernateTemplate();
		final String hql="from Role1 where id=?";
		return template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, id);
				return query.list();
			}
		});
	}
	//查询院长信息和所属院系
	@SuppressWarnings("unchecked")
	public List<Teacher1> findAll2(final int nom) {
		System.out.println("进入TeacherDao_findAll2");
		HibernateTemplate template = super.getHibernateTemplate();
		final String hql="from Teacher1 where nom=?";
		return template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, nom);
				return query.list();
			}
		});
	}
	//查询院长所属专业
	@SuppressWarnings("unchecked")
	public List<Major1> findAll3(final int collegeId){
		System.out.println("进入TeacherDao_findAll3");
		HibernateTemplate template = super.getHibernateTemplate();
		final String hql="from Major1 where collegeId=?";
		return template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0, collegeId);
				return query.list();
			}
		});
	}
	//进入添加界面(查询所有专业)
	@SuppressWarnings("unchecked")
	public List<Major1> findAllMajor() {
		HibernateTemplate template = super.getHibernateTemplate();
		String hql="from Major1";
		List<Major1> list = template.find(hql);
		return list;
	}
	//进入添加界面(查询所有院系)
	@SuppressWarnings("unchecked")
	public List<College1> findAllCollege(){
		HibernateTemplate template = super.getHibernateTemplate();
		String hql="from College1";
		List<College1> list = template.find(hql);
		return list;
	}
	//确认添加的操作
	public void addMajor(Major1 major){
		HibernateTemplate template = super.getHibernateTemplate();
		template.save(major);
	}
	//进入修改界面
	public Major1 findOne( int id) {
		HibernateTemplate template = super.getHibernateTemplate();
		Major1 major = (Major1) template.get(Major1.class, id);
		return major;
	}
	//进入修改账号界面（根据编号查询数据）
	@SuppressWarnings("unchecked")
	public List<Account1> findOne2(final int accountNom) {
		HibernateTemplate template = super.getHibernateTemplate();
		return template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from Account1 where nom=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, accountNom);
				return query.list();
			}
		});
	}
	//确认修改账号操作
	public void updateAccount(Account1 account){
		HibernateTemplate template = super.getHibernateTemplate();
		template.update(account);
		System.out.println("修改账号成功");
	}
	//确定修改专业操作
	public void updateMajor2(Major1 major) {
		HibernateTemplate template = super.getHibernateTemplate();
		template.update(major);
		System.out.println("专业修改成功");
	}
	//删除专业操作
	public void deleteMajor(int id) {
		HibernateTemplate template = super.getHibernateTemplate();
		Major1 major=new Major1();
		major.setId(id);
		template.delete(major);
		System.out.println("删除成功");
	}
	//查询院长基本信息
	public Teacher1 findOneTeacher(int id) {
		HibernateTemplate template = super.getHibernateTemplate();
		Teacher1 teacher = (Teacher1) template.get(Teacher1.class, id);
		return teacher;
	}
	//确认修改院长基本信息
	public void updateTeacher(Teacher1 teacher) {
		HibernateTemplate template = super.getHibernateTemplate();
		template.update(teacher);
		System.out.println("修改院长基本信息成功");
	}
}
