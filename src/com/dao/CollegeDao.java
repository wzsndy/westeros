package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.College;

@Repository
public class CollegeDao extends HibernateDaoSupport{

	@Resource
	public void seSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	public String findCollegeName(int id){
		HibernateTemplate template=super.getHibernateTemplate();
		College college=(College) template.get(College.class, id);
		return college.getName();
	}
	@SuppressWarnings("unchecked")
	public List<College> findAllCollege() {
		HibernateTemplate template = super.getHibernateTemplate();
		String hql="from College";
		List<College> list = template.find(hql);
		return list;
	}
}
