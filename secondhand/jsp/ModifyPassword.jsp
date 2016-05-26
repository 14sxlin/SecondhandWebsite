<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/ModifyPassword.css">
<title>修改密码</title>
</head>
<body>
	<div class="nav">
		<ul>
   		<li><a href="ModifyInfo.jsp">修改基本信息</a></li>
   		<li><a href="ModifyPassword.jsp">修改密码</a></li>
   		</ul>
	</div>
	
   <form action="" method="post" class="bootstrap-frm">
    <h1>修改密码 
    </h1>
    <label>
        <span>旧密码 :</span>
        <input id="oldpassword" type="password" name="oldpassword" placeholder="请输入旧密码" />
    </label>
    
    <label>
        <span>新密码 :</span>
        <input id="newpassword" type="password" name="newpassword" placeholder="请输入新密码" />
    </label>
    
    <label>
        <span>确认新密码 :</span>
        <input id="newpw" type="password" name="nexpw" placeholder="请再次输入新密码" />
    </label>   
     <label>
        <span>&nbsp;</span> 
        <input type="button" class="button" value="修改" /> 
    </label>    
	</form>  
</body>
</html>