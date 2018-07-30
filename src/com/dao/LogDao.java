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

import com.entity.Log;
@Repository
public class LogDao extends HibernateDaoSupport{

	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	public void saveLog(String account,String login,String logout){
		HibernateTemplate template=super.getHibernateTemplate();
		Log log=new Log();
		log.setAccount(account);
		log.setLogin(login);
		log.setLogout(logout);
		template.save(log);
	}
	public void saveLog(Log log){
		HibernateTemplate template=super.getHibernateTemplate();
		if(log!=null){
			template.save(log);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Log> findLogByPage(final int page,final int pageSize){
		HibernateTemplate template=super.getHibernateTemplate();
		return (List<Log>) template.execute(new HibernateCallback() {
			public Object doInHibernate(Session arg0) throws HibernateException,SQLException {
				Query query=arg0.createQuery("from Log");
				query.setFirstResult((page-1)*pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}
	@SuppressWarnings("unchecked")
	public int getPages(int pageSize){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Log> list=template.find("from Log");
		if(list!=null){
			int records=list.size();
			return (records%pageSize==0)?(records/pageSize):(records/pageSize+1);
		}
		return 1;
	}
}
