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

import com.entity.Score;
import com.entity.Student;

@Repository
public class CounsellorDao extends HibernateDaoSupport {
	@Resource

	public void SF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	@SuppressWarnings("unchecked")
	public List<Student> findAll(final int id){
		HibernateTemplate template=super.getHibernateTemplate();
		
		List<Student> students=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
			SQLException {
				String hql="from Student where grade_id=?";
				Query query=session.createQuery(hql);
				query.setInteger(0, id);
				return query.list();
			}
		});
			return students;
		
	}
	@SuppressWarnings("unchecked")
	public int findIdByNom(final int nom){
		HibernateTemplate template=super.getHibernateTemplate();
		int teac_id=0;
		List<Integer> ids=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session arg0) throws HibernateException,SQLException {
				String hql="select id from Teacher where nom=?";
				Query query=arg0.createQuery(hql);
				query.setInteger(0, nom);
				return query.list();
			}
		});
		teac_id=ids.get(0);
		System.out.println("##################"+teac_id);
			return teac_id;
		
	}
	
	public Student findstudentById(int id) {
		HibernateTemplate template=super.getHibernateTemplate();
		Student student=(Student) template.get(Student.class,id);
		return student;
		// TODO Auto-generated method stub
		
	}

	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		HibernateTemplate template= super.getHibernateTemplate();
		template.save(student);
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		HibernateTemplate template= super.getHibernateTemplate();
		template.update(student);
	}
	public void updatesave(Score score){
		HibernateTemplate template= super.getHibernateTemplate();
		template.update(score);
	}
public void updateScore(Score score){
	HibernateTemplate template= super.getHibernateTemplate();
	template.update(score);
}
	public void deletedStudent(int id) {
		HibernateTemplate template=super.getHibernateTemplate();
		Student student=new Student();
		student.setId(id);
		template.delete(student);
	}
	public Score findscoreBystu_no(int id){
		HibernateTemplate template=super.getHibernateTemplate();
		Score score=(Score) template.get(Score.class,id);
		return score;
	}
	@SuppressWarnings("unchecked")
	public List<Score> findScore(final int nomber){
		HibernateTemplate tem=super.getHibernateTemplate();
		
		
		List<Score> scores=tem.executeFind(new HibernateCallback() {
			
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
		            String hql="from Score where stu_no=?";
	            Query query=session.createQuery(hql);
	            query.setInteger(0, nomber);
	            
				return  query.list();
			}
		} );
		return scores;
	}
	public int getPages(int pageSize){
		HibernateTemplate tem=super.getHibernateTemplate();
		int records=tem.find("from Score").size();
		return records/pageSize==0?records/pageSize:records/pageSize+1;
	}
}
