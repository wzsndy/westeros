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
import com.entity.dean.Account1;

@Repository
public class AccountDao extends HibernateDaoSupport{
	
	@Resource
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	//有角色id找到账号
	@SuppressWarnings("unchecked")
	public List<Account1> findAccountByRoleId(final int role_id){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Account1> accounts=template.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				String hql="from Account1 where role_id=? order by id asc";
				Query query=session.createQuery(hql);
				query.setInteger(0, role_id);
				return query.list();
			}
		});
		return accounts;
	}

	//检查账号密码是否存在
	@SuppressWarnings("unchecked")
	public Account findAccount(final Account ac){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Account> accounts=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				String hql="from Account where nom=? and pwd=?";
				Query query=session.createQuery(hql);
				query.setInteger(0, ac.getNom());
				query.setString(1, ac.getPwd());
				List<Account> acs=query.list();
				if(acs.size()!=0){
					return acs;
				}else{
					return null;
				}	
			}
		});
		if(accounts!=null){
			Account account=accounts.get(0);
			return account;
		}else{
			return null;
		}	
	}
	@SuppressWarnings("unchecked")
	public Account findAdminAccount(final Account ac){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Account> accounts=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				String hql="from Account where account=? and pwd=?";
				Query query=session.createQuery(hql);
				query.setString(0, ac.getAccount());
				query.setString(1, ac.getPwd());
				List<Account> acs=query.list();
				if(acs.size()!=0){
					return acs;
				}else{
					return null;
				}	
			}
		});
		if(accounts!=null){
			Account account=accounts.get(0);
			return account;
		}else{
			return null;
		}	
	}
	@SuppressWarnings("unchecked")
	public Account findAdmin(final Account ac){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Account> accounts=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				String hql="from Account where account=? and pwd=?";
				Query query=session.createQuery(hql);
				query.setString(0, ac.getAccount());
				query.setString(1, ac.getPwd());
				List<Account> acs=query.list();
				if(acs.size()!=0){
					return acs;
				}else{
					return null;
				}	
			}
		});
		if(accounts!=null){
			Account account=accounts.get(0);
			return account;
		}else{
			return null;
		}	
	}
	@SuppressWarnings("unchecked")
	public Account findAccountByNom(final int nom){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Account> accounts=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				String hql="from Account where nom=?";
				Query query=session.createQuery(hql);
				query.setInteger(0,nom);
				List<Account> acs=query.list();
				if(acs.size()!=0){
					return acs;
				}else{
					return null;
				}	
			}
		});
		if(accounts!=null){
			Account account=accounts.get(0);
			return account;
		}else{
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public void updatePassword(final int nom,String pwd){
		HibernateTemplate template=super.getHibernateTemplate();
		List<Account> accounts=template.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				String hql="from Account where nom=?";
				Query query=session.createQuery(hql);
				query.setInteger(0,nom);
				List<Account> acs=query.list();
				if(acs.size()!=0){
					return acs;
				}else{
					return null;
				}	
			}
		});
		if(accounts!=null){
			Account account=accounts.get(0);
			account.setPwd(pwd);
			template.update(account);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Account> findTeacherAccount(){
		HibernateTemplate tem=super.getHibernateTemplate();
		return tem.executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session se) throws HibernateException,
					SQLException {
				Query query=se.createQuery("from Account where role_id='2' or role_id='3'");
				return query.list();
			}
		});
		
	} 
	public boolean createTeaAccount(Account acc){
		HibernateTemplate tem=super.getHibernateTemplate();
		if(acc!=null){
		tem.save(acc);
		return true;
		}
		return false;
	}
}
