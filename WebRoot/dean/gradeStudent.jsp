<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Dean page</title>
	<meta content="charset=utf-8">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/student.css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/dean.css"/>
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
    		<div class="student-title">${teacher.name}院长，欢迎登陆维斯特洛学院</div>
    		<div class="student-menu">
    			<ul>
    			<li><a href="findAllTeacher">基本信息</a></li>
                <li><a href="findAMajor?collegeId=${teacher.college.id}&accountNom=${teacher.nom}">专业信息</a></li>
                <li><a href="grade?teacher=${teacher}">班级信息</a></li>
    			<li><a href="updateAccount?accountNom=${teacher.nom}">修改密码</a></li>
    			<li id="addAction">添加操作<a id="add_down"></a><a id="add_up"></a>
    				<ul id="addUl">
    					<li id="addCol">添加专业</li>
    					<li id="addGra">添加班级</li>
    				</ul>
    			</li>
    			</ul>
    		</div>
	    	<div class="student-content">
	    	<div class="mian">
	    		<table style="width: 1000px">
    				<tr><td colspan=11 class="t-head" align="center" style="font-weight: 600">学生信息</td></tr>
    				<tr>
  						<th>ID</th>
  						<th>学生编号</th>
  						<th>学生姓名</th>
  						<th>学生生日</th>
  						<th>学生所属院系</th>
  						<th>学生所属专业</th>
  						<th>学生所属班级</th>
  						<th colspan="11">操作</th>
  					</tr>
  					<c:forEach items="${students}" var="student">
  					<tr align="center">
  						<td>${student.id}</td>
  						<td>${student.nom}</td>
  						<td>${student.name}</td>
  						<td>${student.birthday}</td>
  						<td>${student.college.name}</td>
  						<td>${student.major.name}</td>
  						<c:forEach items="${grades}" var="grade">
  							<c:if test="${student.gradeId==grade.id}">
  								<td>${grade.name }</td>
  							</c:if>
  						</c:forEach>
  					<td colspan="11">
  						<a onclick="return confirm('确定删除【${student.name}】学生信息吗？')" href="deleteStudent?studentId=${student.id}">删除</a>
  					</td>
  					</tr>
  					</c:forEach>
    			</table>
    			</div>
    			<div id="addMajor" style="display:none">
	  				<form action="addMajro2" method="post">
    				<table>
    				<tr><td colspan=2 class="t-head" align="center" style="font-weight: 600">添加专业信息</td></tr>
    				<tr >
    					<td style="font-weight: 600" align="right">专业名称：</td>
    					<td colspan="11">
    						<input type="hidden" name="major.collegeId" value="${collegeId}"/>
    						<input type="text" name="major.name" />
    					</td>
    				</tr>
    				<tr >
    					<td style="font-weight: 600" align="right">专业描述：</td>
    					<td colspan="11">
    						<input type="text" name="major.text"/>
    					</td>
    				</tr>
    				<tr>
    					<td colspan="11" align="center">
    						<input type="submit" value="确认添加"/>
    					</td>
    				</tr>
    				</table>
    				</form>
	  			</div>
	  			<div id="addGrade">
	  				<form action="addGrade2" method="post" >
    				<table>
    				<tr><td colspan=11 class="t-head" align="center" style="font-weight: 600">添加班级信息</td></tr>
    				<tr>
    					<td style="font-weight: 600" align="right" >班级名称：</td>
    					<td colspan="11">
    						<s:textfield name="grade.name" id="grade_name" theme="simple"></s:textfield>
    						<input type="hidden" name="grade.college_id" value="${collegeId}"/>
    					</td>
    				</tr>
    				<tr>
    					<td style="font-weight: 600" align="right">班级所属专业：</td>
    					<td colspan="11">
    						<s:select name="grade.major_id"  list="majors" listKey="Id" listValue="Name" headerKey="1" headerValue="====请选择专业=====" theme="simple"/>
    					</td>
    				</tr>
    				<tr>
    					<td style="font-weight: 600" align="right">班级所属辅导员：</td>
    					<td colspan="11">
    						<s:select name="grade.teacher.id"  list="teachers" listKey="Id" listValue="Name" headerKey="1" headerValue="====请选择辅导员=====" theme="simple"/>
    					</td>
    				</tr>
    				<tr>
    					<td colspan="11" align="center">
    						<input type="submit" value="确认添加"/>
    					</td>
    				</tr>
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
  		$("#add_down").click(function(){
  	  		$("#addUl").slideDown(500)
  	  		$("#add_down").hide()
  	  		$("#add_up").show()
  	  	})
  	  	$("#add_up").click(function(){
  	  		$("#addUl").slideUp(500)
  	  		$("#add_down").show()
  	  		$("#add_up").hide()
  	  	})
  	  	$("#addCol").click(function(){
  	  	  	$(".main").hide()
  	  	  	$("#addGrade").hide()
  	  	  	$("#addMajor").slideDown(500)
  	  	})
  	  	$("#addGra").click(function(){
  	  	  	$(".main").hide()
  	  	  	$("#grade_name").text("")
  	  	  	$("#addMajor").hide()
  	  	  	$("#addGrade").slideDown(500)
  	  	})
  	</script>
</html>
