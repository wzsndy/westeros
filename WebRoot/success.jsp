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
    			<h3 style="text-align:center">创建成功，请牢记账号：${account.account}、登陆号：${account.nom}，以及密码。</h3>
    		</center>
  		</div>
  		<div class="admin-foot">
  		<center>
  			<h4 style="color:red">Westeros Ice and Fire</h4>
  		</center>
  		</div>
    </div>
  </body>
</html>
