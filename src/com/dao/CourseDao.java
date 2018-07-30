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

import com.entity.Course;
import com.entity.StuCour;
import com.entity.Student;
import com.entity.dean.Score1;

@Repository
public class CourseDao extends HibernateDaoSupport{

	@SuppressWarnings("unchecked")
	public List<Course> findAllReqCourse(final int stu_nom){
		HibernateTemplate tem=super.getHibernateTemplate();
		return tem.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery("from Student where nom=?");
				query.setLong(0, stu_nom);
				if(query.list()!=null){
					Student s=(Student) query.list().get(0);
					int mId=s.getMajor_id();
					String hql="from Course where isRequired='yes' and major_id=?";
					 query=session.createQuery(hql);
					 query.setInteger(0,mId);
					 return query.list();
				}
				return null;
			}
		});
	}
	//根据学生编号查询成绩
	@SuppressWarnings("unchecked")
	public List<Score1> findAllCourse2(final int studentNom){
		HibernateTemplate template = super.getHibernateTemplate();
		return template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from Score1 where studentNom=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, studentNom);
				return query.list();
			}
		});
	}
	@SuppressWarnings("unchecked")
	public List<Course>findAllNotReqCourse(){
		HibernateTemplate tem=super.getHibernateTemplate();
		return tem.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from Course where isRequired='no'";
				Query query=session.createQuery(hql);
				return query.list();
			}
		});
	}
	public boolean selectCourse(StuCour stucour){
		HibernateTemplate tem=super.getHibernateTemplate();
		if(stucour==null){
			return false;
		}
		tem.save(stucour);
		return true;
	}
	@SuppressWarnings("unchecked")
	public List<StuCour> findSelectCourse(final long stu_no){
		HibernateTemplate tem=super.getHibernateTemplate();
		return	tem.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery("from StuCour where stu_no=?");
				query.setLong(0, stu_no);
				return query.list();
			}
		});
	}
	@SuppressWarnings("unchecked")
	public List<Course> findAllCourse(){
		HibernateTemplate template=super.getHibernateTemplate();
		String hql="from Course";
		List<Course>courses=template.find(hql);
		return courses;
	}
	
	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
}
