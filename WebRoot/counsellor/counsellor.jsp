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
     				<tr><td>Id</td><td>Nomber</td><td>Name</td><td>Birthday</td><td>College</td><td>Major</td><td>Grade</td></tr>
     				<c:forEach items="${students}"  var="student">
     				<tr>
     				<td>${student.id }</td>
				     <td>${student.nomber }</td>
				     <td>${student.name }</td>
				     <td>${student.birthday }</td>
				     <c:forEach var="college" items="${colleges}">
				     	<c:if test="${college.id==student.college_id}">
				     		<td>${college.name}</td>
				     	</c:if>
				     </c:forEach>
				     <c:forEach var="major" items="${majors}">
				     	<c:if test="${major.id==student.major_id}">
				     		<td>${major.name}</td>
				     	</c:if>
				     </c:forEach>
				     <c:forEach var="grade" items="${grades}">
				     	<c:if test="${grade.id==student.grade_id}">
				     		<td>${grade.name}</td>
				     	</c:if>
				     </c:forEach>
				     <td><a href="modify?id=${student.id}" >修改</a></td>
				     <td><a href="delete?id=${student.id }">删除</a></td>
				     <td><a href="findscore?nomber=${student.nomber} ">成绩管理</a></td>
				     </tr>
				     </c:forEach>
				     <tr><td colspan=10 style="text-align:center;"><a id="addStudent" class="submit">添加</a></td></tr>
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
				    		<input type="hidden" name="student.nomber" value="33"+/>
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
