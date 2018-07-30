package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.Major;

@Repository
public class MajorDao extends HibernateDaoSupport{

	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	public String findMajorName(int id){
		HibernateTemplate template=super.getHibernateTemplate();
		Major major=(Major) template.get(Major.class, id);
		return major.getName();
	}
	@SuppressWarnings("unchecked")
	public List<Major> findAllMajor(){
		HibernateTemplate template=super.getHibernateTemplate();
		String hql="from Major";
		List<Major>majors=template.find(hql);
		return majors;
	}
}
