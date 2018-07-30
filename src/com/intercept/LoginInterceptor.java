package com.intercept;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class LoginInterceptor implements Interceptor{

	public void destroy() {	
	}
	public void init() {	
	}
	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String,Object>session=arg0.getInvocationContext().getSession();
		Object checkAccount=session.get("checkAccount");
		if(checkAccount==null){
			return "error";
		}else{
			arg0.invoke();
			return "success";
		}
	}

}
