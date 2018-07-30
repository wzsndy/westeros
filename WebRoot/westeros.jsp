<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<meta content="charset=UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css"/>
	</head>
	<body style="background-color:lightgoldenrodyellow">
	<div class="login-box" id="login-box" style="background: url(../img/2.jpg);">
    	<div class="login-header">
    		<h1>Westeros University</h1>
    	</div>
    	<div class="login-body">
    		<form action="landingRequest" method="post" class="login-form">
    			<div class="login-text">
    				<label class="login-label">
    					<img alt="" src="<%=request.getContextPath() %>/img/login-account.jpg">
    					<input type="text" name="account.nom" placeholder="Account" class="login-input" maxlength="6"/>
    				</label>
    			</div>
    			<div class="login-text">
    				<label class="login-label">
    					<img alt="" src="<%=request.getContextPath() %>/img/login-password.jpg">
    					<input type="password" name="account.pwd" placeholder="Password" class="login-input" maxlength="16"/>
    				</label>
    			</div>
    			<div class="login-foot">
    				<div class="login-action">
    					<input id="button" type="button" onclick="location.href='register'" value="Register"/>
    				</div>
    				<div class="login-action">
    					<input type="submit" value="LoginIn" />
    				</div>
    			</div>
    		</form>
    	</div>
    	<div class="login-label"><span id="admin">管理员登录</span><span onclick="location.href='register'">新生注册</span></div>
    </div>
    <div class="login-admin" id="login-admin" style="background: url(<%=request.getContextPath() %>/img/dragon.jpg) 0 0 / 1280px 800px;">
    	<div class="admin-header">
    		<h1>Welcom Admin</h1>
    	</div>
    	<div class="admin-body">
    		<form action="adminLandingRequest" method="post" class="admin-form">
    			<div class="login-text">
    				<label class="login-label">
    					<img alt="" src="<%=request.getContextPath() %>/img/login-account.jpg">
    					<input type="text" name="account.account" placeholder="Account" class="login-input" maxlength="6"/>
    				</label>
    			</div>
    			<div class="login-text">
    				<label class="login-label">
    					<img alt="" src="<%=request.getContextPath() %>/img/login-password.jpg">
    					<input type="password" name="account.pwd" placeholder="Password" class="login-input" maxlength="16"/>
    				</label>
    			</div>
    			<div class="login-foot">
    				<div class="login-action">
    					<input type="submit" value="LoginIn" />
    				</div>
    				<div class="admin-label"><span id="user">用户登陆</span></div>
    			</div>
    		</form>
    	</div>
    </div>
	</body>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#admin").click(function(){
					$("#login-box").slideUp(1000)
					$("#login-box").css("background","url(../img/2.jpg)")
					
					$("#login-admin").css("background","url(../img/dragon.jpg) no-repeat")
					$("#login-admin").slideDown(1000)
				})
				$("#user").click(function(){
					$("#login-admin").slideUp(1000)
					$("#login-admin").css("background","url(../img/dragon.jpg) no-repeat")
					
					$("#login-box").css("background","url(../img/2.jpg)")
					$("#login-box").slideDown(1000)
				})
				
			})
		</script>
</html>
