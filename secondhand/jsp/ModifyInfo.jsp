<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/ModifyInfo.css">
<title>修改基本信息</title>
</head>

<body>
	<div class="nav">
		<ul>
   		<li><a href="ModifyInfo.jsp">修改基本信息</a></li>
   		<li><a href="ModifyPassword.jsp">修改密码</a></li>
   		</ul>
	</div>
   
   
   <form action="" method="post" class="bootstrap-frm">
   <h1>修改基本信息</h1>
   
   <label>
        <span>用户名 :</span>
        <input id="username" type="text" name="username" placeholder="请输入用户名" />
   </label>
    
    <label>
        <span>长号 :</span>
        <input id="phonelongnumber" type="text" name="phonelongnumber" placeholder="请输入手机长号" />
    </label>
    
    <label>
        <span>短号 :</span>
        <input id="phoneshortnumber" type="text" name="phoneshortnumber" placeholder="请输入手机短号" />
    </label>   
     <label>
        <span>&nbsp;</span> 
        <input type="button" class="button" value="修改" /> 
    </label>    
</form>
	
</body>
</html>