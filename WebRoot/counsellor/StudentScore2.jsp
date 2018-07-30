<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Student page</title>
	<meta content="charset=utf-8">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/counsellor.css"/>
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
    		<div class="student-title">${account.account}导师，欢迎登陆维斯特洛学院</div>
    		<div class="student-menu">
    			<div class="student-title">学生个人成绩</div>
    			<ul>
    			<li><a href="checkTeacher">班级信息</a></li>
    			<li><a href="gradeScore">查询成绩</a></li>
    			</ul>
    		</div>
    		<div class="student-content">
    			<center>
				<table border="1" cellpadding="0" cellspacing="0">
				<tr><td colspan=6><span id="Scor">${student.name}的成绩列表</span></td></tr>
				<tr><td>考试时间</td><td>考试科目</td><td>学生学号</td><td>分数</td><td>学期</td><td>操作</td></tr>
				<c:forEach items="${scores}"  var="score">
					
				     <tr>
				     <td>${score.year }</td>
				     <td>
				     <c:forEach var="course" items="${courses}">
				     	<c:if test="${course.id==score.course_id}">
				     		${course.name}
				     	</c:if>
				     </c:forEach>
				     </td>
				     <td>${score.stu_no }</td>
				     <td>${score.score }</td>
				     <td>${score.term }</td>
				     <td><p class="submit" onclick="location.href='updatescore?id=${score.id }'">编辑</p></td>
				     </tr>
				     
				</c:forEach>
				</table>
				</center>
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
