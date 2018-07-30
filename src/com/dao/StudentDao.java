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

import com.entity.Account;
import com.entity.Score;
import com.entity.Student;
@Repository
public class StudentDao extends HibernateDaoSupport{

	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	@SuppressWarnings("unchecked")
	public Student findStudent(final Account account){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Student> stus=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				String hql="from Student where nom=?";
				Query query=session.createQuery(hql);
				query.setInteger(0, account.getNom());
				List<Student>sts=query.list();
				if(sts.size()!=0){
					return sts;
				}else{
					return null;
				}
			}
		});
		if(stus!=null){
			return stus.get(0);
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public Student findStudentByNum(final int nom){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Student> stus=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				String hql="from Student where nom=?";
				Query query=session.createQuery(hql);
				query.setInteger(0, nom);
				List<Student>sts=query.list();
				if(sts.size()!=0){
					return sts;
				}else{
					return null;
				}
			}
		});
		if(stus!=null){
			return stus.get(0);
		}else{
			return null;
		}
	}
	public Student findStudentById(int id){
		HibernateTemplate template=super.getHibernateTemplate();
		Student student=(Student)template.get(Student.class, id);
		return student;
	}
	@SuppressWarnings("unchecked")
	public List<Score> findAllScore(){
		HibernateTemplate tem=super.getHibernateTemplate();
		List<Score> scores=tem.find("from Score");
		return scores;
	}
	
	@SuppressWarnings("unchecked")
	public List<Score> findByPageScore(final int page,final int pageSize,final long stu_id){
		HibernateTemplate tem=super.getHibernateTemplate();
		return tem.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
			   String stuId=stu_id+"";
			   stuId=stuId.substring(0, stuId.length()-2);
	            String hql="from Score where stu_no like '"+stuId+"%'";
	            Query query=session.createQuery(hql);
	            query.setFirstResult((page-1)*pageSize);
	            query.setMaxResults(pageSize);  
				return  query.list();
			}
		} );
	}
	public int getPages(int pageSize){
		HibernateTemplate tem=super.getHibernateTemplate();
		int records=tem.find("from Score").size();
		return (records%pageSize==0)?(records/pageSize):(records/pageSize+1);
	}
}
