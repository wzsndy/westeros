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
    			<div class="student-title">班级学生列表</div>
    			<ul>
    			<li><a href="checkTeacher">班级信息</a></li>
    			<li><a href="gradeScore">查询成绩</a></li>
    			</ul>
    		</div>
    		<div class="student-content">
    			<div id="counsellor">
    			<table>
    				<tr>
     					<td>学生Id</td>
     					<td>学生姓名</td>
     					<c:forEach items="${scores1}" var="sc">
     						<td>${sc.course1.name}(科目)</td>
     					</c:forEach>
     				</tr>
     				<c:forEach items="${students}" var="stu">
     				<tr>
     					<td>${stu.id }</td>
     					<td>${stu.name }</td>
     					<c:forEach items="${scores1}" var="sc2">
     						<c:if test="${stu.nom==sc2.studentNom}">
     						<td>${sc2.score}分</td>
     						</c:if>
     					</c:forEach>
     				</tr>
     				</c:forEach>
				 </table>
				 </div>
				 <div id="addStudentBox">
				 	<form action="addstudent" method="post">
				    <table>
				    <tr><td>Name:</td><td><input type="text" name="student.name" id="student.name" value=""/></td></tr>
				    <tr><td>Birthday:</td><td><input type="text" name="student.birthday"  id="student.birthday" value=""/></td></tr>
				    <tr><td>College:</td>
				    	<td>
				    		<select name="student.college_id">
				    		<option value="0">==请选择院系==</option>
				    		<c:forEach var="college" items="${colleges}">
				     			<option value="${college.id}">${college.name}</option>
				     		</c:forEach>
				    		</select>
				    	</td>
				    </tr>
				    <tr><td>Major:</td>
					    <td>
					    	<select name="student.major_id" id="majorSel">
				    		<option value="0">==请选择专业==</option>
				    		<c:forEach var="major" items="${majors}">
				     			<option value="${major.id}">${major.name}</option>
				     		</c:forEach>
				    		</select>
					    </td>
				    </tr>
				    <tr><td>Grade:</td>
				    	<td>
				    		<select name="student.grade_id" id="gradeSel">
				    		<option value="0">==请选择班级==</option>
				    		<c:forEach var="grade" items="${grades}">
				     			<option value="${grade.id}">${grade.name}</option>
				     		</c:forEach>
				    		</select>
				    	</td>
				    </tr>
				    <tr><td colspan=2><input class="submit" type="submit" value="提交"/><input id="upup" class="submit" type="button" value="收起"/></td></tr>
				    </table>
				    </form>
				 </div>
    		</div>
    	</div>
    	<div class="admin-foot">
    	<center>
  			<h4 style="color:red">Westeros Ice and Fire</h4>
  		</center>
    	</div>
  </div>
  </body>
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.3.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$("#addStudent").click(function(){
	  		  	$("#addStudentBox").slideDown(500)
	  		 })
	  	$("#upup").click(function(){
	  		$("#addStudentBox").slideUp(500)
		  	})
  	  	})
  </script>
</html>
