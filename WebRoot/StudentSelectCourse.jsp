<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta content="charset=utf-8">
    <title>Student page</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/student.css"/>
  </head>
<body style="background:url(<%=request.getContextPath() %>/img/4.jpg) no-repeat;background-size:cover;">
<div class="admin">
  		<div class="admin-head">
  			<div class="logo"></div>
  			<div class="title">Westeros University</div>
  			<div class="tool">
  				<a href="westeros/help">帮助</a>
  				<a href="westeros/logout">退出</a>
  				<a href="">更多</a>
  			</div>
  		</div>
  		<div class="student-page">
    		<div class="student-title">${student.name}同学，欢迎登陆维斯特洛学院</div>
    		<div class="student-menu">
    			<ul>
    			<li><a href="westeros/checkStudent">基本信息</a></li>
    			<li><a href="westeros/modifyPassword?id=${student.id}">修改密码</a></li>
    			<li><a href="westeros/score">查询成绩</a></li>
    			<li><a href="westeros/course">已选课程</a></li>
    			<li><a href="westeros/sel">选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课</a></li>
    			</ul>
    		</div>
    		<div class="student-content">
    			<fieldset class="course_yes">
    			<legend>必修课课程表</legend>
    				<table border="1" cellpadding="0" cellspacing="0" style="margin:0 auto;text-align:center">
    					<tr><th>课程名</th><th style="border-left:1px solid white;border-right:1px solid white;">所属专业</th><th>描述</th></tr>
    					<s:iterator value="reqCourses">
     					<tr>
     					<td><s:property value="name"/></td>
    		 			<td style="border-left:1px solid white;border-right:1px solid white;">
    		 			<s:iterator value="majors">
    		 			<s:if test="id==major_id">
    		 			<s:property value="name"/>
    		 			</s:if>
    		 			</s:iterator>
    		 			</td>
     					<td><s:property value="text"/></td>
     					</tr>
    					</s:iterator>
    				</table>
    			</fieldset>
    			<fieldset class="course_no">
    			<legend>选修课课程表</legend>
    				<table border="1" cellpadding="0" cellspacing="0" style="margin:0 auto;text-align:center">
   	 					<tr><th>课程名</th><th>所属专业</th><th>描述</th></tr>
    					<s:iterator value="notReqCourses">
     					<tr>
     					<td><s:property value="name"/></td>
     					<td>All</td>
     					<td><s:property value="text"/></td>
     					</tr>   
    					</s:iterator>  
    					</table>
    			</fieldset>
    			<fieldset class="selectCourse">
    				<legend style="text-align:center">课程选择</legend>
    				<form action="westeros/select" method="post">
    				<table style="margin:0 auto;text-align:center">
    				<s:iterator value="notReqCourses">
    				<tr><td><input type="checkbox"  name="courseIds" value="<s:property value="id"/>" /></td><td><s:property value="name"/></td></tr>
     				</s:iterator>
     				</table>
     				<input id="ssc" type="submit" value="提交" onclick="return confirm('是否确认选课？')"/>
    				</form>
    			</fieldset>
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
<script>
 $(function(){
   if($(":checkbox").size()>=3){
         $(":checkbox").removeAttr("checked");
         $(":checkbox").attr("disabled","disabled");
         $(":checkbox").removeAttr("disabled");
     }

    var num = 0;
    $(":checkbox").each(function(){
        $(this).click(function(){
            if($(this)[0].checked) {
                ++num;
                if(num == 3) {
                    //alert("最多选择 三项 的上限已满, 其他选项将会变为不可选.");
                    $(":checkbox").each(function(){
                        if(!$(this)[0].checked) {
                            $(this).attr("disabled", "disabled");
                        }
                    });
                }
            } else {
                --num;
                if(num <= 2) {
                    $(":checkbox").each(function(){
                        if(!$(this)[0].checked) {
                            $(this).removeAttr("disabled");
                        }
                    });
                }
            }
        });
    });
})
</script>

</html>    

