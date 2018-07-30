<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  				<a href="help">帮助</a>
  				<a href="logout">退出</a>
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
    			<table style="margin:0 auto;">
    				<tr><td colspan=2 class="t-head">StudentMessage</td></tr>
    				<tr><td>姓名：</td><td>${student.name}</td></tr>
    				<tr><td>学号：</td><td>${student.nomber}</td></tr>
    				<tr><td>生日</td><td>${student.birthday}</td></tr>
    				<tr><td>学院：</td><td>${collegeName}</td></tr>
    				<tr><td>专业：</td><td>${majorName}</td></tr>
    				<tr><td>班级：</td><td>${gradeName}</td></tr>
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
