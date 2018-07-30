package com.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dao.LogDao;
import com.entity.Log;
public class LoginListener implements HttpSessionListener{

	private String loginTime;
	@SuppressWarnings("deprecation")
	public void sessionCreated(HttpSessionEvent arg0) {
		Date time=new Date();
		loginTime=time.toLocaleString();
		System.out.println("访问登陆页面时间："+loginTime);
	}

	@SuppressWarnings("deprecation")
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession hs=arg0.getSession();
		//获取loginTime时间
		Object logintime=hs.getAttribute("loginTime");
		loginTime=String.valueOf(logintime);
		//获取account账号
		Object account= hs.getAttribute("account");
		String acc=String.valueOf(account);
		//获取退出时间
		Date time=new Date();
		String logoutTime=time.toLocaleString();
		
		System.out.println(loginTime+"***"+logoutTime+"^^^"+acc);
		
		LogDao logDao=(LogDao)this.getObjectFromApplication(hs.getServletContext(),"logDao");
		Log log=new Log();
		log.setAccount(acc);
		log.setLogin(loginTime);
		log.setLogout(logoutTime);
		if(account!=null){
			logDao.saveLog(log);
		}
		System.out.println("退出时间"+logoutTime);
	}
	
	 private Object getObjectFromApplication(ServletContext servletContext,String beanName) {
	        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	        return applicationContext.getBean(beanName);
	 }
}
