<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
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
    			<li><a href="westeros/checkStudent">基本信息</a></li>
    			<li><a href="westeros/modifyPassword?id=${student.id}">修改密码</a></li>
    			<li><a href="westeros/score">查询成绩</a></li>
    			<li><a href="westeros/course">已选课程</a></li>
    			<li><a href="westeros/sel">选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课</a></li>
    			</ul>
    		</div>
    		<div class="student-content">
		    	<table border="1" cellpadding="0" cellspacing="0" style="margin:0 auto;">
		    		<tr><td>考试时间</td><td>考试科目</td><td>学生学号</td><td>分数</td><td>学期</td></tr>
		    		<s:iterator value="scores">
		     		<tr>
		     		<td><s:property value="year"/></td>
		     		<td>
		     			<s:iterator value="courses">
		     				<s:if test="course_id==id">
		     					<s:property value="name"/>
		     				</s:if>
		     			</s:iterator>
		     		</td>
		     		<td><s:property value="stu_no"/></td>
		     		<td><s:property value="score"/></td>
		    		<td><s:property value="term"/></td>
		    		</tr>
		    		</s:iterator>
		    		<tr>
		    		<td colspan="1">
		    		<c:choose>
		    			<c:when test="${page>1}"><a href="westeros/score?page=${page-1}">上一页</a></c:when>
		    			<c:otherwise><a href="westeros/score?page=${page}">上一页</a></c:otherwise>
		    		</c:choose>
		    		</td>
		     		<td colspan="1">
		    		<c:choose>
		    		<c:when test="${page<pages}"><a href="westeros/score?page=${page+1}">下一页</a></c:when>
		    		<c:otherwise><a href="westeros/score?page=${page}">下一页</a></c:otherwise>
		    		</c:choose>
		    		</td>
		     		<td>
		     		<form action="westeros/score" method="post"> 
		     		到第 <input  type="text" name="page" size="3" />页 <input type="submit" value="跳转"/>
		     		</form>
		     		</td>
		    		<td colspan="2">
		      		当前页${page}/${pages}
		    		</td>
		    		</tr>
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
