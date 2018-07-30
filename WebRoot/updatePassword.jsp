<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Student page</title>
	<meta content="charset=utf-8">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/student.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
		function check1(pwd){
			var pw=document.getElementById("accountpwd").value;
			if(pwd==""){
				$("#pwdCheck_1").slideDown(100);
				$("#pwdCheck_1").slideUp(2000);
			}else if(pw!=pwd){
				$("#pwdCheck_2").slideDown(100);
				$("#pwdCheck_2").slideUp(2000);
			}
		}
		function check2(pwd){
			if(pwd==""){
				$("#newCheck_1").slideDown(100);
				$("#newCheck_1").slideUp(2000);
			}
		}
		function check3(pwd){
			var pwd1=document.getElementById("new_pwd").value;
			if(pwd!==""){
				if(pwd!=pwd1){
					$("#newCheck_2").slideDown(100);
					$("#newCheck_2").slideUp(2000);
				}
			}else{
				$("#newCheck_3").slideDown(100);
				$("#newCheck_3").slideUp(2000);
			}	
		}
	</script>
  </head>
  <body  style="background:url(<%=request.getContextPath() %>/img/4.jpg) no-repeat;background-size:cover;">
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
    			<li><a href="score">查询成绩</a></li>
    			<li><a href="westeros/course">已选课程</a></li>
    			<li><a href="sel">选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课</a></li>
    		</ul>
    	</div>
    	<div class="student-passowrd">
    	<form action="updatePassword" method="post">
    		<table>
    			<tr><td colspan=2 class="t-head">密码修改</td></tr>
    			<tr>
    				<td>初始密码：</td>
    				<td class="password_input">
    					<input type="password" value="" name="old_pwd" id="old_pwd" onblur="check1(this.value)"/>
    					<input type="hidden" value="${account.pwd}" id="accountpwd"/>
    					<span id="pwdCheck_1">请填入初始密码！</span>
    					<span id="pwdCheck_2">请填入正确密码！</span>
    				</td>
    			</tr>
    			<tr>
    				<td>新密码：</td>
    				<td class="password_input">
    					<input type="password" value="" name="new_pwd" id="new_pwd" onblur="check2(this.value)"/>
    					<span id="newCheck_1">新密码不能为空！</span>
    				</td>
    			</tr>
    			<tr>
    				<td>确认密码：</td>
    				<td class="password_input">
    					<input type="password" value="" name="pwd" id="pwd" onblur="check3(this.value)"/>
    					<span id="newCheck_2">请填入相同密码！</span>
    					<span id="newCheck_3">确认密码不能为空！</span>
    				</td>
    			</tr>
    			<tr>
    				<td colspan=2 class="password_input">
    					<input id="ssc" type="submit" value="提交" onclick="return confirm('确认修改'+${student.name}+'的密码？')"/>
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
</html>
