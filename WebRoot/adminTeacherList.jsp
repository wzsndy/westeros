<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Administrator page</title>
	<meta content="charset=utf-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/admin.css">
	<style type="text/css">
		#teacherList table{
			width:80%;
			border:1px solid transparent;
			border-collapse:collapse;
		}
		#teacherList table tr{
			height:40px;
			border-bottom: 1px solid papayawhip;
		}
		#teacherList table tr:hover{
			background-color: papayawhip;
		}
		#teacherList table tr td{
			text-align:center;
			color:darkblue;
		}
	</style>
  </head>
  
  <body style="background:url(<%=request.getContextPath() %>/img/4.jpg) no-repeat;background-size:cover;">
  	<div class="admin">
  		<div class="admin-head">
  			<div class="logo"></div>
  			<div class="title">Westeros University</div>
  			<div class="tool">
  				<a href="">帮助</a>
  				<a href="logout">退出</a>
  				<a href="">更多</a>
  			</div>
  		</div>
  		<div class="admin-body">
  			<div class="admin-menu">
  				<div class="view">查看<span id="view_down"></span><span id="view_up"></span>
  					<div class="view_list" id="view_list">
  						<ul>
  							<li onclick="location.href='logDate'">查看日志</li>
  							<li onclick="location.href='teacher'">查看教工信息</li>
  						</ul>
  					</div>
  				</div>
  				<div class="action" id="action">操作<span id="action_down"></span><span id="action_up"></span>
  					<div class="ac_list" id="ac_list">
  						<ul>
  							<li id="changePwd">修改密码</li>
  							<li id="saveTeaMessage">录入教工信息</li>
  							<li id="createTeaAccount">创建教工账号</li>
  						</ul>
  					</div>
  				</div>
  			</div>
  			<div class="admin-content">
  				<div id="teacherList">
  				<center>
			  		<fieldset>
			    	<legend>教师信息表</legend>
			     	<table border="1">
			    	<tr><th>教工号</th><th>教工姓名</th><th>教工职位</th></tr>
			    	<s:iterator value="teachers">
			    	<tr>
			    	<td><s:property value="nomber" /></td>
			    	<td><s:property value="name" /></td>
			    	<td><s:property value="manager" /></td>
			    	</tr>
			    	</s:iterator>
			    	<tr>
			    	<td colspan="1">
			  			<c:choose>
			  			<c:when test="${page>1}"><a href="teacher?page=${page-1}">上一页</a></c:when>
			  			<c:otherwise><a href="teacher?page=${page}">上一页</a></c:otherwise>
			  			</c:choose>
			  		</td>
			   		<td>
			   			当前页${page}/${pages}
			   			<form action="teacher" method="post"> 
			   			到第 <input  type="text" name="page" size="3" />页 <input type="submit" value="跳转"/>
			   			</form>
			   		</td>
			   		<td colspan="1">
			  			<c:choose>
			  			<c:when test="${page<pages}"><a href="teacher?page=${page+1}">下一页</a></c:when>
			  			<c:otherwise><a href="teacher?page=${page}">下一页</a></c:otherwise>
			  			</c:choose>
			  		</td>
			  		</tr>
			    	</table>
			    	</fieldset>
			    </center>
  				</div>
  				<div id="changePassword">
  					<center>
  					<fieldset>
    				<legend>管理员密码修改</legend>
  					<form action="updateAdminPassword" method="post" id="updatePwdForm">
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
    								<input class="ssc" type="submit" value="提交" onclick="return confirm('确认修改管理员的密码？')"/>
    							</td>
    						</tr>
    					</table>
    				</form>
    				</fieldset>
    				</center>
  				</div>
  				<div id="saveTeacherMessage">
  					<center>
  					<fieldset>
    				<legend>录入教师信息</legend>
    				<s:form action="admin/saveTeacher" method="post">
    				<s:textfield name="teacher.nomber" label="教师工号" size="30"/>
    				<s:textfield name="teacher.name" label="教师姓名" size="30"/>
    				<s:textfield name="teacher.manager" label="教师职位" size="30"/>
    				<s:submit value="录入" cssClass="ssc"/>
    				</s:form>
    				</fieldset> 
    				</center>
  				</div>
  				<div id="createTeacherAccount">
  			    	<center>
    				<fieldset>
    				<legend>教师账号添加</legend>
     					<form action="createTeaAccount" method="post">
     					账号：<input type="text" name="account.account" size="25" maxlength="16"/><br/>
     					密码：<input type="password" name="account.pwd" size="25" maxlength="16"/><br/>
     					工号：<input id="nom" type="text" name="account.nom" size="25";/><br/>
     					<p id="suc" style="color:green;display:none;width:20px;">success!</p>
     					<input class="ssc" type="button" id="check" value="验证工号"/><br/>
     					教师级别：<select name="account.role_id">
     					<option>==请选择教师级别==</option>
     					<option value="2">教务主任</option>
     					<option value="3">教职工</option>
     					</select> <br/> 
     					<input id="submit_2" class="ssc" type="button" value="创建"/>
     					<input id="submit_1" class="ssc" type="submit" value="创建" style="display:none"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="ssc" type="reset" value="重置"/> 
    					</form>
    				</fieldset> 
    				</center>
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
	   $("#view_down").click(function(){
			$(this).hide();
			$("#view_up").show()
			$("#view_list").slideDown(500)
		})
		$("#view_up").click(function(){
			$(this).hide();
			$("#view_down").show()
			$("#view_list").slideUp(500)
		})
		$("#action_down").click(function(){
			$(this).hide();
			$("#action_up").show()
			$("#ac_list").slideDown(500)
		})
		$("#action_up").click(function(){
			$(this).hide();
			$("#action_down").show()
			$("#ac_list").slideUp(500)
		})
		$("#changePwd").click(function(){
			$("#teacherList").hide()
			$("#changePassword").show(500)
			$("#saveTeacherMessage").hide()
			$("#createTeacherAccount").hide()
		})
		$("#saveTeaMessage").click(function(){
			$("#teacherList").hide()
			$("#changePassword").hide()
			$("#createTeacherAccount").hide()
			$("#saveTeacherMessage").slideDown(500)
		})
		$("#createTeaAccount").click(function(){
			$("#teacherList").hide()
			$("#changePassword").hide()
			$("#saveTeacherMessage").hide()
			$("#createTeacherAccount").fadeIn(500)
		})
		$("#nom").click(function(){
			$("submit_1").hide()
			$("submit_2").show()
		})
		$("#check").click(function(){
			var nom=document.getElementById("nom").value;
			$.ajax({
				url:"checkCreateTeaAccount",
				type:"post",
				dataType:"json",
				data:{"nom":nom},
				success:function(check){
					if(check==0){
						alert("教工号不存在！");
					}else{
						$("#suc").show()
						$("#submit_2").hide()
						$("#submit_1").show()
					}
				}
			})
		})
	})
  </script>
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
</html>
