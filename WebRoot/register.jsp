<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>Register Page</title>
	<meta content="charset=utf-8">
	<style type="text/css">
		*{
		margin: 0;
		padding: 0;
		list-style:none;
		}
		.admin{
		width:80%;
		margin:0 auto;
		}
		.admin-head{
		width:100%;
		height:80px;
		position:relative;
		background-color: lightgoldenrodyellow;
		border: 1px solid transparent;
		border-radius:10px;
		}
		.admin-body{
		width:100%;
		height:770px;
		border:1px solid black;
		margin:0 auto;
		overflow:hidden;
		background-color:floralwhite;
		}
		.admin-foot{
		width:100%;
		height:120px;
		background-color:darkslategrey;
		}
		.logo{
		width:60px;
		height:60px;
		border-radius:50%;
		border:1px solid black;
		position:absolute;
		top:10px;
		left:50px;
		background: url(../img/dragon.jpg) -58px -8px / 184px 105px;
		}
		.title{
			height:80px;
			width:90%;
			position:relative;
			top:0px;
			left:50px;
			line-height:80px;
			color:darkred;
			text-align:center;
			font-size:50;
			font-family: fantasy;
		}
		.tool{
			width:106px;
			height:21px;
			position:absolute;
			right:5px;
			top:55px;
		}
		fieldset{
		margin-top:5%;
		width:25%;
		}
		form{
		width:100%;
		}
		input{
		width:110px;
		}
		.ssc{
		margin:5px 0px;
		display:inline-block;
		width:80px;
		border:1px solid transparent;
		border-radius:10px;
		background-color:blue;
		color:white;
		}
		table{
			margin:0 auto;
		}
	</style>
  </head>
  
  <body>
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
  			<center>
    			<fieldset>
    					<legend>新生注册账号</legend>
     					<form action="createStuAccount" method="post">
     					<table>
     						<tr><td>账号：</td><td><input type="text" name="account.account" size="25" maxlength="16"/></td></tr>
     						<tr><td>密码：</td><td><input type="password" name="account.pwd" size="25" maxlength="16"/></td></tr>
     						<tr><td>学号：</td><td><input id="nom" type="text" name="account.nom" size="25";/></td></tr>
     						<tr><td><input class="ssc" type="button" id="check" value="验证学号"/></td><td><p id="suc" style="color:green;display:none;width:20px;">success!</p></td></tr>
     						<tr><td><input id="submit_2" class="ssc" type="button" value="注册"/><input id="submit_1" class="ssc" type="submit" value="注册" style="display:none"/></td><td><input class="ssc" type="reset" value="重置"/></td></tr>
     					</table>
    					</form>
    			</fieldset> 
    		</center>
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
  			$("#check").click(function(){
  				var nom=document.getElementById("nom").value;
  				$.ajax({
  					url:"checkCreateStuAccount",
  					type:"post",
  					dataType:"json",
  					data:{"nom":nom},
  					success:function(check){
  						if(check==0){
  							alert("您还不是本学院学生！");
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
</html>
