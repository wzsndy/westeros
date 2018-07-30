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
    			<div class="student-title">单科成绩修改</div>
    			<ul>
    			<li><a href="checkTeacher">班级信息</a></li>
    			<li><a href="gradeScore">查询成绩</a></li>
    			</ul>
    		</div>
    		<div class="student-content">
    			<center>
    				<form action="counsellor/updatesave" method="post">
    				<h4>${student.name}同学
    					<c:forEach var="course" items="${courses}">
				     	<c:if test="${course.id==score.course_id}">
				     		${course.name}
				     	</c:if>
				     </c:forEach>
				            成绩修改
    				</h4>
    				<input type="text" value="${score.score }" name="score.score" id="score.score" /><br>
    				<input class="submit" type="submit" value="提交" onclick="return confirm('确认修改')"/>
    				</form>
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
