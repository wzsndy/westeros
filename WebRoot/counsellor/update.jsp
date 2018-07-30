<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Student page</title>
	<meta content="charset=utf-8">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/counsellor.css"/>
	<style type="text/css">
	*{margin:0;padding:0;list-style:none;}
    a,a:hover{ text-decoration:none;}
    pre{font-family:'微软雅黑'}
    .box{width:970px; padding:10px 20px; background-color:#fff; margin:10px auto;}
    .box a{padding-right:20px;}
    .demo1{margin:5px 0;}
    .layinput{height: 22px;line-height: 22px;width: 150px;margin: 0;}
	</style>
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
    			<div class="student-title">${student.name}信息修改</div>
    			<ul>
    			<li><a href="checkTeacher">班级信息</a></li>
    			<li><a href="gradeScore">查询成绩</a></li>
    			</ul>
    		</div>
    		<div class="student-content">
    			<form action="counsellor/updateaa" method="post" id="modifyStudentForm">
				<table>
				<tr><td colspan=2 class="t-head">学员信息修改</td></tr>
				<tr>
				<td style="text-align:right">Name:</td>
				<td class="a">
				<input type="text" value="${student.name }" name="student.name" id="student.name" />
				</td>
				</tr>
				<tr>
				<td style="text-align:right">Birthday:</td>
				<td class="b">
				<div class="demo1">
					<input class="laydate-icon" id="demo" value="${student.birthday }" name="student.birthday"> 
	    		</div>
				</td>
				</tr>
				<tr>
				<td colspan=2 class="c">
				<input type="submit" class="submit" value="提交" onclick="return confirm('确认修改'+${student.name}+'的信息？')"/>
				</td>
				</tr>
				</table> 
				</form>
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
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/laydate.js"></script>
  <script type="text/javascript">
    !function(){
    	var skins=['dahong','danlan','default','molv','qianhuang','yahui','yalan'];
        var skin="";
        var id=Math.floor(Math.random()*7);
        skin+=skins[id];
	    laydate.skin(skin);//切换皮肤，请查看skins下面皮肤库
	    laydate({elem: '#demo'});//绑定元素
    }();
   </script>
</html>
