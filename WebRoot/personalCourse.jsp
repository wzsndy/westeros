<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Student page</title>
	<meta content="charset=utf-8">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/student.css"/>
  </head>
  
  <body style="background:url(<%=request.getContextPath() %>/img/4.jpg) no-repeat;background-size:cover;">
  <div class="admin">
  		<div class="admin-head">
  			<div class="logo"></div>
  			<div class="title">Westeros University</div>
  			<div class="tool">
  				<a href="westeros/help">帮助</a>
  				<a href="westeros/logout">退出</a>
  				<a href="">更多</a>
  			</div>
  		</div>
  		<div class="student-page">
    		<div class="student-title">${student.name}同学，欢迎登陆维斯特洛学院</div>
    		<div class="student-menu">
    			<ul>
    			<li><a href="checkStudent">基本信息</a></li>
    			<li><a href="modifyPassword?id=${student.id}">修改密码</a></li>
    			<li><a href="westeros/score">查询成绩</a></li>
    			<li><a href="westeros/course">已选课程</a></li>
    			<li><a href="westeros/sel">选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课</a></li>
    			</ul>
    		</div>
    		<div class="student-content">
    			<table border="1" cellpadding="0" cellspacing="0" style="margin:0 auto;">
    				<tr><th>${student.name}</th><th>&nbsp;已选课程</th></tr>
    				<s:iterator value="stucours">
    				<tr>
    				<td colspan="2">
    				<s:iterator value="courses">
    					<s:if test="id==course_id">
    						<s:property value="name"/>
    					</s:if>
    				</s:iterator>
    				</tr>
    				</s:iterator>
   	 			</table>
    		</div>
    	</div>
    	<div class="admin-foot">
    	<center>
  			<h4 style="color:red">Westeros Ice and Fire</h4>
  		</center>
    	</div>
  	</div>
  </body>
</html>
